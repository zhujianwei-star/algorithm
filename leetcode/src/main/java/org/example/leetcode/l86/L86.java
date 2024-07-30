package org.example.leetcode.l86;

import org.example.leetcode.ListNode;

/**
 * @description: 第L86题 - 分隔链表
 * @question: <a href="https://leetcode-cn.com/problems/partition-list/">...</a>
 * @answer:
 */
public class L86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode node = partition(head, 3);
        while (node!= null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (head != null) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
            } else {
                p1.next = head;
                p1 = p1.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = head2.next;
        return head1.next;
    }

}
