package com.yoouyi.common;

public class MessageDTO {

    private boolean success;
    private String message;
    private Object data;

    public MessageDTO() {
    }

    public MessageDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public MessageDTO(boolean success, Object data) {
        this.success = success;
        this.setData(data);
    }

    public MessageDTO(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.setData(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
