package com.wjd.hotel.exceptions.impl;

public class ObjectNotFoundExceptionApp extends  RuntimeException{
    public ObjectNotFoundExceptionApp(String msg) {
        super(msg);
    }
}
