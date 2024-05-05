package pers.gky.plugin.thing;

import pers.gky.plugin.thing.actions.ActionResult;
import pers.gky.plugin.thing.actions.down.DeviceConfig;
import pers.gky.plugin.thing.actions.down.PropertyGet;
import pers.gky.plugin.thing.actions.down.PropertySet;
import pers.gky.plugin.thing.actions.down.ServiceInvoke;

/**
 * @author gky
 * @date 2024/05/04 11:01
 * @description 设备接口
 */
public interface IDevice {
    /**
     * 执行设备配置动作
     *
     * @param action 动作
     * @return result
     */
    ActionResult config(DeviceConfig action);

    /**
     * 执行设备属性获取动作
     *
     * @param action 动作
     * @return result
     */
    ActionResult propertyGet(PropertyGet action);

    /**
     * 执行设备属性设置动作
     *
     * @param action 动作
     * @return result
     */
    ActionResult propertySet(PropertySet action);

    /**
     * 执行设备服务调用动作
     *
     * @param action 动作
     * @return result
     */
    ActionResult serviceInvoke(ServiceInvoke action);

}
