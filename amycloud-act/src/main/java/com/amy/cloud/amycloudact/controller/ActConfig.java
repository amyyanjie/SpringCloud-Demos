package com.amy.cloud.amycloudact.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/13 17:40
 */
@Component
@Data
@ConfigurationProperties
public class ActConfig {
    private SpringFestival springFestival;
    @Data
    public static class SpringFestival{
        public String endTime;
        public String startTime;

    }

}
