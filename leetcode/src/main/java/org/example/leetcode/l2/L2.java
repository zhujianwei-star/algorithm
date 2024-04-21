package org.example.leetcode.l2;

/**
 * @description: 第二题 两数相加
 * @question: <a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 * @answer: 此题的意思是如链表节点是 1 7 3 4第二个链表节点是4 5 6，需要将两链表数据相加， 如
 *      1  7  3  4
 *      4  5  6
 *     ============
 *      5  2  0  5
 *  最后返回一个节点为5 2 0 5的链表，本质是将两个链表的每一个数字相加，并进位，然后重复这个过程
 */
public class L2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        while (result!= null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置一个虚拟的节点存储相加的数据
        ListNode head = new ListNode(0);
        // 设置一个cur节点，在循环中存储链表节点
        ListNode cur = head;
        // 设置一个临时变量存储进位数据以及进位与当前数组相加的结果
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            temp += val1 + val2;
            // 当前节点的值，进位+当前链表相加的值 % 10
            ListNode next = new ListNode(temp % 10);
            cur.next = next;
            cur = next;
            // 进位值，进位+当前链表相加的值 / 10
            temp /= 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
