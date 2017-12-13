package com.target.myRetail.exception;

/**
 * Created by Shreya on 12/12/2017.
 */
public class OtherResponse {
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OtherResponse(int id, String message ){
        this.id = id;

        this.message = message;

    }
}
