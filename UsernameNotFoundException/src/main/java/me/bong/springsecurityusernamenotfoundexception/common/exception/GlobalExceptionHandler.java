package me.bong.springsecurityusernamenotfoundexception.common.exception;

import me.bong.springsecurityusernamenotfoundexception.common.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseVO baseException(BaseException ex, HttpServletRequest request, WebRequest webRequest) {
        return new ResponseVO(String.format("fail %s", ex.getExceptionCode()));
    }
}
