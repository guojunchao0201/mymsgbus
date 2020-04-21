package com.mytest.guo.disruptordemo;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
    public static void main(String[] args) {

        LongEventFactory factory = new LongEventFactory();
        ExecutorService pool = Executors.newSingleThreadExecutor();
        int ringBufferSize = 1024 * 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, ringBufferSize, pool,
                ProducerType.SINGLE, new YieldingWaitStrategy());
        LongEventHandler handler = new LongEventHandler();
        disruptor.handleEventsWith(handler);
        disruptor.start();

        // 发布事件；
//        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
//        long sequence = ringBuffer.next();//请求下一个事件序号；
//
//        try {
//            LongEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
//            long data = getEventData();//获取要通过事件传递的业务数据；
//            event.setValue(data);
//        } finally{
//            ringBuffer.publish(sequence);//发布事件；
//        }

        publishEvent2(disruptor);
    }

    static class Translator implements EventTranslatorOneArg<LongEvent, Long> {
        @Override
        public void translateTo(LongEvent event, long sequence, Long data) {
            event.setValue(data);
        }
    }

    public static Translator TRANSLATOR = new Translator();

    public static void publishEvent2(Disruptor<LongEvent> disruptor) {
        // 发布事件；
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long data = getEventData();//获取要通过事件传递的业务数据；
        ringBuffer.publishEvent(TRANSLATOR, data);
    }

    public static long getEventData() {
        return 200;
    }
}
