package pers.gky.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.gky.model.device.DeviceGroupDTO;

import java.io.Serializable;

/**
 * <p>
 * 设备组
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("device_group")
@AutoMapper(target = DeviceGroupDTO.class)
public class DeviceGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备组id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 设备数量
     */
    @TableField("device_qty")
    private Integer deviceQty;

    /**
     * 设备组名称
     */
    @TableField("name")
    private String name;

    /**
     * 分组说明
     */
    @TableField("remark")
    private String remark;

    /**
     * 所属用户
     */
    @TableField("uid")
    private String uid;


}
