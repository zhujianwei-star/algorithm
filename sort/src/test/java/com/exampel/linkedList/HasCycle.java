package com.exampel.linkedList;

import java.util.List;

/**
 * @author ZhuJW
 * @classname HasCycle
 * @description 判断是否为环形链表
 * @date 2022/4/12 21:16
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);

        ListNode list2 = new ListNode(3);

        list1.next = list2;

        list1.next.next = new ListNode(6);

        list1.next.next.next = list2;

        System.out.println(solutionMine(list1));
    }

    private static boolean solutionMine(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
