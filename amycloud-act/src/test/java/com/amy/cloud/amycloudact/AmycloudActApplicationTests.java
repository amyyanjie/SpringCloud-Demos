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


    public static void main(String args[]) {

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