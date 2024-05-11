package pers.gky.plugin.thing.actions.up;

import lombok.*;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.List;

/**
 * @author gky
 * @date 2024/05/04 15:52
 * @description 设备拓扑更新
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeviceTopology extends AbstractAction {
    /**
     * 父设备下的子设备列表
     */
    private List<String> subDevices;

    @Override
    public ActionType getType(){
        return ActionType.TOPOLOGY;
    }
}
