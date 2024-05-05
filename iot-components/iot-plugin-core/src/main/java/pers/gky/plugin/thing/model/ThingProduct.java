package pers.gky.plugin.thing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gky
 * @date 2024/05/04 15:39
 * @description 产品信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThingProduct {

    private String productKey;

    private String productSecret;

    private String name;

    private String category;

    private Integer nodeType;

}

