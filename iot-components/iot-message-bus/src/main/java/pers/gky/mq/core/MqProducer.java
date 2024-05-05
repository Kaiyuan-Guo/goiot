package pers.gky.mq.core;

/**
 * @author gky
 * @date 2024/05/01 17:01
 * @description
 */
public interface MqProducer<T> {
    void publish(String topic ,T msg);
}
