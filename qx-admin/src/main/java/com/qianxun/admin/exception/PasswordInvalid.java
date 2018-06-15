package com.qianxun.admin.exception;

public class PasswordInvalid extends AuthenticateException{
    public PasswordInvalid(String message){
        super(message);
    }
}