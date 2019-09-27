package com.amy.cloud.amycloudzuul.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/17 18:01
 */
@Component
public class ActServiceFallback implements FallbackProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActServiceFallback.class);

    @Override
    public String getRoute() {
        return "amycloud-act";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            LOGGER.info("act service error:{}", reason);
        }
        return CommonResponse.fallbackReponse();
    }
}
