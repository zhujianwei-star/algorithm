package org.example.leetcode.l169;

/**
 * @description: 第L169题 - 多数元素
 * @question: <a href="https://leetcode-cn.com/problems/majority-element/">...</a>
 * @answer: 投票算法，分治算法
 * 分治算法: 找出数组中大于n/2的元素，然后如果把这个数组拆分为左右两个数组，那么n/2个元素必定在其中，
 *  那么一直往下找，知道找到数组为1了的情况返回改元素，然后在回溯中判断那个元素更多，多个那个直接返回，当作当前数组的众数
 *
 * 投票算法：获取众数，定义一个变量num，和一个变量count，用来判读数组中的数在num中出现的数量，如果count为0，那么把当前数据放入num中，如果当前数和num相同，那么count+1，否则count-1
 *
 */
public class L169 {

    public static void main(String[] args) {
        // int[] nums = {3, 2, 3};
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    private static int majorityElement(int[] nums) {
        int count = 0,num = 0;
        for (int j : nums) {
            if (count == 0) {
                num = j;
                count++;
                continue;
            }
            if (num == j) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

    /* 分治算法
    public static int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private static int majorityElement(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (right - left) / 2 + left;
        int leftResult = majorityElement(nums, left, mid);
        int rightResult = majorityElement(nums, mid + 1, right);

        // 判断数组中哪个元素的数量更多
        int leftCount = countInRange(nums, leftResult, left, right);
        int rightCount = countInRange(nums, rightResult, left, right);

        return leftCount > rightCount ? leftResult : rightResult;
    }

    private static int countInRange(int[] nums, int result, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == result) {
                count++;
            }
        }
        return count;
    }*/


}
