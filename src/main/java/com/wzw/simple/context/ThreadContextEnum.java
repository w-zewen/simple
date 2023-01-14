package com.wzw.simple.context;

/**
 * 线程上下文数据KEY
 *
 * @author zewen.wang
 * @date 2023/1/12
 */
public enum ThreadContextEnum {
    TRACE_ID("traceId", "日志调用链ID")
    ;

    private String key;
    private String desc;

    ThreadContextEnum(String key, String  desc){
        this.key = key;
        this.desc = desc;
    }

    public String key(){
        return key;
    }

}
