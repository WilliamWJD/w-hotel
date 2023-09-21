package com.wjd.hotel.exceptions.impl;

public class DataIntegrityViolationExceptionApp extends  RuntimeException{
    public DataIntegrityViolationExceptionApp(String msg) {
        super(msg);
    }
}
