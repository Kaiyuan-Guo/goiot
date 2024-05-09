package pers.gky.plugin.thing;

import pers.gky.plugin.thing.actions.ActionResult;
import pers.gky.plugin.thing.actions.IDeviceAction;
import pers.gky.plugin.thing.model.ThingDevice;
import pers.gky.plugin.thing.model.ThingProduct;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 11:01
 * @description 设备服务接口
 */
public interface IThingService {
    /**
     * 提交设备行为
     *
     * @param action IDeviceAction
     * @return result
     */
    ActionResult post(IDeviceAction action);

    // ActionResult post(String pluginId, IDeviceAction action);

    /**
     * 获取产品信息
     *
     * @param pk 产品key
     * @return Product
     */
    ThingProduct getProduct(String pk);

    /**
     * 获取设备信息
     *
     * @param deviceName 设备dn
     * @return DeviceInfo
     */
    ThingDevice getDevice(String deviceName);

    /**
     * 获取设备当前属性数据
     *
     * @param deviceName 设备dn
     * @return 当前属性
     */
    Map<String, ?> getProperty(String deviceName);

}
