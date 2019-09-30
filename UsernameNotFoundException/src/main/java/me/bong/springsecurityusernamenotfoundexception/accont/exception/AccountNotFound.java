package me.bong.springsecurityusernamenotfoundexception.accont.exception;

import me.bong.springsecurityusernamenotfoundexception.common.exception.BusinessException;
import me.bong.springsecurityusernamenotfoundexception.common.utill.ReturnCodes;

public class AccountNotFound extends BusinessException {

    public AccountNotFound() {
        super(ReturnCodes.USER_NOTFOUND);
    }
}
