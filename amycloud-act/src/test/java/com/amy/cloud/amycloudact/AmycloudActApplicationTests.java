package com.amy.cloud.amycloudact;

import javafx.util.Pair;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return pre.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    //输入: 1->2->3->3->3->4->4->5  排序链表
    //输出: 1->2->5
    public ListNode deleteDuplicatesII(ListNode head) {
        //为了防止删除头节点，需建立空节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            // 如果出现重复元素，创建临时指针temp，temp指向重复元素中的第一个元素
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                // 通过循环区中，temp直至指向重复元素中的最后一个元素
                // 此时，cur的next指针指向temp下一元素，消除了此重复元素
                cur.next = temp.next;
                // 注意此时并不会：cur=cur.next，因为cur.next元素只是与当前重复元素temp值不同，可能与cur.next.next元素重复
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //其余都出现两次，只有一个数出现一次
    //[4,1,2,1,2]
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();


        return null;

    }


    public static void main(String args[]) {
        List list = Arrays.asList("a", "b", "c");
        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));

        String[] s = {"a", "b", "c"};
        List<String> listString = Stream.of(s).collect(Collectors.toList());
//        System.out.println(listString.toString());
        List<String> list3 = Arrays.stream(s).collect(Collectors.toList());

        //集合转数组
        String[] a = Stream.of(listString).toArray(String[]::new);
        String[] a1 = listString.stream().toArray(String[]::new);


        String[] b = listString.toArray(new String[0]);
        StringBuilder res = new StringBuilder();
        for (String s1 : b) {
            res.append(s1);
        }
//        System.out.println(res);
        String[] c = listString.toArray(new String[0]);


    }


    public boolean isLetterOrDigit(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    public char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        }
        return ch;
    }

    //链表有环 哈希表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;

        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //自底向上的层次遍历
    //广度优先遍历，从上向下
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                nodeList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.addFirst(nodeList);
        }
        return res;
    }

    //[3,9,20,null,null,15,7],
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root.left) + 1;
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


}