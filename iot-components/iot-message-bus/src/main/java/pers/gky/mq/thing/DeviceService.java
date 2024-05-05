package pers.gky.mq.thing;

/**
 * @author gky
 * @date 2024/05/01 20:10
 * @description 通用设备服务
 */
public interface DeviceService {
    /**
     * 通用设备服务
     * @param service 服务
     */
    void invoke(ThingService<?> service);
}
