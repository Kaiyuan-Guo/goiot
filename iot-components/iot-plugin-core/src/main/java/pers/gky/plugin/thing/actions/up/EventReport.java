package pers.gky.plugin.thing.actions.up;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;
import pers.gky.plugin.thing.actions.EventLevel;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 15:53
 * @description 事件上报
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class EventReport extends AbstractAction {

    /**
     * 事件名
     */
    private String name;

    /**
     * 事件级别
     */
    private EventLevel level;

    /**
     * 事件参数
     */
    private Map<String, Object> params;

    @Override
    public ActionType getType() {
        return ActionType.EVENT_REPORT;
    }
}

