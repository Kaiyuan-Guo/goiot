/*
 * +----------------------------------------------------------------------
 * | Copyright (c) 奇特物联 2021-2022 All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed 未经许可不能去掉「奇特物联」相关版权
 * +----------------------------------------------------------------------
 * | Author: xw2sy@163.com
 * +----------------------------------------------------------------------
 */
package pers.gky.common.utils;


import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 反射工具
 */
public class ReflectUtil {

    @SneakyThrows
    public static <T> void copyNoNulls(T from, T to, String... fields) {
        List<String> fieldList = Arrays.asList(fields);
        Map<String, Object> map = new HashMap<>();
        (new BeanMap(from)).forEach((key, value) -> {
            if (value != null) {
                String field = key.toString();
                if (fields.length == 0 || fieldList.contains(field)) {
                    map.put(field, value);
                }

            }
        });
        BeanUtils.populate(to, map);
    }

    public static Map<String, ?> toMap(Object bean) {
        Map<String, Object> map = new HashMap<>();
        (new BeanMap(bean)).forEach((key, value) -> {
            if (!"class".equals(key)) {
                String field = key.toString();
                map.put(field, value);
            }
        });
        return map;
    }

}
