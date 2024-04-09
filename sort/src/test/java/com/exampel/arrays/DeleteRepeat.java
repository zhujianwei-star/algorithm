package com.exampel.arrays;

import java.util.Arrays;

/**
 * @ClassName : DeleteRepect
 * @Description: 删除升序数组中的前后重复的元素，返回剩余元素数组的长度。如{1, 1, 2}返回2
 * @Author : Zhujw
 * @CreateDate : 2022/2/13 21:59
 */
public class DeleteRepeat {

    /**
     * 自己的题解，不可能使用这种方式，因为要记录每次不同数据的个数，然后将数据后面的数据往前移。所以只能用!=号加上每次不同数据出现对的次数，不能使用总个数减去相同个数
     * @param nums
     * @return 数组中不同个数的数量
     */
    public static int Solution(int[] nums) {
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[temp++] = nums[1];
            }
        }
        return temp;
    }

    public static int OtherSolution(int[] nums) {
        int t = 0;
        for (int i = 0; i < nums.length; i ++ ) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[t ++ ] = nums[i];
            }
        }
        return t;
    }


    /**
     * 官方题解
     * @param nums
     * @return
     */
    public static int OfficialSolution(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        int fast = 1, slow = 1;
        if (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++ fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(Solution(nums));
//        System.out.println(OfficialSolution(nums));
//        System.out.println(OtherSolution(nums));
    }

}
