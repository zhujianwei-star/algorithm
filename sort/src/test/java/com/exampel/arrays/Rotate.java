package com.exampel.arrays;

import java.util.Arrays;

/**
 * @ClassName : Rotate
 * @Description: 旋转数组
 * @Author : Zhujw
 * @CreateDate : 2022/2/14 15:35
 */
public class Rotate {

    public static void main(String[] args) {
        int[]  nums = {1,2,3,4,5,6,7,8};
        int  k = 3;
//        System.out.println(Arrays.toString(Solution(nums, k)));
//        System.out.println(Arrays.toString(OfficialSolution1(nums, k)));
        System.out.println(Arrays.toString(OfficialSolution2(nums, k)));
    }

    /**
     * 自己的题解
     * @param nums
     * @param k
     * @return
     */
    private static int[] Solution(int[] nums, int k) {
        int n = 1;
        while (n <= k) {
            int num = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = num;
            n++;
        }
        return nums;
    }

    /**
     * 官方解法1：使用新数组解反转数组
     * @param nums
     * @param k
     * @return
     */
    private static int[] OfficialSolution1(int[] nums, int k) {
        int n = nums.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, n);
        return nums;
    }

    /**
     * 官方解法2：使用翻转数组反转数组
     * @param nums
     * @param k
     * @return
     */
    private static int[] OfficialSolution2(int[] nums, int k) {
        int n = nums.length;
        reserve(nums, 0, n-1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, n - 1);
        return nums;
    }

    private static void reserve(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

}
