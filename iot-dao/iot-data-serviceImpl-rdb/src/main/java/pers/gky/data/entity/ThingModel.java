package pers.gky.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import io.github.linpeilie.annotations.ReverseAutoMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.gky.model.product.ThingModelDTO;

import java.io.Serializable;

/**
 * <p>
 * 物模型
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("thing_model")
@AutoMapper(target = ThingModelDTO.class)
public class ThingModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物模型id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 模型内容
     */
    @TableField("model")
    @AutoMapping(ignore = true)
    @ReverseAutoMapping(ignore = true)
    private String model;

    /**
     * 产品key
     */
    @TableField("product_key")
    private String productKey;


}
