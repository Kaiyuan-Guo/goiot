package pers.gky.mqtt.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.gky.common.constant.Constants;
import pers.gky.common.enums.ErrCode;
import pers.gky.common.exception.BizException;
import pers.gky.common.utils.DeviceUtil;
import pers.gky.common.utils.UniqueIdUtil;
import pers.gky.data.manager.IDeviceInfoData;
import pers.gky.data.manager.IProductData;
import pers.gky.model.device.DeviceInfoDTO;
import pers.gky.mq.core.MqProducer;
import pers.gky.mq.thing.ThingModelMessage;
import pers.gky.plugin.thing.IThingService;
import pers.gky.plugin.thing.actions.ActionResult;
import pers.gky.plugin.thing.actions.ActionType;
import pers.gky.plugin.thing.actions.IDeviceAction;
import pers.gky.plugin.thing.actions.up.*;
import pers.gky.plugin.thing.model.ThingDevice;
import pers.gky.plugin.thing.model.ThingProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author gky
 * @date 2024/05/09 21:59
 * @description
 */
@Slf4j
@Service
public class ThingServiceImpl implements IThingService {
    @Autowired
    private IProductData productData;

    @Autowired
    private IDeviceInfoData deviceInfoData;

    @Autowired
    private MqProducer<ThingModelMessage> producer;

    /**
     * 添加测试产品
     */
    private static final Map<String, String> PRODUCTS = Map.of(
            "hbtgIA0SuVw9lxjB", "xdkKUymrEGSCYWswqCvSPyRSFvH5j7CU",
            "Rf4QSjbm65X45753", "xdkKUymrEGSCYWswqCvSPyRSFvH5j7CU",
            "cGCrkK7Ex4FESAwe", "xdkKUymrEGSCYWswqCvSPyRSFvH5j7CU"
    );

