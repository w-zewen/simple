package com.wzw.simple.log.convert;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.wzw.simple.context.ThreadContext;
import com.wzw.simple.context.ThreadContextEnum;

import java.util.UUID;

/**
 * 生成traceId
 *
 * @author zewen.wang
 * @date 2023/1/3
 */
public class TraceIdConvert extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        try {
            String traceId = ThreadContext.getParam(ThreadContextEnum.TRACE_ID);
            if(traceId==null || traceId.equals("")){
                traceId = UUID.randomUUID().toString().replaceAll("-","");
                ThreadContext.setParam(ThreadContextEnum.TRACE_ID, traceId);
            }
            return traceId;
        }catch (Exception e){
            return "";
        }
    }

}
