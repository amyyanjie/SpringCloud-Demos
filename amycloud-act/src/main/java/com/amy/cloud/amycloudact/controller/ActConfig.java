package com.amy.cloud.amycloudact.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/13 17:40
 */
@Component
public class ActConfig {
    @Value("${springFestival.startTime}")
    public String startTime;
    @Value("${springFestival.endTime}")
    public String endTime;
}
