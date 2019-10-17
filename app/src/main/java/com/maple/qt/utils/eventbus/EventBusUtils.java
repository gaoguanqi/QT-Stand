package com.maple.qt.utils.eventbus;


import org.greenrobot.eventbus.EventBus;

public class EventBusUtils {

    /**
     * 订阅事件
     * @param subscriber
     */
    public static void register(Object subscriber){
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 取消订阅事件
     * @param subscriber
     */
    public static void unregister(Object subscriber){
        if(EventBus.getDefault().isRegistered(subscriber)){
            EventBus.getDefault().unregister(subscriber);
        }
    }

    /**
     * 发送消息
     * @param event
     */
    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发送粘性消息
     * @param event
     */
    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }
}
