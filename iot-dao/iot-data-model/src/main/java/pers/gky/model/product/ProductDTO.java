/*
 * +----------------------------------------------------------------------
 * | Copyright (c) 奇特物联 2021-2022 All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed 未经许可不能去掉「奇特物联」相关版权
 * +----------------------------------------------------------------------
 * | Author: xw2sy@163.com
 * +----------------------------------------------------------------------
 */
package pers.gky.model.product;


import lombok.*;
import pers.gky.model.Id;

import java.io.Serializable;


/**
 * @author Administrator
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Id<Long>, Serializable {

    //定位更新方式，手动/设备上报
    public static final String LOCATE_MANUAL = "manual";
    public static final String LOCATE_DEVICE = "device";

    private Long id;

    private String productKey;

    private String productSecret;

    private String name;

    private Integer nodeType;

    /**
     * 所属平台用户ID
     */
    private String uid;

    private String img;

    /**
     * 是否透传
     */
    private Boolean transparent;

    /**
     * 是否开启定位
     */
    private Boolean isOpenLocate;

    /**
     * 定位更新方式
     */
    private String locateUpdateType;

    /**
     * 保活时长（秒）
     */
    private Long keepAliveTime;

    private Long createAt;

    public boolean isTransparent() {
        return transparent != null && transparent;
    }
}