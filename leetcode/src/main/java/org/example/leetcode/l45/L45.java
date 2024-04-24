package org.example.leetcode.l45;

/**
 * @description: 第L45题 - 跳跃游戏 II
 * @question: <a href="https://leetcode-cn.com/problems/jump-game-ii/">...</a>
 * @answer: 使用贪心算法
 */
public class L45 {

    public static void main(String[] args) {
        // int[] nums = {2,3,1,1,4};
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int result = jump(nums);
        System.out.println(result);
    }

    public static int jump(int[] nums) {
        int maxValue = 0;
        int result = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxValue = Math.max(maxValue, i + nums[i]);
            if (end == i) {
                end = maxValue;
                result++;
            }
        }
        return result;
    }

}
