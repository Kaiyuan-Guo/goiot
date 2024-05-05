package pers.gky.plugin.thing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gky
 * @date 2024/05/04 15:38
 * @description 设备信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThingDevice {
    private String deviceId;
    /**
     * 产品key
     */
    private String productKey;
    /**
     * 设备dn
     */
    private String deviceName;
    /**
     * 设备型号
     */
    private String model;
    /**
     * 设备密钥
     */
    private String secret;
}
