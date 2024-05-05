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
 * 设备组映射
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("device_group_mapping")
public class DeviceGroupMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备组映射id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 设备id
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 设备组id
     */
    @TableField("group_id")
    private String groupId;


}
