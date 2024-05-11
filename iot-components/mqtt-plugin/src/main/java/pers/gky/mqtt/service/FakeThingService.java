package pers.gky.mqtt.service;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import pers.gky.plugin.thing.IThingService;
import pers.gky.plugin.thing.actions.ActionResult;
import pers.gky.plugin.thing.actions.IDeviceAction;
import pers.gky.plugin.thing.model.ThingDevice;
import pers.gky.plugin.thing.model.ThingProduct;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试服务
 *
 * @author sjg
 */
@Slf4j
public class FakeThingService implements IThingService {

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
        log.info("post action:{}", action);
        return ActionResult.builder().code(0).build();
    }


    @Override
    public ThingProduct getProduct(String pk) {
        return ThingProduct.builder()
                .productKey(pk)
                .productSecret(PRODUCTS.get(pk))
                .build();
    }

    @Override
    public ThingDevice getDevice(String dn) {
        return ThingDevice.builder()
                .productKey(DEVICES.get(dn))
                .deviceName(dn)
                .build();
    }

    @Override
    public Map<String, ?> getProperty(String dn) {
        return new HashMap<>(0);
    }
}
