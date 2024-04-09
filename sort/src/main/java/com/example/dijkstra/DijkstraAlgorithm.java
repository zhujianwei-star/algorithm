package com.example.dijkstra;

import java.util.Arrays;

/**
 * @author ZhuJW
 * @classname DijkstraAlgorithm
 * @description 迪捷斯特拉算法
 * @date 2022/7/1 15:42
 */
public class DijkstraAlgorithm {

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
        Graph graph = new Graph(vertex, matrix);
        graph.print();
        graph.dks();
    }

}

class Graph {
    char[] vertex;
    int[][] matrix;
    VisitedVertex vv;

    public Graph (char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void print() {
        for (int i = 0; i < this.vertex.length; i++) {
            for (int j = 0; j < this.vertex.length; j++) {
                System.out.printf("%8d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void dks() {
        vv = new VisitedVertex(this.vertex.length, 2);
        update(2);
        for (int j = 0; j < vertex.length; j++) {
            int i = updateArr();
            update(i);
        }

        System.out.println(Arrays.toString(vv.alreadyArr));
        System.out.println(Arrays.toString(vv.preArr));
        System.out.println(Arrays.toString(vv.dis));
    }

    private void update(int index) {
        for (int i = 0; i < matrix[index].length; i++) {
            int len = vv.dis[index] + matrix[index][i];
            if (!vv.in(i) && len < vv.dis[i]) {
                vv.updateDis(i, len);
                vv.updatePre(i, index);
            }
        }
    }

    private int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < vv.alreadyArr.length; i++) {
            if (vv.alreadyArr[i] == 0 && vv.dis[i] < min) {
                min = vv.dis[i];
                index = i;
            }
        }
        vv.alreadyArr[index] = 1;
        return index;
    }
}


class VisitedVertex{
    // 记录各个顶点是否访问过，1表示访问过，0表示未访问，会动态更新
    int[] alreadyArr;
    // 记录触发顶点到其他顶点的距离，比如G未出发点，就会记录G到其他顶点的距离，会动态更新，求的最短距离就会放到dis
    int[] dis;
    // 每一个下标对应的值为前一个顶点的下标，会动态更新
    int[] preArr;

    public VisitedVertex(int length, int index) {
        this.alreadyArr = new int[length];
        this.dis = new int[length];
        this.preArr = new int[length];
        this.alreadyArr[index] = 1;
        Arrays.fill(dis, 65535);

        dis[index] = 0;
    }

    /**
     * 判断传入的节点索引是否被访问过
     * @return
     */
    public boolean in(int index) {
        return alreadyArr[index] == 1;
    }

    /**
     * 更新dis中的长度为传入的长度
     * @param index
     * @param num
     */
    public void updateDis(int index, int num) {
        dis[index] = num;
    }

    /**
     * 更新index的前驱节点为num
     * @param index
     * @param num
     */
    public void updatePre(int index, int num) {
        preArr[index] = num;
    }

    /**
     * 获取dis中的长度数据
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }
}
