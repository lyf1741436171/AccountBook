package cn.wolfcode.accountbook.util;

public class JsonResult {

    private boolean success = true;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.success = false;
        this.message = message;
    }
}
