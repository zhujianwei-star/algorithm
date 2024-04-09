package com.exampel.arrays;

import java.util.Arrays;

/**
 * @ClassName : MoveZeroes
 * @Description: 将数组中的0往后移，非0数往前移，但是数组的相对位置不变
 * @Author : Zhujw
 * @CreateDate : 2022/2/15 15:04
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 5};
//        System.out.println(Arrays.toString(solution1(nums)));
        System.out.println(Arrays.toString(solution2(nums)));
//        System.out.println(Arrays.toString(solution3(nums)));
    }

    /**
     * 解法1：留一个指针，将不为0的数据与指针位置数据替换，然后将指针后面的数据改为0
     * @param nums
     * @return
     */
    private static int[] solution1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = nums.length - 1; i >= index; i--) {
            nums[i] = 0;
        }
        return nums;
    }

    /**
     * 解法2：留一个指针，将不为0的数据与指针位置数据交换
     * @param nums
     * @return
     */
    private static int[] solution2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                nums[i] = 0;
                index++;
            }
        }
        return nums;
    }

    /**
     * 解法3：使用指针i统计的是前面0的个数，j-i指向第一个0的位置，然后将j的位置与j-i的位置的值交换
     * @param nums
     * @return
     */
    private static int[] solution3(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                n++;
            } else {
                nums[i - n] = nums[i];
                nums[i] = 0;
            }
        }
        return nums;
    }

}
