package pers.gky.plugin.thing.actions.up;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;
import pers.gky.plugin.thing.actions.DeviceState;

/**
 * @author gky
 * @date 2024/05/04 15:52
 * @description 设备在线状态变更
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeviceStateChange extends AbstractAction {
    private DeviceState state;

    @Override
    public ActionType getType() {
        return ActionType.STATE_CHANGE;
    }
}
