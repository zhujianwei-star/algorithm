package org.example.leetcode.l80;

/**
 * @description: 第L80题 - 删除有序数组中的重复项 II
 * @question: <a href=" https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">...</a>
 * @answer:
 */
public class L80 {

    public static void main(String[] args) {
        // int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {1,1,1,2,2,2,3,3};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int left = 1;
        int value = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (value == nums[i]) {
                count++;
                if (count > 2) {
                    nums[i] = 0;
                    continue;
                }
            } else{
                count = 1;
            }
            value = nums[i];
            nums[left] = nums[i];
            left++;
        }
        return left;
    }

}
