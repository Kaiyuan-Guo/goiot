package pers.gky.plugin.thing.actions.down;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 15:51
 * @description 属性设置
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PropertySet extends AbstractAction {
    /**
     * 属性参数
     */
    private Map<String,?> params;

    @Override
    public ActionType getType(){
        return ActionType.PROPERTY_SET;
    }
}
