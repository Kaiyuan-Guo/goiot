package pers.gky.mq.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.gky.mq.VertxMqConsumer;
import pers.gky.mq.VertxMqProducer;
import pers.gky.mq.core.MqConsumer;
import pers.gky.mq.core.MqProducer;
import pers.gky.mq.thing.ThingModelMessage;

/**
 * @author gky
 * @date 2024/05/01 17:01
 * @description
 */
@Configuration
public class VertxConfig {
    @Bean
    @ConditionalOnMissingBean
    public MqProducer<ThingModelMessage> getThingModelMessageProducer(){
        return new VertxMqProducer<>(ThingModelMessage.class);
    }

    @Bean
    @ConditionalOnMissingBean
    public MqConsumer<ThingModelMessage> getThingModelMessageConsumer(){
        return new VertxMqConsumer<>(ThingModelMessage.class);
    }
}
