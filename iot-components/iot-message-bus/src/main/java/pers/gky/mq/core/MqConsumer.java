package pers.gky.mq.core;

/**
 * @author gky
 * @date 2024/05/01 17:00
 * @description
 */
public interface MqConsumer<T> {
    void consume(String topic,ConsumerHandler<T> handler);
}
