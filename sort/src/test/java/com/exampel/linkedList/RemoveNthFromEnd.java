package com.exampel.linkedList;

/**
 * @ClassName : RemoveNthFromEnd
 * @Description: 清除链表的倒数第n个元素，返回清除过后的链表
 * @Author : Zhujw
 * @CreateDate : 2022/3/3 20:10
 */
public class RemoveNthFromEnd {

    private static ListNode solution(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        // last=0表示删除的是头节点
        if (last == 0) {
            return pre.next;
        }
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    private static int length(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
