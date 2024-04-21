package org.example.leetcode.l26;

/**
 * @description: 第L26题 - 删除排序数组中的重复项
 * @question: <a href=" https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">...</a>
 * @answer: 使用双指针解法，需要是用value记录不重复的值，左指针为不重复的值的下标。
 */
public class L26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int left = 1;
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (value == nums[i]) {
                nums[i] = 0;
                continue;
            }
            value = nums[i];
            nums[left] = value;
            left++;
        }
        return left;
    }
}
