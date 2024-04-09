package com.exampel.arrays;

import java.util.*;

/**
 * @ClassName : Intersect
 * @Description: 两个数组的交集
 * @Author : Zhujw
 * @CreateDate : 2022/2/15 9:20
 */
public class Intersect {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(2^1);
//        System.out.println(Arrays.toString(solution1(num1, num2)));
        System.out.println(Arrays.toString(solution2(num1, num2)));
    }

    /**
     * 看了别人的讨论之后写出，双指针解法
     * @param num1
     * @param num2
     * @return
     */
    private static int[] solution1(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                i++;
            }else if (num1[i] > num2[j]) {
                j++;
            }else {
                list.add(num1[i]);
                i++;
                j++;
            }
        }
        // 将list转换为数组
        int index = 0;
        int[] result = new int[list.size()];
        for (Integer integer : list) {
            result[index++] = integer;
        }
        return result;
    }

    /**
     * 看了别人的题解写出，使用Map集合
     * @param num1
     * @param num2
     * @return
     */
    private static int[] solution2(int[] num1, int[] num2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // 遍历第一个数组，将其中的数据放入到Map集合中去，如果有多个就+1
        for (int i : num1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : num2) {
            if (map1.getOrDefault(i, 0) > 0) {
                list.add(i);
                map1.put(i, map1.get(i) - 1);
            }
        }
        // 将list转换为数组
        int index = 0;
        int[] result = new int[list.size()];
        for (Integer integer : list) {
            result[index++] = integer;
        }
        return result;
    }

}
