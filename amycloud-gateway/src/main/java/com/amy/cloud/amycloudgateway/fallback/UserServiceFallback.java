package com.amy.cloud.amycloudgateway.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/17 18:35
 */
@Component
public class UserServiceFallback implements FallbackProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActServiceFallback.class);

    @Override
    public String getRoute() {
        return "amycloud-user";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            LOGGER.info("user service error:{}", reason);
        }
        return CommonResponse.fallbackReponse();
    }
}
