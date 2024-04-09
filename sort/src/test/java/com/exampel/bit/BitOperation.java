package com.exampel.bit;

/**
 * @ClassName : BitOperation
 * @Description: 位运算
 * @Author : Zhujw
 * @CreateDate : 2022/2/10 15:04
 */
public class BitOperation {

    /**
     * 一个数组中有两个数为奇数个，需要时间复杂度是O(n)空间复杂度是O(1)来求出两个数为奇数个的数是哪两个
     * @param arr
     */
    public static void printOddTimes(int[] arr) {

        int eor = 0, onlyOne = 0, onlyTwo = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        // eor = a ^ b;
        // eor != 0;
        // eor必然有一个位置为1
        int rightOne = eor & (~eor + 1); // 求出异或出来的数据的原码最右侧的一的数据

        for (int i : arr) {
            // 使用数组中的值&rightOne可以将数组中两个奇数的值分到两个区域
            if ((i & rightOne) == 0) {
                // 该区域中处理一个数为奇数以外其他的数都为偶数，所以异或出来后的数就为该奇数
                onlyOne ^= i;
            }
        }

        for (int i : arr) {
            if ((i & rightOne) == 1) {
                onlyTwo ^= i;
            }
        }
        System.out.println(onlyOne + "\t" + onlyTwo);
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 8, 9, 12, 12, 77, 77};
        printOddTimes(arr);
    }


}
