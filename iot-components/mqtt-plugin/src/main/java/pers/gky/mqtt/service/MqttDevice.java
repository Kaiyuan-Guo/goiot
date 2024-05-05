package pers.gky.mqtt.service;

import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.gky.common.enums.ErrCode;
import pers.gky.common.exception.BizException;
import pers.gky.plugin.thing.IDevice;
import pers.gky.plugin.thing.actions.ActionResult;
import pers.gky.plugin.thing.actions.down.DeviceConfig;
import pers.gky.plugin.thing.actions.down.PropertyGet;
import pers.gky.plugin.thing.actions.down.PropertySet;
import pers.gky.plugin.thing.actions.down.ServiceInvoke;

/**
 * @author gky
 * @date 2024/05/02 17:52
 * @description mqtt设备下行接口
 */
@Service
public class MqttDevice implements IDevice {
    @Autowired
    private MqttVerticle mqttVerticle;

    @Override
    public ActionResult config(DeviceConfig action) {
        return ActionResult.builder().code(0).reason("").build();
    }

    @Override
    public ActionResult propertyGet(PropertyGet action) {
        String topic=String.format("/sys/%s/%s/c/service/property/get",action.getProductKey(),action.getDeviceName());
        return send(
                topic,
                action.getDeviceName(),
                new JsonObject()
                        .put("id",action.getId())
                        .put("method","thing.service.property.get")
                        .put("params",action.getKeys())
                        .toString()
        );
    }

    @Override
    public ActionResult propertySet(PropertySet action) {
        String topic=String.format("/sys/%s/%s/c/service/property/set",action.getProductKey(),action.getDeviceName());
        return send(
                topic,
                action.getDeviceName(),
                new JsonObject()
                        .put("id",action.getId())
                        .put("method","thing.service.property.set")
                        .put("params",action.getParams())
                        .toString()
        );
    }

    @Override
    public ActionResult serviceInvoke(ServiceInvoke action) {
        String topic = String.format("/sys/%s/%s/c/service/%s", action.getProductKey(), action.getDeviceName(), action.getName());
        return send(
                topic,
                action.getDeviceName(),
                new JsonObject()
                        .put("id", action.getId())
                        .put("method", "thing.service." + action.getName())
                        .put("params", action.getParams())
                        .toString()
        );
    }

    private ActionResult send(String topic,String deviceName,String payload){
        try {
            mqttVerticle.publish(
                    deviceName,
                    topic,
                    payload
            );
            return ActionResult.builder().code(0).reason("").build();
        }catch (BizException e){
            return ActionResult.builder().code(e.getCode()).reason(e.getMessage()).build();
        }catch (Exception e){
            return ActionResult.builder().code(ErrCode.UNKNOWN_EXCEPTION.getCode()).reason(e.getMessage()).build();
        }
    }
}
