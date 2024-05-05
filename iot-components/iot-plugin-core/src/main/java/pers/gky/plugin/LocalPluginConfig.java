package pers.gky.plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 11:00
 * @description 本地独立运行的插件配置
 */
public class LocalPluginConfig implements IPluginConfig{
    @Override
    public Map<String, Object> getConfig(String pluginId) {
        // 本地的直接用程序中的默认值
        return new HashMap<>(0);
    }
}
