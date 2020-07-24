package com.amy.cloud.amycloudact.model;

/**
 * @Author: yanjie
 * @Description: 字典树
 * @Date: 2020/07/24 09:55
 */
public class Tire {
    // 不用建一个变量来存当前具体字符。
    // 使用数组表示，若当前字符对应的下标元素非空，则表示存在这个字符
    private Tire[] next;
    private boolean isEnd;

    public Tire() {
        next = new Tire[26];
        isEnd = false;
    }

    // 将字符串倒序插入字典树
    public void reversedInsert(String s) {
        Tire curPos = this; // 使每次调用方法时，都从树的头节点开始
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Tire();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }

}
