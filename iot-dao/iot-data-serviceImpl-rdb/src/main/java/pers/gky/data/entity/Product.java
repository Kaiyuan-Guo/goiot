package pers.gky.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 图片
     */
    @TableField("img")
    private String img;

    /**
     * 是否开启设备定位，true/false
     */
    @TableField("is_open_locate")
    private Boolean isOpenLocate;

    /**
     * 保活时长（秒）
     */
    @TableField("keep_alive_time")
    private Long keepAliveTime;

    /**
     * 定位更新方式
     */
    @TableField("locate_update_type")
    private String locateUpdateType;

    /**
     * 产品名称
     */
    @TableField("name")
    private String name;

    /**
     * 节点类型
     */
    @TableField("node_type")
    private Integer nodeType;

    /**
     * 产品key
     */
    @TableField("product_key")
    private String productKey;

    /**
     * 产品密钥
     */
    @TableField("product_secret")
    private String productSecret;

    /**
     * 租户id
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 是否透传，true/false
     */
    @TableField("transparent")
    private Boolean transparent;

    /**
     * 用户id
     */
    @TableField("uid")
    private String uid;


}
