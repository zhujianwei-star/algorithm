package org.example.leetcode.l88;

/**
 * @description: 第L88题，合并两个有序数组
 * @question: <a href="https://leetcode-cn.com/problems/merge-sorted-array ">...</a>
 * @answer: 将数组从后往前遍历，然后将值设置进入数组，直到两个数组都遍历完。
 *  遍历两个数组并且时间复杂度是O(m+n)可以使用while循环，先获取两个数组的长度，如果有一个小于0，直接退出循环
 *  如果使用双重for循环，时间复杂度就是O(m^n)
 */
public class L88 {

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        /*int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;*/
        /*int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;*/
        merge(nums1, m, nums2, n);
        for (int j : nums1) {
            System.out.print(j + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 同时遍历两个数组的方式
        int p1 = m - 1 , p2 = n - 1, i = nums1.length;
        while (p1 >= 0 && p2 >= 0) {
            i--;
            if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
        // 处理循环结束后nums2中还有值的情况
        if (--i >= 0) {
            for (int i1 = i; i1 >= 0; i1--) {
                if (p2 >= 0) {
                    nums1[i1] = nums2[p2];
                    p2--;
                }
            }
        }
    }


}
