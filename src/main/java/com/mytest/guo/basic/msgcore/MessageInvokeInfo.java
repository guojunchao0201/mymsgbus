package com.mytest.guo.basic.msgcore;

import java.lang.reflect.Method;

public class MessageInvokeInfo {

    /**
     * controller对象
     */
    private final Object controller;

    /**
     * controller ID
     */
    private final String controllerId;


    /**
     * controller上的方法
     */
    private final Method method;

    public MessageInvokeInfo(Object controller, String controllerId, Method method) {
        this.controller = controller;
        this.controllerId = controllerId;
        this.method = method;
    }
}
