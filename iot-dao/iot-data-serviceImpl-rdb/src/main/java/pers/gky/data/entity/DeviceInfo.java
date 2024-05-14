package pers.gky.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import io.github.linpeilie.annotations.ReverseAutoMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.gky.model.device.DeviceInfoDTO;

import java.io.Serializable;

/**
 * <p>
 * 设备信息
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("device_info")
@AutoMapper(target = DeviceInfoDTO.class)
public class DeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备信息id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 设备id
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 设备名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 纬度
     */
    @TableField("latitude")
    private String latitude;

    /**
     * 经度
     */
    @TableField("longitude")
    private String longitude;

    /**
     * 设备类型
     */
    @TableField("model")
    private String model;

    /**
     * 设备离线时间
     */
    @TableField("offline_time")
    private Long offlineTime;

    /**
     * 设备在线时间
     */
    @TableField("online_time")
    private Long onlineTime;

    /**
     * 父级id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 产品key
     */
    @TableField("product_key")
    private String productKey;

    /**
     * 设备密钥
     */
    @TableField("secret")
    private String secret;

    /**
     * 设备状态
     */
    @TableField("state")
    @AutoMapping(ignore = true)
    @ReverseAutoMapping(ignore = true)
    private String state;

    /**
     * 用户id
     */
    @TableField("uid")
    private String uid;


}
