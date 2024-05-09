package pers.gky.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.gky.common.utils.ReflectUtil;
import pers.gky.manager.dao.DeviceInfoMapper;
import pers.gky.manager.model.dto.DeviceInfoDTO;
import pers.gky.manager.model.entity.DeviceGroupMapping;
import pers.gky.manager.model.entity.DeviceInfo;
import pers.gky.manager.service.IDeviceGroupMappingService;
import pers.gky.manager.service.IDeviceInfoService;

import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 设备信息 服务实现类
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements IDeviceInfoService {
    private final DeviceInfoMapper deviceInfoMapper;
    private final IDeviceGroupMappingService deviceGroupMappingService;

    public DeviceInfoServiceImpl(DeviceInfoMapper deviceInfoMapper, IDeviceGroupMappingService deviceGroupMappingService) {
        this.deviceInfoMapper = deviceInfoMapper;
        this.deviceGroupMappingService = deviceGroupMappingService;
    }

    /**
     * 将设备状态从dto转换为bo
     */
    private void parseStateToBo(DeviceInfoDTO dto, DeviceInfo bo) {
        DeviceInfoDTO.State state = dto.getState();
        bo.setState(state != null && state.isOnline() ? "online" : "offline");
        bo.setOfflineTime(state != null ? state.getOfflineTime() : null);
        bo.setOnlineTime(state != null ? state.getOnlineTime() : null);
        DeviceInfoDTO.Locate locate = dto.getLocate();
        bo.setLongitude(locate.getLongitude());
        bo.setLatitude(locate.getLatitude());
    }

    @Transactional
    public boolean save(DeviceInfoDTO data) {
        DeviceInfo bo = deviceInfoMapper.selectById(data.getDeviceId());
        if (StrUtil.isBlank(data.getId())) {
            data.setId(UUID.randomUUID().toString());
        }
        if (bo == null) {
            bo = new DeviceInfo();
        }
        ReflectUtil.copyNoNulls(data, bo);
        // 状态转换
        parseStateToBo(data, bo);
        // 保存设备信息
        deviceInfoMapper.insert(bo);

        // 设备分组转换
        Map<String, DeviceInfoDTO.Group> groupMap = data.getGroup();
        groupMap.forEach((id, group) -> {
            DeviceGroupMapping mapping = deviceGroupMappingService.findByDeviceIdAndGroupId(data.getDeviceId(), id);
            if (mapping == null) {
                // 保存设备分组与设备对应关系
                deviceGroupMappingService.save(new DeviceGroupMapping(
                        UUID.randomUUID().toString(),
                        data.getDeviceId(),
                        id
                ));
            }
        });
        return true;
    }

}
