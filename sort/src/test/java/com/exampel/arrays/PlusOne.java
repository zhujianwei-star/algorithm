package com.exampel.arrays;

import java.util.Arrays;

/**
 * @ClassName : PlusOne
 * @Description: 加一：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * @Author : Zhujw
 * @CreateDate : 2022/2/15 14:09
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9};
//        System.out.println(Arrays.toString(solution(digits)));
        System.out.println(Arrays.toString(officialSolution(digits)));
    }

    /**
     * 这样写的问题，Long型也是有长度的，数组过大容易超长
     * @param digits
     * @return
     */
    private static int[] solution(int[] digits) {
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n += Math.pow(10, ((digits.length - i) - 1)) * digits[i];
        }
        n += 1;
        String s = Long.valueOf(n).toString();
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = Integer.parseInt(Character.toString(c));
            result[i] = num;
        }
        return result;
    }

    /**
     * 官方解法，将数据分为为9和不为9的情况，为9就进1，不为9就直接+1返回
     * @param digits
     * @return
     */
    private static int[] officialSolution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] nums = new int[(digits.length + 1)];
        nums[0] = 1;
        return nums;
    }

}
