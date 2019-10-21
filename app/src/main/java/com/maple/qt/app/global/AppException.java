package com.maple.qt.app.global;

public class AppException extends RuntimeException {
    public AppException() { }
    public AppException(String detailMessage) {
        super(detailMessage);
    }
}
