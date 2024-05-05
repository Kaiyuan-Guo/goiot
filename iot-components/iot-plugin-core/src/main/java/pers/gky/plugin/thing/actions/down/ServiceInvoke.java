package pers.gky.plugin.thing.actions.down;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 15:51
 * @description 服务调用
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ServiceInvoke extends AbstractAction {
    /**
     * 服务名
     */
    private String name;

    /**
     * 服务参数
     */
    private Map<String, ?> params;

    /**
     * 配置信息
     */
    private Map<String, ?> config;

    @Override
    public ActionType getType() {
        return ActionType.SERVICE_INVOKE;
    }
}
