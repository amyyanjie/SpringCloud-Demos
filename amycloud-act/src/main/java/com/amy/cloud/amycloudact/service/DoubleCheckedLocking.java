package com.amy.cloud.amycloudact.service;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2020/01/10 10:39
 */
public class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance;

    public static DoubleCheckedLocking getIntance() {
        if (instance == null) {                             // 第一次检查
            synchronized (DoubleCheckedLocking.class) {     // 加锁，
                if (instance == null) {                     // 第二次检查
                    instance = new DoubleCheckedLocking();  // 初始化（问题的根源）
                }
            }
        }
        return instance;
    }


}