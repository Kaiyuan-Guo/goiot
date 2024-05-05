package pers.gky.plugin.thing.actions.up;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.List;

/**
 * @author gky
 * @date 2024/05/04 15:53
 * @description 子设备注册动作
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class SubDeviceRegister extends AbstractAction {

    /**
     * 型号
     */
    private String model;

    /**
     * 版本号
     */
    private String version;

    /**
     * 子设备注册
     */
    private List<DeviceRegister> subs;

    @Override
    public ActionType getType() {
        return ActionType.SUB_REGISTER;
    }
}

