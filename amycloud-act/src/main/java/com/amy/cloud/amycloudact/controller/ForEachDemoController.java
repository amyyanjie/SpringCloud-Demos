package com.amy.cloud.amycloudact.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2020/04/28 16:05
 */
public class ForEachDemoController {

    public static void main(String[] args) {
        // 使用双括弧语法（double-brace syntax）建立并初始化一个List
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("holli");
            add("HollisChuang");
            add("Hollism");
        }};
//        for (String userName : userNames) { //foreach循环中修改删除，fail-fast:ConcurrentModificationException
//            if (userName.equals("Hollis")) {
//                userNames.remove(userName);
//            }
//        }
        /*1、直接使用普通for循环操作*/
        for (int i = 0; i < 1; i++) {
            if (userNames.get(i).equals("Hollis")) {
                userNames.remove(i);
            }
        }
        System.out.println(userNames);

        /*2、直接使用 Iterator 进行操作*/
        Iterator<String> iterator = userNames.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Holli")) {
                iterator.remove();
            }
        }
        System.out.println(userNames);
        //若是删除，可用
        userNames.removeIf(name -> name.equals("Hollim"));

        /*3、使用 Java 8 中提供的 filter 过滤*/
        userNames = userNames.stream().filter(name -> !name.equals("Holli")).collect(Collectors.toList());
        System.out.println(userNames);

        /*4、若只修改一次，可在foreach中修改后立即break*/
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
                break;
            }
        }
        System.out.println(userNames);
    }
}
