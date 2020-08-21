package com.amy.cloud.amycloudact.controller;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2020/08/21 14:25
 */
public class TestClass {
    public static void main(String args[]) {
        int i = 4;
        int a = i++;
        int b = ++i;
        System.out.println("i=" + i);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        int j = 0;
        int p1 = j++;
        int p2 = ++j;
        int p3 = j++;
        int m = p1 + p2 + p3;
        System.out.println("j=" + j);
        System.out.println("p1=" + p1);
        System.out.println("p2=" + p2);
        System.out.println("p3=" + p3);
        System.out.println("m=" + m);
    }
}
