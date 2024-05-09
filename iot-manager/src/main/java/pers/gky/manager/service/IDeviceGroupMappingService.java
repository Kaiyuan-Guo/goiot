package pers.gky.manager.service;

import pers.gky.manager.model.entity.DeviceGroupMapping;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 设备组映射 服务类
 * </p>
 *
 * @author gky
 * @since 2024-05-06
 */
public interface IDeviceGroupMappingService extends IService<DeviceGroupMapping> {
    DeviceGroupMapping findByDeviceIdAndGroupId(String deviceId, String groupId);
}
