package com.exampel.linkedList;

import java.util.List;

/**
 * @author ZhuJW
 * @classname IsPalindrome
 * @description TODO
 * @date 2022/4/7 11:49
 */
public class IsPalindrome {

    private static boolean solution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);

        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return  result;
    }

}
