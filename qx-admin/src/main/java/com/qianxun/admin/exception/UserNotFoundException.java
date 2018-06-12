package com.qianxun.admin.exception;

public class UserNotFoundException extends AuthenticateException{
    public UserNotFoundException(String message){
        super(message);
    }
}
