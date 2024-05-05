package pers.gky.plugin.thing.actions.up;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 15:53
 * @description 属性上报
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class PropertyReport extends AbstractAction {

    /**
     * 属性参数
     */
    private Map<String, Object> params;

    @Override
    public ActionType getType() {
        return ActionType.PROPERTY_REPORT;
    }
}

