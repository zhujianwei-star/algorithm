package com.exampel.tree;

/**
 * @author ZhuJW
 * @classname TreeNode
 * @description 双向链表
 * @date 2022/4/14 9:14
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
