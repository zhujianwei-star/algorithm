package org.example.leetcode.l237;

import org.example.leetcode.ListNode;

/**
 * @description: 第L237题-删除链表中的节点
 * @question: <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">...</a>
 * @answer:
 */
public class L237 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode cur = head;
        while (cur!= null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        deleteNode(head.next);
        System.out.println();
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
