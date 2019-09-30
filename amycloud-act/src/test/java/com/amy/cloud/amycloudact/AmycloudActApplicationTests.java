package com.amy.cloud.amycloudact;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmycloudActApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

    //1000021

    public static void main(String[] args) {
        int[] nums = {6, 0, 7, 3, 0, 3}; //4  2  [0,3]
        String strs[] = {"flower", "flow", "flight"};

        int target = 8;
//        System.out.println(searchInsert(nums, target));
//        System.out.println(1);
//        System.out.println(mySqrt1(18));
//        System.out.println(mySqrt1(2147395599));
//        System.out.println(removeDuplicates1(nums));
//        System.out.println(longestCommonPrefix(strs));
        System.out.println(countAndSay(2));
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
            long mid = (left + right) / 2;
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

    //原地修改，不使用额外的数组空间。额外空间为O(1)
    //[1,1,2,2,3]-> [1,2,3]
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        // i指针，nums中下标0到下标i的元素为非重复元素
        // 遍历nums数组，j从下标1开始
        for (int j = 1; j < nums.length; j++) {
            // 因为nums是有序数组，当nums[j]!=nums[i]时，num[j]即为当前非重复元素。
            // num[j]的值复制到nums[i+1]上
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        //数组中前i+1个元素
        return i + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            if (!map.containsKey(nums[j])) {
                map.put(nums[j], j);
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    //["flower", "flow", "flight"]
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        String result = "";
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(firstStr) != 0) {
                result = firstStr.substring(0, strs.length - 1);
            }
        }

        return result;
    }

    //["flower", "flow", "flight"]
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            //若strs[i].indexOf(prefix)=0，表示prefix包含于strs[i]，从下标0开始
            while (strs[i].indexOf(prefix) != 0) {
                //若prefix不完全包含于strs[i],将prefix去掉末尾一位
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //1 11 21 1211 111221 312211 13112221 1113213211
    //

    public static String countAndSay(int n) {
        String lastStr = "1";
        for (int i = 2; i <= n; i++) {
            int repeatedNum = 1;
            char lastChar = 0;
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < lastStr.length(); j++) {
                if (lastStr.charAt(j) == lastChar) {
                    repeatedNum++;
                    result.delete(result.length() - 2, result.length());
                }
                result.append(repeatedNum).append(lastStr.charAt(j));
                lastChar = lastStr.charAt(j);
            }
            lastStr = result.toString();
        }
        return lastStr;
    }
}
