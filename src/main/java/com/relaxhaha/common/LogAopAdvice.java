package com.relaxhaha.common;

import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * Description: 日志切面，注入唯一logid
 *
 * @author yujisun
 * @date 2015/7/30
 */
public class LogAopAdvice
{
    public void logIdInit() {


        String logId = RpcContext.getContext().getAttachment("logid");

        if(StringUtils.isBlank(logId)){
            logId = UUID.randomUUID().toString().substring(1,16);
        }
        org.slf4j.MDC.put("logid", logId);
        org.apache.log4j.MDC.put("logid", logId);

        //aop多次切入，计数，只有最后一次会清楚mdc的logid
        if(RpcContext.getContext().getAttachment("logidCount") != null){

            Integer logIdCount = Integer.parseInt(RpcContext.getContext().getAttachment("logidCount")) + 1;
            RpcContext.getContext().setAttachment("logidCount", String.valueOf(logIdCount));
        }
        else{
            RpcContext.getContext().setAttachment("logidCount", "1");
        }

        RpcContext.getContext().setAttachment("logid", logId);
    }

    public void clear()
    {
        if(RpcContext.getContext().getAttachment("logidCount") == null){
            RpcContext.removeContext();
            org.slf4j.MDC.clear();
            org.apache.log4j.MDC.remove("logid");
        }
        else{
            Integer logIdCount = Integer.parseInt(RpcContext.getContext().getAttachment("logidCount")) - 1;
            if(logIdCount == 0){
                RpcContext.removeContext();
                org.slf4j.MDC.clear();
                org.apache.log4j.MDC.remove("logid");
            }
            else{
                RpcContext.getContext().setAttachment("logidCount", String.valueOf(logIdCount));
            }
        }
    }

    public void exceptionProcess()
    {
        if(RpcContext.getContext().getAttachment("logidCount") == null){
            RpcContext.removeContext();
            org.slf4j.MDC.clear();
            org.apache.log4j.MDC.remove("logid");
        }
        else
        {
            Integer logIdCount = Integer.parseInt(RpcContext.getContext().getAttachment("logidCount")) - 1;
            if (logIdCount == 0)
            {
                RpcContext.removeContext();
                org.slf4j.MDC.clear();
                org.apache.log4j.MDC.remove("logid");
            } else
            {
                RpcContext.getContext().setAttachment("logidCount", String.valueOf(logIdCount));
            }
        }
    }

}
