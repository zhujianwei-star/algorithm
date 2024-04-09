package com.exampel.arrays;

/**
 * @ClassName : SingleNumber
 * @Description: 取出数组中只出现一次的数字
 * @Author : Zhujw
 * @CreateDate : 2022/2/14 18:27
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }

}
