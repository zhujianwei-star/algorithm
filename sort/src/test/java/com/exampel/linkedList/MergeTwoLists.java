package com.exampel.linkedList;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName : MergeTwoLists
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/3/4 21:50
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);

        list1.next = new ListNode(3);

        list1.next.next = new ListNode(6);

        ListNode list2 = new ListNode(2);

        list2.next = new ListNode(4);

        list2.next.next = new ListNode(5);

        ListNode solution = solution(list1, list2);


    }

    private static ListNode solution(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    private static ListNode solution1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode list = new ListNode();
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                list.next = list2;
                list2 = list2.next;
            } else {
                list.next = list1;
                list1 = list1.next;
            }
        }
        return list.next;
    }


    private static Long solution(long n) {
        if (n <= 1) {
            return n;
        }
        return solution(n-1) * n;
    }
}
