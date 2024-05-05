package pers.gky.manager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.gky.manager.model.entity.DeviceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 设备信息 Mapper 接口
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Mapper
@Repository
public interface DeviceInfoMapper extends BaseMapper<DeviceInfo> {

}
