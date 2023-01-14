package com.wzw.simple.intercept;

import com.wzw.simple.context.ThreadContext;
import com.wzw.simple.context.ThreadContextEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Web拦截器
 *
 * @author zewen.wang
 * @date 2023/1/12
 */
@Slf4j
@Component
public class WebIntercept extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            ThreadContext.remove();
            ThreadContext.setParam(ThreadContextEnum.TRACE_ID, getTraceId(request));
        }catch (Exception e){
            log.info("WebIntercept preHandle error ", e);
        }
        return true;
    }

    // 获取TraceId
    private String getTraceId(HttpServletRequest httpServletRequest) {
        String traceID = httpServletRequest.getHeader(ThreadContextEnum.TRACE_ID.key());
        if (StringUtils.isEmpty(traceID)) {
            traceID = UUID.randomUUID().toString().replace("-", "");
        }
        return traceID;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadContext.remove();
    }

}
