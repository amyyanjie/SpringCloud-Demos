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
        int[] nums = {1, 3, 5, 7}; //4  2  [0,3]
        int target = 8;
//        System.out.println(searchInsert(nums, target));
        //214739559
        System.out.println(1);
        System.out.println(mySqrt1(18));
        System.out.println(mySqrt1(2147395599));
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) { //注意循环条件
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1; //left右移
            } else {
                right = right - 1; //right左移
            }
        }
        return left; //若target不存在于nums数组，返回插入位置：left
    }


    //求平方根 9->3 8->4->2  18->9->3 ->6->4->5>4
    //18->9->5->3->4
    public static int mySqrt(int x) {
//        if (x == 1) {
//            return 1;
//        }
        long left = 0, right = x;
        while (left <= right) {
            //此处mid是取左中位，如left=4,right=5,mid为4而非5
            long mid = (left + right ) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
            //因为mid是左中位，当区间差值为1时，会陷入循环，如[4,5]
            //因为结果需去掉小数点，则可直接返回left
//            if (right - left == 1) {
//                return (int) left;
//            }
        }
        return (int) left;
    }

    public static int mySqrt1(int x) {
        long left = 0, right = x;
        while (left <= right) {
            //此处取右中位数，left=4,right=5，mid=5
            //取右中位数的好处是能考虑到x=1的情况，不用再单独判断。
            long mid = (left + right + 1) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square > x) {
                right = mid;
            } else {
                left = mid;
            }
            //无论取左还是右中位数，这里都会存在区间差为1，此判断都能解决陷入死循环的情况
            if (right - left == 1) {
                return (int) left;
            }
        }
        return (int) left;
    }


}
