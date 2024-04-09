package com.exampel.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : ContainsDuplicate
 * @Description: 包含重复数据元素
 * @Author : Zhujw
 * @CreateDate : 2022/2/14 17:31
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(Solution1(nums));
        System.out.println(Solution2(nums));
    }

    /**
     * 使用set集合方法
     * @param nums
     * @return
     */
    private static boolean Solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 排序之后再去比较
     * @param nums
     * @return
     */
    private static boolean Solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
