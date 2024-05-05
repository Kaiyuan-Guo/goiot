package pers.gky.manager.service.impl;

import pers.gky.manager.model.entity.DeviceInfo;
import pers.gky.manager.dao.DeviceInfoMapper;
import pers.gky.manager.service.IDeviceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
