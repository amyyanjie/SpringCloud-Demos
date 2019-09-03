package com.amy.cloud.amyclouduserclient.fallback;

import com.amy.cloud.amyclouduserclient.api.UserServiceFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/30 11:29
 */
@Component
public class UserServiceFeignFallback implements FallbackFactory<UserServiceFeign> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceFeignFallback.class);

    @Override
    public UserServiceFeign create(Throwable cause) {
        return new UserServiceFeign() {
            @Override
            public String getUserName(String userId) {
                LOGGER.error("getUserName:{} error", userId);
                return null;
            }

            @Override
            public String addUser(String mobile, String nickName) {
                LOGGER.error("addUser:{} error", mobile);
                return null;
            }

            @Override
            public String getUserList(String role) {
                LOGGER.error("getUserList:{} error", role);
//                return null;
                return "getUserList error,role:" + role;
            }
        };
    }
}
