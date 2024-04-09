package com.exampel.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : Select
 * @Description: 选择排序算法，从小到大，选择排序是使用下标找到数据的最小值算法
 * @Author : Zhujw
 * @CreateDate : 2022/2/4 12:37
 */
public class Select {

    /**
     * 选择排序，根据最小值的下标来获取最小值，然后将最小值设置在外循环的位置
     * @param arr
     */
    public static void select(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { // 选择范围，由0 ~ N-1，然后设置最小值下标为i
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // 进行比较，获得实际的最小值下标，比较的范围是i+1 ~ N
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int arr[], int i, int minIndex) {
        int a = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = a;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 9, 4, 6, 12, 7};
        select(arr);
    }

}
