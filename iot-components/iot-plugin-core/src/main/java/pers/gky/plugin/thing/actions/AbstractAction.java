package pers.gky.plugin.thing.actions;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author gky
 * @date 2024/05/04 15:39
 * @description
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
public abstract class AbstractAction implements IDeviceAction{
    protected String id;
    protected ActionType type;
    protected String productKey;
    protected String deviceName;
    protected Long time;
    public AbstractAction(){

    }
    public AbstractAction(ActionType type){
        this.type = type;
    }
}
