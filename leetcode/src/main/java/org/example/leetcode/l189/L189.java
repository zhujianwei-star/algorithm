package org.example.leetcode.l189;

import java.util.Arrays;

/**
 * @description: 第L189题 - 轮转数组
 * @question: <a href="https://leetcode-cn.com/problems/rotate-array/">...</a>
 * @answer: 使用翻转的方式，寻找规律，数组[1, 2, 3, 4, 5, 6, 7]往后移三位结果为[5,6,7,1,2,3,4]，其实是将数组先全部翻转为[7,6,5,4,3,2,1]
 *  然后再将前「k mod nums.length - 1」位数组翻转，得到[5, 6, 7, 4, 3, 2, 1]
 *  然后再将后「k mod nums.length」到「nums.length」位数组翻转，得到[5,6,7,1,2,3,4]
 */
public class L189 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k); // [5,6,7,1,2,3,4]
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k %  nums.length - 1);
        reverse(nums, k %  nums.length, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start += 1;
            end -= 1;
        }
    }
}
