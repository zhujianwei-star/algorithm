package com.example.binarysearchnorecison;

/**
 * @author ZhuJW
 * @classname BinarySearch
 * @description 二分查找没有递归
 * @date 2022/6/19 18:18
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 100};
        int target = 3;
        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1,mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
