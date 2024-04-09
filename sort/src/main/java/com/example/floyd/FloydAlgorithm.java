package com.example.floyd;

import java.util.Arrays;

/**
 * @author ZhuJW
 * @classname FloydAlgorithm
 * @description 弗洛伊德算法解决最小生成树问题
 * @date 2022/7/3 23:40
 */
public class FloydAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph{
    // 存放顶点的数组
    private char[] vertex;
    // 保存从各个顶点出发到其他顶点的距离，最后的结果，也是保留在该数组
    private int[][] dis;
    // 保存到达目标结点的前驱顶点
    private int[][] pre;

    public Graph(int length,int[][] matrix, char[] vertex) {

        this.vertex = vertex;

        this.dis = matrix;

        this.pre = new int[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void show() {

        // 为了显示方便阅读，我们优化一下输出
        for (int k = 0; k < dis.length; k++) {
            // 先将pre数组输出一行，表示前驱结点
            for (int j = 0; j < dis.length; j++) {
                System.out.print(this.vertex[pre[k][j]] + "\t");
            }
            System.out.println();
            // 输出dis一行数据
            for (int j = 0; j < dis.length; j++) {
                System.out.print("(" + this.vertex[k] + "到" + this.vertex[j] + "的最短路径为" + dis[k][j] + ")\t");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void floyd() {
        // 对中间顶点遍历，k 就是中间顶点的下标
        for (int k = 0; k < dis.length; k++) {
            // 从顶点i出发
            for (int i = 0; i < dis.length; i++) {
                // 到达j顶点
                for (int j = 0; j < dis.length; j++) {
                    int len = dis[i][k] + dis[k][j]; // 求从顶点i触发，经过k顶点，到达j顶点的距离
                    if (len <  dis[i][j]) { // 如果len小于dis[i][j]
                        dis[i][j] = len; // 更新距离
                        pre[i][j] = pre[k][j]; // 更新前驱结点
                    }
                }
            }
        }
    }
}
