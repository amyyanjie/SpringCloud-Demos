package com.amy.cloud.amyclouduserserver;

import com.amy.cloud.pub.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmycloudUserServerApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        this.redisUtil.set("key1", "value1", 100L);
        String value1 = (String) this.redisUtil.get("key1");
        System.out.println(value1);
    }

    public static void main(String args[]) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning," + args[0]);
                }
                return null;
            }
        };
        //动态代理：JDK在运行期动态创建class字节码并加载的过程。
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler);
        hello.morning("Bod");
    }

}
