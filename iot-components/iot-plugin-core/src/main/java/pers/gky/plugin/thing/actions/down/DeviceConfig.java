package pers.gky.plugin.thing.actions.down;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.Map;
import java.util.Objects;

/**
 * @author gky
 * @date 2024/05/04 15:51
 * @description 设备配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeviceConfig extends AbstractAction {
    /**
     * 配置模块
     */
    private String module;
    /**
     * 配置信息
     */
    private Map<String, Objects> config;


    @Override
    public ActionType getType(){
        return ActionType.CONFIG;
    }

}
