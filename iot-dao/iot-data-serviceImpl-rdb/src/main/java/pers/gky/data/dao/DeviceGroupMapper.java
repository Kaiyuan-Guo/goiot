package pers.gky.data.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.gky.data.entity.DeviceGroup;


/**
 * <p>
 * 设备组 Mapper 接口
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Mapper
@Repository
public interface DeviceGroupMapper extends BaseMapper<DeviceGroup> {

}
