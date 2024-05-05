package pers.gky.manager.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    private String model;

    /**
     * 产品key
     */
    @TableField("product_key")
    private String productKey;


}
