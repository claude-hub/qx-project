package com.qianxun.service.exception;

public class PasswordInvalid extends AuthenticateException{
    public PasswordInvalid(String message){
        super(message);
    }
}