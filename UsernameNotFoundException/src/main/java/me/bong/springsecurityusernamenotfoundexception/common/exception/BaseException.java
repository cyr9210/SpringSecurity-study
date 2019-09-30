package me.bong.springsecurityusernamenotfoundexception.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private final Object[] messageArgs;

    private final String exceptionCode;

    public BaseException(String exceptionCode) {
        this(null, exceptionCode);
    }

    public BaseException(Object[] messageArgs, String exceptionCode) {
        this(null, messageArgs, exceptionCode);
    }

    public BaseException(String message, Object[] messageArgs, String exceptionCode) {
        this(message, null, messageArgs, exceptionCode);
    }

    public BaseException(String message, Throwable cause, Object[] messageArgs, String exceptionCode) {
        super(message, cause);
        this.messageArgs = messageArgs;
        this.exceptionCode = exceptionCode;
    }


}
