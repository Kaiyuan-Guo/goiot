package pers.gky.manager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.gky.manager.model.entity.ThingModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
