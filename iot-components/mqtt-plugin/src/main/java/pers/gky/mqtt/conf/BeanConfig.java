package pers.gky.mqtt.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pers.gky.plugin.IPluginConfig;
import pers.gky.plugin.LocalPluginConfig;

/**
 * @author gky
 * @date 2024/05/02 17:52
 * @description
 */
@Component
public class BeanConfig {
    @Bean
    @ConditionalOnProperty(name = "plugin.runMode",havingValue = "dev")
    IPluginConfig getPluginConfig(){
        return new LocalPluginConfig();
    }
}
