package pers.gky.plugin;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 11:00
 * @description 插件接口
 */
public interface IPlugin {
    /**
     * 获取设备连接信息，如连接mqtt的ip、端口、账号、密码。。。
     *
     * @param pk 产品key
     * @param dn 设备dn
     * @return 连接配置项
     */
    Map<String, Object> getLinkInfo(String pk, String dn);
}
