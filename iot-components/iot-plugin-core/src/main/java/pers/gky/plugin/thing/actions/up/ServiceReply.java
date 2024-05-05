package pers.gky.plugin.thing.actions.up;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pers.gky.plugin.thing.actions.AbstractAction;
import pers.gky.plugin.thing.actions.ActionType;

import java.util.Map;

/**
 * @author gky
 * @date 2024/05/04 15:53
 * @description 服务回复
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ServiceReply extends AbstractAction {

    /**
     * 服务名
     */
    private String name;

    /**
     * 回复服务id
     */
    private String replyId;

    /**
     * 状态码,0:成功,x:失败错误码
     */
    private int code;

    /**
     * 服务回复参数
     */
    private Map<String, Object> params;

    @Override
    public ActionType getType() {
        return ActionType.SERVICE_REPLY;
    }
}

