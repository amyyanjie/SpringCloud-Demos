package com.amy.cloud.amycloudact;

import javafx.util.Pair;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AmycloudActApplicationTests {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 双指针
    // numbers = [2, 7, 11, 15], target = 9
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        int curSum = numbers[p1] + numbers[p2];
        while (curSum != target) {
            if (curSum > target) {
                p2--;
            } else {
                p1++;
            }
            curSum = numbers[p1] + numbers[p2];
        }
        return new int[]{p1 + 1, p2 + 1};
    }


    public static void main(String args[]) {
        System.out.println(convertToTitle(1000));

    }

    //
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return res.reverse().toString();
    }

    // 多数元素 使用Map存储元素次数
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                continue;
            }
            // 若元素在map中存在，将次数+1
            map.put(num, map.get(num) + 1);
            // 次数+1后，当前次数若 > n/2，则为多数元素。
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return nums[0]; //若只有一个元素
    }

    //
    public int majority(int[] nums) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                num=nums[i];
            }else {

            }


        }
        return 0;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    //递归 [1,2]
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左右孩子都为空时，返回1
        if (root.left == null && root.right == null) {
            return 1;
        }
        //左右孩子有一个为空时，返回不为空的孩子节点
        //左右孩子都不为空时，返回最短的孩子节点。
        //[3,9,20,null,null,15,7]
//        if (root.left != null) {
//            return minDepth2(root.left) + 1;
//        }
//        if (root.right != null) {
//            return minDepth2(root.right) + 1;
//        }
        return minDepth2(root.left) + 1;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if (root != null) {
            stack.push(new Pair<>(root, root.val));
        }
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int cur_sum = pair.getValue();
            if (node.left == null && node.right == null && cur_sum == sum) {
                return true;
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, cur_sum + node.left.val));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, cur_sum + node.right.val));
            }
        }
        return false;
    }
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum1(root.left, sum) || hasPathSum1(root.right, sum);
    }


}