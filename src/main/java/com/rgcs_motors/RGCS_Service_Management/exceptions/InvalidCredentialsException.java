package com.rgcs_motors.RGCS_Service_Management.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {

    public InvalidCredentialsException(String msg, Throwable thr) {super(msg,thr);}
    public InvalidCredentialsException(String msg) {super(msg);}
}
