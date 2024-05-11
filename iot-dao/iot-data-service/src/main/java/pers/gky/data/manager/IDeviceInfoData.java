package pers.gky.data.manager;

import pers.gky.data.IOwnedData;
import pers.gky.model.device.DeviceInfoDTO;

/**
 * @author gky
 * @date 2024/05/10 10:55
 * @description 设备接口
 */
public interface IDeviceInfoData extends IOwnedData<DeviceInfoDTO,String> {
    /**
     * 根据deviceName查找设备
     */
    DeviceInfoDTO findByDeviceName(String deviceName);

}
