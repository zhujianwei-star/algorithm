package com.example.kruskal;

import java.util.Arrays;

/**
 * @author ZhuJW
 * @classname KruskalCase
 * @description 克鲁斯卡尔算法实现
 * @date 2022/6/30 17:16
 */
public class KruskalCase {

    public int edgeNums;
    public char[] vertex;
    public int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vert = {'A','B','C','D','E','F','G'};

        int[][] mat = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        KruskalCase kruskalCase = new KruskalCase(vert, mat);
        kruskalCase.print();


        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertex, int[][] matrix) {
        int vLen = vertex.length;

        this.vertex = new char[vLen];

        System.arraycopy(vertex, 0, this.vertex, 0, vLen);

        this.matrix = new int[vLen][vLen];

        for (int i = 0; i < vLen; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vLen);
        }

        for (int i = 0; i < vLen; i++) {
            for (int j = i; j < vLen; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != INF) {
                    this.edgeNums++;
                }
            }
        }
    }

    public Edge[] getEdges() {
        Edge[] edges = new Edge[this.edgeNums];
        int count = 0;

        for (int i = 0; i < this.vertex.length; i++) {
            for (int j = i; j < this.vertex.length; j++) {
                if (this.matrix[i][j] != INF && this.matrix[i][j] != 0) {
                    edges[count++] = new Edge(this.vertex[i], this.vertex[j], this.matrix[i][j]);
                }
            }
        }
        return edges;
    }

    public void print() {
        System.out.println("邻接矩阵为");
        for (int i = 0; i < this.vertex.length; i++) {
            for (int j = 0; j < this.vertex.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void kruskal() {
        int index = 0;
        Edge[] rets = new Edge[edgeNums];

        int[] ends = new int[edgeNums];

        Edge[] edges = getEdges();

        sortEdges(edges);

        for (Edge edge : edges) {
            // 获取当前边的两边的顶点
            int p1 = getPosition(edge.start);
            int p2 = getPosition(edge.end);

            // 获取两边顶点的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);

            // 表示边的两个顶点的终点不是同一个
            if (m != n) {
                ends[m] = n; // 需要先向终点数组中放入终点数据

                rets[index++] = edge;
            }
        }

        for (int i = 0; i < edgeNums; i++) {
            if (rets[i] != null) {
                System.out.println(rets[i]);
            }
        }
    }

    /**
     * 获取当前顶点序号i对应的终点的序号
     * @param ends
     * @param i
     * @return
     */
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    /**
     * 返回传入的顶点的下标
     * @param vert
     * @return
     */
    public int getPosition(char vert) {
        for (int i = 0; i < vertex.length; i++) {
            if (vert == vertex[i]) {
                return i;
            }
        }
        return -1;
    }

    public void sortEdges(Edge[] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge tempEdge = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tempEdge;
                }
            }
        }
    }

}

class Edge{
    char start;
    char end;
    int weight;

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
