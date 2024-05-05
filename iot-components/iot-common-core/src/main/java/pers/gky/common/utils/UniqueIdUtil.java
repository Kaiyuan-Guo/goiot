package pers.gky.common.utils;

import cn.hutool.core.util.RandomUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gky
 * @date 2024/05/04 20:43
 * @description
 */
public class UniqueIdUtil {
    private static final int MACHINE_ID = RandomUtil.randomInt(10,99);

    private static final AtomicInteger SEQUENCE = new AtomicInteger(1000);

    public static String newRequestId() {
        return newUniqueId("RID");
    }

    public static String newUniqueId(String prefix) {
        int id = SEQUENCE.getAndIncrement();
        if (id >= 5000) {
            SEQUENCE.set(1000);
        }

        return prefix + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + id + MACHINE_ID;
    }
}
