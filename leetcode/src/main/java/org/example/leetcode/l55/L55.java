package org.example.leetcode.l55;

/**
 * @description: 第L55题 - 跳跃游戏
 * @question: <a href="https://leetcode-cn.com/problems/jump-game/">...</a>
 * @answer: 使用贪心算法
 */
public class L55 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
