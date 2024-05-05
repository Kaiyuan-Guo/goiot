package pers.gky.plugin.thing.actions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gky
 * @date 2024/05/04 15:40
 * @description 设备状态
 */
@Getter
@AllArgsConstructor
public enum DeviceState {
    //在线
    ONLINE("online"),
    //离线
    OFFLINE("offline");

    private final String state;
}
