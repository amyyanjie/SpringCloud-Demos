package com.amy.cloud.amycloudact;

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

    public static void main(String args[]) {

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

    public ListNode deleteDuplicatesII2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // pre指针，指向空头结点
        ListNode pre = dummy;
        // cur指针，指向head头结点
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                // 当cur.val == cur.next.val
                // cur指针后移动，直到找到与cur.val不同的值
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 通过循环，cur指向该重复元素中的最后一个元素
                // 此时，pre的next指针指向cur下一元素，消除了此重复元素
                pre.next = cur.next;
                // 注意此时并不会：pre = pre.next;pre不会向前移动，因为pre.next元素还可能是另一重复元素
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public int singleNumber(int[] nums) {
        //其余都出现两次，只有一个数出现一次
        //[4,1,2,1,2]
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }

        }
        return 0;
    }
}