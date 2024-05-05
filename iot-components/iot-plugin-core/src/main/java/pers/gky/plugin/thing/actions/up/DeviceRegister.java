package pers.gky.plugin.thing.actions.up;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

/**
 * @author gky
 * @date 2024/05/04 15:51
 * @description 设备注册动作
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class DeviceRegister extends AbstractAction {

    /**
     * 型号
     */
    private String model;

    /**
     * 版本号
     */
    private String version;

    @Override
    public ActionType getType() {
        return ActionType.REGISTER;
    }
}
