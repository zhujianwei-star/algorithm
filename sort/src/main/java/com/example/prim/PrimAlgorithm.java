package com.example.prim;

import java.util.Arrays;

/**
 * @author ZhuJW
 * @classname PrimAlgorithm
 * @description 普利姆算法之求出修路的权值最小的案例
 * @date 2022/6/26 16:56
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        char[] data = {'A','B','C','D','E','F','G'};
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        graph.createGraph(7, data, weight);
        graph.showGraph();
        graph.prim(0);

    }
}

class Graph{
    // 存放节点个数
    Integer vertex;
    // 存放节点数据
    char[] data;
    // 存放边的权重
    int[][] weight;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.data = new char[vertex];
        this.weight = new int[vertex][vertex];
    }

    public void createGraph(int vertex, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < vertex; i++) {
            this.data[i] = data[i];
            for (j = 0; j < vertex; j++) {
                this.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph() {
        for (int[] ints : this.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void prim(int v) {
        int[] visited = new int[this.vertex];

        visited[v] = 1;

        // 先用这个大数表示最小的权重，后面进行替换
        int minWeight = 10000;

        // 用h1 h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;

        // 因为有vertex个顶点，所以循环结束后，应该有vertex - 1条边
        for (int k = 1; k < this.vertex; k++) {

            for (int i = 0; i < this.vertex; i++) {
                for (int j = 0; j < this.vertex; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && weight[i][j] < minWeight) {
                        minWeight = weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + this.data[h1] + ", " + this.data[h2] + "> 权值：" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}
