package pers.gky.plugin;

import pers.gky.script.IScriptEngine;

/**
 * @author gky
 * @date 2024/05/04 11:00
 * @description 插件宿主接口
 */
public interface IPluginScript {
    /**
     * 获取插件对应的脚本引擎
     *
     * @param pluginId 插件id
     * @return IScriptEngine
     */
    IScriptEngine getScriptEngine(String pluginId);

    /**
     * 重新加载脚本
     *
     * @param pluginId 插件id
     */
    void reloadScript(String pluginId);
}
