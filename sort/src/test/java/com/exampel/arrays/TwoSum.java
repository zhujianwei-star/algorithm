package com.exampel.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : TwosUM
 * @Description: 两数之和，求一个数组中两数相加等于目标数，返回此两数下标
 * @Author : Zhujw
 * @CreateDate : 2022/2/16 8:44
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
//        System.out.println(Arrays.toString(solution(nums, target)));
        System.out.println(Arrays.toString(officialSolution(nums, target)));
    }

    /**
     * 暴力解法，时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private static int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 题解解法：使用hashMap解法
     * @param nums
     * @param target
     * @return
     */
    private static int[] officialSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
