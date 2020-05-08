package com.mytest.guo.basic.msgcore;

/**
 * @author guojunchao
 */
public class MessageInvokeTask {

    private final MessageInvokeInfo messageInvokeInfo;

    private final InnerMessage innerMessage;

    private MessageInvokeTask nextTask;


    public MessageInvokeTask(MessageInvokeInfo messageInvokeInfo, InnerMessage innerMessage) {
        this.messageInvokeInfo = messageInvokeInfo;
        this.innerMessage = innerMessage;
    }


    public MessageInvokeInfo getMessageInvokeInfo() {
        return messageInvokeInfo;
    }

    public InnerMessage getInnerMessage() {
        return innerMessage;
    }

    public MessageInvokeTask getNextTask() {
        return nextTask;
    }

    public void setNextTask(MessageInvokeTask nextTask) {
        this.nextTask = nextTask;
    }
}
