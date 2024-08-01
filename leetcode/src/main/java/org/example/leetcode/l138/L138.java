package org.example.leetcode.l138;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第L138题 - 随机链表的复制
 * @question: <a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">...</a>
 * @answer: 该题目的难点是如果使用节点next的链表创建节点，则无法保证random链表在设置节点时，节点已经被创建，而如果使用random链表的方式创建节点，又无法保证设置next链表时，节点已经被创建，
 *  所以直接使用Map，将已经创建的节点保存下来，然后如果map中存在，则直接赋值，如果不存在，就先创建，然后将值设置进入map中
 */
public class L138 {

    static Map<Node, Node> cacheNode = new HashMap<>();

    public static void main(String[] args) {
        // 给例数据
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        // 复制链表
        Node newHead = copyRandomList(head);

        // 打印链表
        Node p = newHead;
        while (p!= null) {
            System.out.print(p.val + "-" + (p.random == null ? "null" : p.random.val) + " ");
            p = p.next;
        }
    }

    private static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (cacheNode.containsKey(head)) {
            return cacheNode.get(head);
        }
        Node node = new Node(head.val);
        cacheNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


