package com.wzw.simple.context;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程上下文对象，透传线程公共参数
 *
 * @author zewen.wang
 * @date 2023/1/10
 */
@Slf4j
public class ThreadContext {
    // 本地线程对象
    private static final ThreadLocal<Map<String, String>> LOCAL = new ThreadLocal<>();
    // LOCK
    private static final Lock LOCK = new ReentrantLock();

    public static void set(Map<String, String> map){
        LOCAL.set(map);
    }

    public static Map<String, String> get(){
        Map<String, String> map = LOCAL.get();
        if(map == null){
            LOCK.lock();
            try {
                map = LOCAL.get();
                if(map == null){
                    map = new HashMap<>(16);
                    ThreadContext.set(map);
                }
            }finally {
                LOCK.unlock();
            }
        }
        return map;
    }

    public static void remove(){
        LOCAL.remove();
    }

    public static String getParam(ThreadContextEnum threadContextEnum){
        return get().get(threadContextEnum.key());
    }

    public static void setParam(ThreadContextEnum threadContextEnum, String value){
        get().put(threadContextEnum.key(), value);
    }

}
