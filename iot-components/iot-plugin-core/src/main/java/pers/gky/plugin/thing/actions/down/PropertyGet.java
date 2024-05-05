package pers.gky.plugin.thing.actions.down;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.List;

/**
 * @author gky
 * @date 2024/05/04 15:51
 * @description 属性获取
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class PropertyGet extends AbstractAction {
    /**
     * 属性列表
     */
    private List<String> keys;

    @Override
    public ActionType getType(){
        return ActionType.PROPERTY_GET;
    }
}
