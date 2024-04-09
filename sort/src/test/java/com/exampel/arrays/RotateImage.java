package com.exampel.arrays;

import java.util.Arrays;

/**
 * @ClassName : RotateImage
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/2/16 15:10
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(Arrays.deepToString(solution(matrix)));
    }

    /**
     * 看了题解后写出，先上下反转，在对角线反转
     * @param matrix
     * @return
     */
    private static int[][] solution(int[][] matrix) {
        int n = 0, mid = (matrix.length - 1) >> 1;
        while (n <= mid) {
            int[] nums = matrix[(matrix.length - 1) - n];
            matrix[(matrix.length - 1) - n] = matrix[n];
            matrix[n] = nums;
            n++;
        }
        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int num = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = num;
            }
        }
        return matrix;
    }
}
