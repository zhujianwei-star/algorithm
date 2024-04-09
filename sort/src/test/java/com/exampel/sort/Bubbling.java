package com.exampel.sort;

import java.util.Arrays;

/**
 * @ClassName : Bubbling
 * @Description: 冒泡算法从小到大
 * @Author : Zhujw
 * @CreateDate : 2022/2/4 12:49
 */
public class Bubbling {

    /**
     * 冒泡排序从小到大排。
     * 要不两两比较把大的数据往后放，那么就需要从后往前开始循环，第一次外循环结束需要拿到最大的数据；
     * 要不就是把小的数据往前放，那么就需要从前往后开始做外循环，但是内循环就需要从后往前，因为需要在第一次外循环结束时获取最小的数据到第一个位置
     * @param arr
     */
    public static void Bubbling(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            System.out.println(111);

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int arr[], int i, int j) {
        System.out.println("开始" + Arrays.toString(arr));
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
        System.out.println("结束" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 9, 4, 6, 12, 7};
        Bubbling(arr);
    }
}
