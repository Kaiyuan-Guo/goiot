package pers.gky.model.device;

import lombok.Data;
import pers.gky.model.Owned;

/**
 * @author gky
 * @date 2024/05/14 12:50
 * @description 设备分组
 */
@Data
public class DeviceGroupDTO implements Owned<String> {
    /**
     * 分组id
     */
    private String id;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 所属用户
     */
    private String uid;

    /**
     * 分组说明
     */
    private String remark;

    /**
     * 设备数量
     */
    private int deviceQty;

    /**
     * 创建时间
     */
    private long createAt;

}
