package org.example.leetcode.l274;

import java.util.Arrays;

/**
 * @description: 第L274题 - H 指数
 * @question: <a href="https://leetcode-cn.com/problems/h-index/">...</a>
 * @answer:
 */
public class L274 {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int hIndex = hIndex(citations);
        System.out.println(hIndex);
    }

    public static int hIndex(int[] citations) {
        int num = 0;
        int[] array = Arrays.stream(citations).sorted().toArray();

        for (int i = array.length - 1; i >= 0; i--) {
            num = Math.max(num, Math.min(array.length - i, array[i]));
        }
        return num;
    }

}
