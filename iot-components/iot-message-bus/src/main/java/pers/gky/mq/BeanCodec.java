package pers.gky.mq;

import cn.hutool.json.JSONUtil;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.Json;

/**
 * @author gky
 * @date 2024/05/01 17:01
 * @description
 */
public class BeanCodec<T> implements MessageCodec<T,T> {
    private final Class<T> beanType;
    public BeanCodec(Class<T> cls) {
        beanType = cls;
    }
    @Override
    public void encodeToWire(Buffer buffer, T t) {
        String json= Json.encode(t);
        Buffer encoded = Buffer.buffer(json);
        buffer.appendInt(encoded.length());
        buffer.appendBuffer(encoded);
    }

    @Override
    public T decodeFromWire(int pos, Buffer buffer) {
        int length = buffer.getInt(pos);
        pos+=4;
        return Json.decodeValue(buffer.slice(pos,pos+length),beanType);
    }

    @Override
    public T transform(T t) {
        return JSONUtil.toBean(JSONUtil.toJsonStr(t),beanType);
    }

    @Override
    public String name() {
        return beanType.getSimpleName();
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
