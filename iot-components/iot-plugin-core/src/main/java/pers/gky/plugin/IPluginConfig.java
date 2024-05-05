package pers.gky.plugin;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 11:00
 * @description 插件配置接口
 */
public interface IPluginConfig {
    /**
     * 获取系统中配置的插件配置项
     *
     * @param pluginId 插件id
     * @return config
     */
    Map<String, Object> getConfig(String pluginId);
}
