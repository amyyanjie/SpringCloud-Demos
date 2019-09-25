package com.amy.cloud.amyclouduserserver;

import com.amy.cloud.pub.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmycloudUserServerApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        this.redisUtil.set("key1","value1",100L);
        String value1=(String)this.redisUtil.get("key1");
        System.out.println(value1);
    }

}
