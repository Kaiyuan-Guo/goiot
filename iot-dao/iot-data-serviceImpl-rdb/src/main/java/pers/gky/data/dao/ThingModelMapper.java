package pers.gky.data.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.gky.data.entity.ThingModel;


/**
 * <p>
 * 物模型 Mapper 接口
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Mapper
@Repository
public interface ThingModelMapper extends BaseMapper<ThingModel> {

}
