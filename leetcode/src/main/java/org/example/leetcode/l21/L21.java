package org.example.leetcode.l21;

import org.example.leetcode.ListNode;

/**
 * @description: 第L21题 - 合并两个有序链表
 * @question: <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">...</a>
 * @answer:
 */
public class L21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(list1, list2);
        System.out.println(result);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode currentNode = new ListNode();
        listNode.next = currentNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        if (list1 != null) {
            currentNode.next = list1;
        }
        if (list2 != null) {
            currentNode.next = list2;
        }

        return listNode.next.next;
    }

}
