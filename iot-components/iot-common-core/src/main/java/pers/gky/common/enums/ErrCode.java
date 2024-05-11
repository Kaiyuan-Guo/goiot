package pers.gky.common.enums;

import lombok.Getter;

/**
 * @author gky
 * @date 2024/05/04 20:41
 * @description 异常枚举类
 */
@Getter
public enum ErrCode {

    /**
     * 系统通用异常段
     */
    PARAMS_EXCEPTION(100001, "参数异常"),
    SYSTEM_EXCEPTION(100002, "系统异常"),
    UNKNOWN_EXCEPTION(100003, "未知异常"),
    SEND_DESTINATION_NOT_FOUND(300007, "发送目标不存在"),

    /**
     * 业务通用异常段
     */
    PRODUCT_NOT_FOUND(500005, "产品不存在"),
    DEVICE_NOT_FOUND(500006, "设备不存在");

    private final int code;
    private final String msg;

    ErrCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

}
