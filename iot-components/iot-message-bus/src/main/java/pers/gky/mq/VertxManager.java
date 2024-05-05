package pers.gky.mq;

import io.vertx.core.Vertx;

/**
 * @author gky
 * @date 2024/05/01 17:03
 * @description
 */
public class VertxManager {
    private static final Vertx INSTANCE=Vertx.vertx();
    public static Vertx getVertx()
    {
        return INSTANCE;
    }
}
