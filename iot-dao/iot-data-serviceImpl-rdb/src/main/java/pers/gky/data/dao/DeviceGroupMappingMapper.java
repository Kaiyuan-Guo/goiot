package pers.gky.data.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.gky.data.entity.DeviceGroupMapping;

/**
 * <p>
 * 设备组映射 Mapper 接口
 * </p>
 *
 * @author gky
 * @since 2024-05-06
 */
@Mapper
@Repository
public interface DeviceGroupMappingMapper extends BaseMapper<DeviceGroupMapping> {

}
