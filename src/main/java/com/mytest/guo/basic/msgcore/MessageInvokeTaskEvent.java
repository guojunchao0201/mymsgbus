package com.mytest.guo.basic.msgcore;

/**
 * 消息事件
 */
public class MessageInvokeTaskEvent {


    /**
     * 消息任务
     */
    private MessageInvokeTask task;

    private String dispatcherChannelName;

    public MessageInvokeTaskEvent() {
    }

    public MessageInvokeTask getTask() {
        return task;
    }

    public void setTask(MessageInvokeTask task) {
        this.task = task;
    }

    public String getDispatherChannelName() {
        return dispatcherChannelName;
    }

    public void setDispatherChannelName(String dispatherChannelName) {
        this.dispatcherChannelName = dispatherChannelName;
    }
}
