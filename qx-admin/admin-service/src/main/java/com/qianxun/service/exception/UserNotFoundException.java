package com.qianxun.service.exception;

public class UserNotFoundException extends AuthenticateException{
    public UserNotFoundException(String message){
        super(message);
    }
}
