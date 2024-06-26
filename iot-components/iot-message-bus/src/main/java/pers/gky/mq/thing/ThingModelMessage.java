package pers.gky.mq.thing;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gky
 * @date 2024/05/01 20:10
 * @description 物模型消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThingModelMessage {
    public static final String TYPE_LIFETIME = "lifetime";
    public static final String TYPE_STATE = "state";
    public static final String TYPE_PROPERTY = "property";

    public static final String TYPE_EVENT = "event";
    public static final String TYPE_SERVICE = "service";

    public static final String TYPE_OTA = "ota";
    public static final String TYPE_CONFIG = "config";
    public static final String ID_PROPERTY_GET = "get";
    public static final String ID_PROPERTY_SET = "set";
    public static final String ID_PROPERTY_REPORT = "report";
    public static final String ID_CONFIG_GET = "get";
    public static final String ID_CONFIG_SET = "set";
    public static final String ID_DEREGISTER = "deregister";
    public static final String ID_ONLINE = "online";
    public static final String ID_OFFLINE = "offline";
    public static final String SERVICE_REPLY_SUFFIX = "_reply";

    private String id;

    private String mid;

    private String deviceId;

    private String productKey;

    private String deviceName;

    /**
     * 所属用户ID
     */
    private String uid;

    /**
     * 消息类型
     * lifetime:生命周期
     * state:状态
     * property:属性
     * event:事件
     * service:服务
     */
    private String type;

    private String identifier;

    /**
     * 消息状态码
     */
    private int code;

    private Object data;

    /**
     * 时间戳，设备上的事件或数据产生的本地时间
     */
    private Long occurred;

    /**
     * 消息上报时间
     */
    private Long time;

    public Map<String,Object> dataToMap(){
        Map<String,Object> mapData=new HashMap<>();
        if(data instanceof Map){
            ((Map<?,?>)data).forEach((key, Value)->mapData.put(key.toString(),Value));
        }
        return mapData;
    }
}
