package pers.gky.plugin.thing.actions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gky
 * @date 2024/05/04 15:40
 * @description 事件级别
 */
@Getter
@AllArgsConstructor
public enum EventLevel {
    //信息
    INFO("info"),
    //告警
    WARN("warn"),
    //错误
    ERROR("error");

    private final String type;
}
