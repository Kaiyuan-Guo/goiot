package pers.gky.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.gky.common.enums.ErrCode;

/**
 * @author gky
 * @date 2024/05/04 20:42
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BizException extends RuntimeException{
    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String message;

    public BizException(String message) {
        super(message);
        this.message = message;
        this.code = ErrCode.SYSTEM_EXCEPTION.getCode();
    }

    /**
     * 统一异常消息处理
     *
     * @param errCode 异常枚举值
     */
    public BizException(ErrCode errCode) {
        this.message = errCode.getMsg();
        this.code = errCode.getCode();
    }

    public BizException(ErrCode errCode, Throwable cause) {
        super(cause);
        this.code = errCode.getCode();
        this.message = errCode.getMsg();
    }

    public BizException(ErrCode errCode, String message) {
        this.message = message;
        this.code = errCode.getCode();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

}
