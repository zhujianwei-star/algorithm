package com.exampel.linkedList;

/**
 * @ClassName : ListNode
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/2/25 16:52
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
