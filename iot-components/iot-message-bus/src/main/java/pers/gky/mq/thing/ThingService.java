package pers.gky.mq.thing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gky
 * @date 2024/05/01 20:10
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThingService<T> {
    public static final String TYPE_PROPERTY = "property";
    public static final String TYPE_SERVICE = "service";

    public static final String TYPE_OTA = "ota";

    private String mid;

    private String productKey;

    private String deviceName;

    private String type;

    private String identifier;

    private T params;

}
