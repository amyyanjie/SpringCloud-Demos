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
        System.out.println(searchInsert(nums,target));
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



}
