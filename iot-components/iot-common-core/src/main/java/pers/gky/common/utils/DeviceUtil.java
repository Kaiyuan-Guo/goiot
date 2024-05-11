package pers.gky.common.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author gky
 * @date 2024/05/10 22:18
 * @description
 */
public class DeviceUtil {
    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 1-13位	时间戳
     * 14-29位	deviceNae，去除非字母和数字，不足16位补0，超过16位的mac取后16位，共16位
     * 30-31位	mac长度，共2位
     * 32位	随机一个0-f字符
     */
    public static String newDeviceId(String deviceName) {
        int maxDnLen = 16;
        String dn = deviceName.replaceAll("[^0-9A-Za-z]", "");
        if (dn.length() > maxDnLen) {
            dn = dn.substring(dn.length() - maxDnLen + 1);
        } else {
            dn = (dn + "00000000000000000000").substring(0, maxDnLen);
        }
        String len = StrUtil.fillBefore(String.valueOf(deviceName.length()), '0', 2);
        String rnd = Integer.toHexString(RandomUtil.randomInt(0, 16));
        return (System.currentTimeMillis() + "0" + dn + len + rnd).toLowerCase();
    }
    public static String newSecret(int length) {
        return RandomUtil.randomString(BASE_CHAR,length);
    }
}
