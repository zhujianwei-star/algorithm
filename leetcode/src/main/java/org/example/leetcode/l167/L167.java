package org.example.leetcode.l167;

/**
 * @description: 第L167题-两数之和 II - 输入有序数组
 * @question: <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">...</a>
 * @answer:
 */
public class L167 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                break;
            }
        }
        return new int[]{i+1, j+1};
    }

}
