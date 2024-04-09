package com.exampel.linkedList;

/**
 * @ClassName : DeleteNode
 * @Description: 请编写一个函数，用于删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 * @Author : Zhujw
 * @CreateDate : 2022/2/25 16:32
 */
public class DeleteNode {

    private static ListNode solution(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        return node;
    }
}
