package cn.wolfcode.accountbook.util;

import lombok.Getter;

@Getter
public class JSONResult {
    private String msg;

    private boolean success = true;

    private Object result;
    public JSONResult mark(String msg){
        this.msg = msg;
        this.success = false;
        return this;
    }

    public Object setResult(Object result){
        this.result = result;
        return this;
    }
}
