package com.amy.cloud.amycloudact;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmycloudActApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

    //1000021

    public static void main(String[] args) {
        int x = 8; //2147483647
        investAmount("500.24");
        investAmount1("500.24");
        System.out.println();
    }


    private static void investAmount(String amount){
        boolean ISPASS=true;
        String msg;
        BigDecimal[] result =  new BigDecimal(amount).divideAndRemainder(new BigDecimal(100));
        if (!"".equals(result[1]) && result[1] != null) {
            if(result[1].compareTo(BigDecimal.ZERO)!=0){
                ISPASS=Boolean.FALSE;
                msg="购买金额必须为100整数倍！";
                System.out.println(result[0]);
                System.out.println(result[1]);
                System.out.println(msg);

            }
            System.out.println("======");
        }
        /*if( amt.intValue() != 0){
            ISPASS=Boolean.FALSE;
            MESSAGE="购买金额必须为100整数倍！";
        }*/
    }

    private static void investAmount1(String amount){
        BigDecimal amt =  new BigDecimal(amount).remainder(new BigDecimal(100));
        System.out.println(amt);
        System.out.println("intValue:");
        System.out.println (amt.intValue());
        if( amt.compareTo(BigDecimal.ZERO)!=0){
           String msg="购买金额必须为100整数倍！";
            System.out.println(msg);
        }
    }

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
