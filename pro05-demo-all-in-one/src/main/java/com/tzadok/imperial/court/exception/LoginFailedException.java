package com.tzadok.imperial.court.exception;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.exception
 * @ClassName: LoginFaileException
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 22:53
 */
public class LoginFailedException extends RuntimeException{

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
