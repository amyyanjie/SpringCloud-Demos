package com.amy.cloud.amycloudact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmycloudActApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

    //2147483648
    @Test
    public void test3() {
        int x = 1000021; //2147483647
        System.out.println(isPalindrome(x));

    }
    //1000021

    public static void main(String[] args) {
        int x = 8; //2147483647

        System.out.println(isPalindrome(x));
    }
    //  首位：12321/10000=1，末位：12321%10=1;  x->232: x=x
//12321%10000/10
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rightPart = 0;
        //rightPart为后半部分反转后的数
        while (x > rightPart) {
            rightPart = rightPart * 10 + x % 10;
            x = x / 10;
        }
        //当原数字长度为奇数时，x == rightPart / 10
        if (x == rightPart || x == rightPart / 10) {
            return true;
        }
        return false;
    }
    //

    //	给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    public int reverse(int x) {
        boolean a = x >= 0;
        x = Math.abs(x);
        int result = 0;
        int limit = Integer.MAX_VALUE;
        while (x > 0) { //注意这里是>0，并非之前的!=0;
            if (result > (limit / 10)) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return a ? result : 0 - result;
    }
}
