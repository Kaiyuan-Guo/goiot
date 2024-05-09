package pers.gky.manager.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gky
 * @date 2024/05/05 17:52
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThingModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String productKey;

    private Model model;

    public ThingModel(String productKey) {
        this.productKey = productKey;
    }

    @Data
    public static class Model {
        private List<Property> properties;
        private List<Service> services;
        private List<Event> events;

        public Map<String, Service> serviceMap() {
            if (services == null) {
                return new HashMap<>();
            }
            return services.stream().collect(Collectors.toMap(Service::getIdentifier, s -> s));
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Property {
        private String identifier;
        private DataType dataType;
        private String name;
        private String accessMode = "rw";

        // 描述
        private String description;

        // 单位
        private String unit;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Parameter {
        private String identifier;
        private DataType dataType;
        private String name;
        private Boolean required = false;
    }

    @Data
    public static class Service {
        private String identifier;
        private List<Parameter> inputData;
        private List<Parameter> outputData;
        private String name;
    }

    @Data
    public static class Event {
        private String identifier;
        private List<Parameter> outputData;
        private String name;
    }

    @Data
    public static class DataType {
        private String type;
        private Object specs;

        public <T> Object parse(T value) {
            if (value == null) {
                return null;
            }

            String val = value.toString();
            type = type.toLowerCase();
            switch (type) {
                case "bool":
                case "enum":
                case "int":
                    return Integer.parseInt(val);
                default:
                    return val;
            }

        }
    }
}
