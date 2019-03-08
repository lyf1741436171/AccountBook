package cn.wolfcode.accountbook.base.exception;

/**
 * 用来封装哪些自己抛出的一些异常信息,并且需要可以给用户看到的异常,比如说
 * 用户名不正确 等此类异常
 */
public class CustomException extends RuntimeException {
    public CustomException(String errorMsg){
        super(errorMsg);
    }
}
