package org.example.leetcode.l27;

/**
 * @description: 第L27题 ： 移除元素
 * @question: <a href=" https://leetcode-cn.com/problems/remove-element/">...</a>
 * @answer: 使用双指针解法, 左指针为不是指定元素的位置，右指针为当前循环，比如给定为3，
 *  那么第一轮循环时，左指针就会为0，
 *  而到第二轮循环，右指针的数据就可以放在左指针的位置上，并且左指针++，到最后，因为左指针是从0开始，所以左指针++位置就为不是给定值的数量
 */
public class L27 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int len = removeElement(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
                continue;
            }
            nums[left] = nums[i];
            left++;
        }
        return left;
    }
}
