package com.example.knapsackproblem;

import java.util.Arrays;

/**
 * @author ZhuJW
 * @classname KnapsackProblem
 * @description 动态规划算法之不完全背包算法
 * @date 2022/6/20 16:40
 */
public class KnapsackProblem {

    /**
     * 将三个不同重量的商品存放到背包中，不可以放入相同的东西，求出放入价值最高的情况的放入的商品
     */
    public static void main(String[] args) {

        // 商品信息数组
        // 价格
        int[] val = {1500, 3000, 2000};
        // 重量
        int[] w = {1, 4, 3};

        // 背包大小
        int m = 4;

        // 物品个数
        int n = val.length;

        // 创建二维数组
        // v[i][j]表示前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        // 加入的路径，用来后面获取放入的路径
        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; // 设置第一列为0
        }

        // 设置第一行为0
        Arrays.fill(v[0], 0);

        // 根据前面得到的公式来进行动态规划的处理
        for (int i = 1; i < v.length; i++) { // 下标从1开始，因为第一列已经被设置为0
            for (int j = 1; j < v[0].length; j++) { // 下标从1开始，因为第一行已经被设置为0
                // 公式
                if (w[i - 1] > j) { // 因为程序是从i为1开始的，所以原来公式中的w[i]需要改为w[i - 1]
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] > val[i - 1] + v[i - 1][j - w[i - 1]]){
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }
                }
            }
        }

        // 打印一下数组
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + "  ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("将第%d个商品放入到背包\n",i);
                j -= w [i - 1];
            }
            i--;
        }
    }

}
