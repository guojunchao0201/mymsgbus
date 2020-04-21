package com.mytest.guo.disruptordemo;


import com.lmax.disruptor.EventHandler;

/**
 * @author guojunchao
 * 事件处理的具体实现
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {

        System.out.println("event: " + event.getValue());
    }
}
