package pers.gky.plugin.thing.actions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gky
 * @date 2024/05/04 15:39
 * @description 动作执行结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionResult {
    /**
     * 状态码，0：成功，x:其他错误码
     */
    private int code;

    /**
     * 失败原因
     */
    private String reason;
}
