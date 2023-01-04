package com.wzw.simple.log.convert;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 生成traceId
 *
 * @author zewen.wang
 * @date 2023/1/3
 */
public class TraceIdConvert extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return "1";
    }
}
