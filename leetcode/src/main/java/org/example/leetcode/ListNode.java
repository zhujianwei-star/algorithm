package org.example.leetcode;

/**
 * @description: 链表类
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode() {

    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
