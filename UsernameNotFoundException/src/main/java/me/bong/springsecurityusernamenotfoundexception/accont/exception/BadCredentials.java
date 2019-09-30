package me.bong.springsecurityusernamenotfoundexception.accont.exception;

import me.bong.springsecurityusernamenotfoundexception.common.exception.BusinessException;
import me.bong.springsecurityusernamenotfoundexception.common.utill.ReturnCodes;

public class
BadCredentials extends BusinessException {

    public BadCredentials() {
        super(ReturnCodes.BAD_CREDENTIALS);
    }
}
