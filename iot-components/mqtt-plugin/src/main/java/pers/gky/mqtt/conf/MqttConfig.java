package pers.gky.mqtt.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gky
 * @date 2024/05/02 17:52
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "mqtt")
public class MqttConfig {

    private int port;

    private String sslKey;

    private String sslCert;

    private boolean ssl;

    private boolean useWebSocket;

}
