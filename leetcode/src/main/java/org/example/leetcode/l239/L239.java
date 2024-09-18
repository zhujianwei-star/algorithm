package org.example.leetcode.l239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 第L239题-滑动窗口最大值
 * @question: <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">...</a>
 * @answer:
 */
public class L239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length < k) {
            return new int[0];
        }
        int front = k, later=0;
        while (front <= nums.length) {
            int max = nums[later];
            for (int i = later; i < front; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            list.add(max);
            later++;
            front++;
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

}
