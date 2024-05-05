package pers.gky.mqtt.service;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.gky.mqtt.conf.MqttConfig;
import pers.gky.plugin.IPlugin;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author gky
 * @date 2024/05/02 17:52
 * @description
 */
@Slf4j
@Service
public class MqttPlugin implements IPlugin {
    @Autowired
    private MqttVerticle mqttVerticle;
    @Autowired
    private MqttConfig mqttConfig;

    private Vertx vertx;


    @PostConstruct
    public void init() {
        vertx = Vertx.vertx();
        try {
            mqttVerticle.setConfig(mqttConfig);
            Future<String> future = vertx.deployVerticle(mqttVerticle);
            future.onSuccess(id -> {
                log.info("mqtt plugin start success");
            }).onFailure(err -> {
                log.error("mqtt plugin start fail", err);
            });
        }catch (Throwable e){
            log.error("mqtt plugin start fail", e);
        }
    }

    @Override
    public Map<String, Object> getLinkInfo(String pk, String dn) {
        return null;
    }
}
