package me.bong.springsecurityusernamenotfoundexception.common.exception;

public class BusinessException extends BaseException {

    public BusinessException(String exceptionCode) {
        this(null, null, exceptionCode);
    }

    public BusinessException(Object[] messageArgs, String exceptionCode) {
        this(null, messageArgs, exceptionCode);
    }

    public BusinessException(String exceptionCode, String message) {
        this(message, null, exceptionCode);
    }

    public BusinessException(String message, Object[] messageArgs, String exceptionCode) {
        super(message, messageArgs, exceptionCode);
    }
}
