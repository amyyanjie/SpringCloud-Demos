package com.amy.cloud.amycloudgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * @Author: yanjie
 * @Description: 异常捕获
 * @Date: 2019/09/06 15:07
 */
@Slf4j
@Component  //添加@Component，纳入spring容器管理
public class GlobalExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String status = ctx.getResponse().getStatus() + "";
        log.info("status:{}", status);
        return status.startsWith("5");//5xx异常捕获
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("系统错误发生的时间:{}", LocalDateTime.now());
        //打印捕获的5xx异常
        InputStream is = null;
        try {
            is = ctx.getResponseDataStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            StringBuffer responseBody = new StringBuffer();
            while (len != -1) {
                responseBody.append(new String(bytes, 0, len, Charset.forName("UTF-8")));
                len = is.read(bytes);
            }
            log.info("响应错误的请求是:{}", request.getRequestURL());
            log.info("响应错误的服务是:{}", ctx.get("serviceId"));
            log.error("错误的响应信息:{}", responseBody);
        } catch (IOException e) {
            log.error("记录响应请求发生异常");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("读取错误响应信息通道关闭异常:{}", e.getMessage());
                }
            }
        }
        return null;
    }
}
