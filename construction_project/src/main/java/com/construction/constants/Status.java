package com.construction.constants;


public enum Status {
    SUCCESS(true,"success"),FAIL(false,"fail"); //对应的对象


    private boolean flag;
    private String message;
    Status(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
