package pers.gky.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.gky.data.dao.DeviceGroupMappingMapper;
import pers.gky.data.entity.DeviceGroupMapping;
import pers.gky.data.service.IDeviceGroupMappingService;

/**
 * <p>
 * 设备组映射 服务实现类
 * </p>
 *
 * @author gky
 * @since 2024-05-06
 */
@Service
public class DeviceGroupMappingServiceImpl extends ServiceImpl<DeviceGroupMappingMapper, DeviceGroupMapping> implements IDeviceGroupMappingService {
    private final DeviceGroupMappingMapper deviceGroupMappingMapper;

    public DeviceGroupMappingServiceImpl(DeviceGroupMappingMapper deviceGroupMappingMapper) {
        this.deviceGroupMappingMapper = deviceGroupMappingMapper;
    }

    @Override
    public DeviceGroupMapping findByDeviceIdAndGroupId(String deviceId, String groupId) {
        LambdaQueryWrapper<DeviceGroupMapping> qw= new LambdaQueryWrapper<>();
        qw.eq(DeviceGroupMapping::getDeviceId,deviceId).eq(DeviceGroupMapping::getGroupId,groupId);
        return deviceGroupMappingMapper.selectOne(qw);
    }
}
