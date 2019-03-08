package cn.wolfcode.accountbook.util;


import cn.wolfcode.accountbook.base.exception.CustomException;

import java.util.regex.Pattern;

public class AssertUtil {

    /**
     * 手机号验证码规则
     */
    private static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(18[0,0-9]))\\d{8}$";

    private static final AssertUtil assertUtil = new AssertUtil();

    private AssertUtil(){}

    public static AssertUtil instance(){
        return assertUtil;
    }

    /*
        断言手机号
     */
    public AssertUtil isMobile(String mobile,String message) {
        if(!Pattern.matches(this.REGEX_MOBILE, mobile)){
            throw new CustomException(message);
        }
        return instance();
    }
    /*
        字符串比较
     */
    public AssertUtil isEquals(String currentString,String targetString,String message){
        if(!currentString.equals(targetString)){
            throw new CustomException(message);
        }
        return instance();
    }

    /*
        断言不为空
     */
    public AssertUtil isNotNull(Object object, String message) {
        if(object == null) {
            throw new CustomException(message);
        }
        return instance();
    }

    /*
        断言字符串长度
     */
    public AssertUtil isLength(int currentLength,int matchLength, String message) {
        if(currentLength != matchLength) {
            throw new CustomException(message);
        }
        return instance();
    }
    /*
        断言字符串长度范围
     */
    public AssertUtil isLength(int currentLength,int minLength,int maxLength , String message) {
        if(currentLength < minLength || currentLength > maxLength) {
            throw new CustomException(message);
        }
        return instance();
    }

    /*
        断言 true
     */
    public AssertUtil isFalse(boolean t, String message) {
        if(t) {
            throw new CustomException(message);
        }
        return instance();
    }

}