    /**
     * 添加测试设备
     */
    private static final Map<String, String> DEVICES = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            DEVICES.put("TEST:GW:" + StrUtil.fillAfter(i + "", '0', 6), "hbtgIA0SuVw9lxjB");
            DEVICES.put("TEST_SW_" + StrUtil.fillAfter(i + "", '0', 6), "Rf4QSjbm65X45753");
            DEVICES.put("TEST_SC_" + StrUtil.fillAfter(i + "", '0', 6), "cGCrkK7Ex4FESAwe");
        }
    }

    @Override
    public ActionResult post(IDeviceAction action) {
        try {
            log.info("receive action:{}", action);
            String deviceName = action.getDeviceName();

            DeviceInfoDTO device = getDeviceInfo(deviceName);
            if (device == null) {
                log.warn("device:{} is not found.", deviceName);
            }
            ActionType type = action.getType();
            switch (type) {
                case REGISTER:
                    // 设备注册
                    registerDevice(device, (DeviceRegister) action, null);
                    break;
                case STATE_CHANGE:
                    // 状态更改
                    publishMessage(
                            device, action,
                            ThingModelMessage.builder()
                                    .type(ThingModelMessage.TYPE_STATE)
                                    .identifier(((DeviceStateChange) action).getState().getState())
                                    .time(System.currentTimeMillis())
                                    .build()
                    );
                    break;
                case PROPERTY_REPORT:
                    // 属性上报
                    PropertyReport propertyReport = (PropertyReport) action;
                    publishMessage(
                            device, action,
                            ThingModelMessage.builder()
                                    .type(ThingModelMessage.TYPE_PROPERTY)
                                    .identifier(ThingModelMessage.ID_PROPERTY_REPORT)
                                    .data(propertyReport.getParams())
                                    .time(propertyReport.getTime())
                                    .occurred(propertyReport.getTime())
                                    .build()
                    );
                    break;
                case SERVICE_REPLY:
                    // 服务响应
                    ServiceReply serviceReply = (ServiceReply) action;
                    publishMessage(
                            device, action,
                            ThingModelMessage.builder()
                                    .type(ThingModelMessage.TYPE_SERVICE)
                                    .identifier(serviceReply.getName() + "_reply")
                                    .mid(serviceReply.getReplyId())
                                    .code(serviceReply.getCode())
                                    .data(serviceReply.getParams())
                                    .time(serviceReply.getTime())
                                    .build()
                    );
                    break;
                case TOPOLOGY:
                    // 设备拓扑
                    deviceTopologyUpdate(device, (DeviceTopology) action);
                    break;
                default:
                    return ActionResult.builder().code(ErrCode.PARAMS_EXCEPTION.getCode()).build();
            }

            return new ActionResult();
        } catch (Throwable e) {
            log.error("action process error", e);
            return ActionResult.builder().code(1).reason(e.getMessage()).build();
        }
    }

    @Override
    public ThingProduct getProduct(String pk) {
        /*try {
            ProductDTO product = productData.findByProductKey(pk);
            if (product == null) {
                return null;
            }
            return ThingProduct.builder()
                    .productKey(product.getProductKey())
                    .name(product.getName())
                    .nodeType(product.getNodeType())
                    .productSecret(product.getProductSecret())
                    .build();
        } catch (Throwable e) {
            log.error("get product error", e);
            return null;
        }*/
        return ThingProduct.builder()
                .productKey(pk)
                .productSecret(PRODUCTS.get(pk))
                .build();
    }

    @Override
    public ThingDevice getDevice(String deviceName) {
        /*DeviceInfoDTO deviceInfo = getDeviceInfo(deviceName);
        if (deviceInfo == null) {
            return null;
        }
        return ThingDevice.builder()
                .deviceId(deviceInfo.getDeviceId())
                .deviceName(deviceInfo.getDeviceName())
                .model(deviceInfo.getModel())
                .productKey(deviceInfo.getProductKey())
                .secret(deviceInfo.getSecret())
                .build();*/
        return ThingDevice.builder()
                .productKey(DEVICES.get(deviceName))
                .deviceName(deviceName)
                .build();
    }

    public DeviceInfoDTO getDeviceInfo(String deviceName) {
        try {
            return deviceInfoData.findByDeviceName(deviceName);
        } catch (Throwable e) {
            log.error("get device error", e);
            return null;
        }
    }

    @Override
    public Map<String, ?> getProperty(String deviceName) {
        return null;
    }

    private String registerDevice(DeviceInfoDTO device, DeviceRegister register, String parentId) {
        String productKey = register.getProductKey();
        // 指定了pk需验证
        if (StrUtil.isNotBlank(productKey)) {
            ThingProduct product = getProduct(productKey);
            if (product == null) {
                throw new BizException(ErrCode.PRODUCT_NOT_FOUND);
            }
        }

        if (device != null) {
            log.info("device already registered");
            if (parentId != null) {
                device.setParentId(parentId);
                deviceInfoData.save(device);
            }
            return device.getDeviceId();
        } else {
            // 不存在，注册新设备
            DeviceInfoDTO deviceInfo = new DeviceInfoDTO();
            deviceInfo.setId(DeviceUtil.newDeviceId(register.getDeviceName()));
            deviceInfo.setDeviceId(deviceInfo.getId());
            deviceInfo.setProductKey(productKey);
            deviceInfo.setDeviceName(register.getDeviceName());
            deviceInfo.setModel(register.getModel());
            deviceInfo.setParentId(parentId);
            deviceInfo.setSecret(DeviceUtil.newSecret(16));
            // 默认离线
            deviceInfo.setState(new DeviceInfoDTO.State(false, null, null));
            deviceInfo.setCreateAt(System.currentTimeMillis());
            deviceInfoData.save(deviceInfo);

            log.info("device registered:{}", JSONUtil.toJsonStr(deviceInfo));
            publishMessage(
                    deviceInfo,
                    register,
                    ThingModelMessage.builder()
                            .type(ThingModelMessage.TYPE_LIFETIME)
                            .identifier("register")
                            .time(System.currentTimeMillis())
                            .build()
            );
            return deviceInfo.getDeviceId();
        }
    }

    private void deviceTopologyUpdate(DeviceInfoDTO device, DeviceTopology topology) {
        // 设备拓扑关系更新
        for (String deviceName : topology.getSubDevices()) {
            DeviceInfoDTO subDevice = getDeviceInfo(deviceName);
            subDevice.setParentId(device.getDeviceId());
            deviceInfoData.save(subDevice);
        }
    }

    private void publishMessage(DeviceInfoDTO device, IDeviceAction action, ThingModelMessage message) {
        try {
            message.setId(UUID.randomUUID().toString());
            message.setMid(UniqueIdUtil.newRequestId());
            message.setDeviceId(device.getDeviceId());
            message.setProductKey(device.getProductKey());
            message.setDeviceName(device.getDeviceName());
            message.setUid(device.getUid());
            if (message.getOccurred() == null) {
                message.setOccurred(action.getTime());
            }
            if (message.getTime() == null) {
                message.setTime(System.currentTimeMillis());
            }
            if (message.getData() == null) {
                message.setData(new HashMap<>(0));
            }

            log.info("publish thingModel msg:{}", message);
            producer.publish(Constants.THING_MODEL_MESSAGE_TOPIC, message);
        } catch (Throwable e) {
            log.error("send thing model message error,", e);
        }
    }
}























