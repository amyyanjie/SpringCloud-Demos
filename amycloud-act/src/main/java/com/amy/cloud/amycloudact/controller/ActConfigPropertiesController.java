package com.amy.cloud.amycloudact.controller;

import com.amy.cloud.amycloudact.AmycloudActApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/12 19:04
 */
@RestController
@Slf4j
public class ActConfigPropertiesController {
    //1、通过@Value方式获取配置
    @Value("${springFestival.startTime}")
    public String startTime;

    //2、通过创建一个映射远程配置信息的Bean（ActConfig） 方式获取配置信息
    @Autowired
    private ActConfig actConfig;

    //3、通过Environment.getProperty方法获取配置信息（底层方式）
    @Autowired
    Environment environment;

    @GetMapping("/time")
    public Map<String, Object> getTime() {
        Map<String, Object> map = new HashMap<>();

        //1、通过@Value方式获取配置
        String getStartByValue = startTime;
        map.put("getStartByValue", getStartByValue);

        //2、通过创建一个映射远程配置信息的Bean（ActConfig） 方式获取配置信息
        String getEndByBean = actConfig.getSpringFestival().getEndTime();
        map.put("getEndByBean", getEndByBean);

        //3、通过Environment.getProperty方法获取配置信息
        String getStartByEnvironment = environment.getRequiredProperty("springFestival.startTime");
        map.put("getStartByEnvironment", getStartByEnvironment);
        //3(2)、Environment从启动类中返回
        String getEndByEnvironmentOfContext = AmycloudActApplication.getEnv().getRequiredProperty("springFestival.endTime");
        map.put("getEndByEnvironmentOfContext", getEndByEnvironmentOfContext);
        return map;
    }
//    map输出结果：
//    {
//            "getStartByEnvironment": "2019-01-31 00:00:00",
//            "getEndByBean": "2019-02-21 00:00:00",
//            "getStartByValue": "2019-01-31 00:00:00",
//            "getEndByEnvironmentOfContext": "2019-02-21 00:00:00"
//    }

}
