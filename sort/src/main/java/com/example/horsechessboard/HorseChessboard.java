package com.example.horsechessboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhuJW
 * @classname HorseChessboard
 * @description 马踏棋盘算法
 * @date 2022/7/4 22:15
 */
public class HorseChessboard {

    public static int X; // 行
    public static int Y; // 列
    private static boolean[] visited; // 是否被访问过
    private static boolean finished; // 是否完成

    public static void main(String[] args) {

        X = 8;
        Y = 8;
        int row = 2;
        int column = 4;
        int[][] chessboard = new int[X][Y];

        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        System.out.println(System.currentTimeMillis() - start);
        for (int[] ints : chessboard) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;
        List<Point> next = next(new Point(row, column));
        sort(next);
        while (!next.isEmpty()) {
            Point remove = next.remove(0);
            if (!visited[remove.x * X + remove.y]) {
                traversalChessboard(chessboard, remove.x, remove.y, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    public static List<Point> next(Point point) {
        List<Point> list = new ArrayList<>();

        Point pt = new Point();
        if ((pt.x = point.x - 2) >=0 && (pt.y = point.y - 1) >= 0) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x - 1) >=0 && (pt.y = point.y - 2) >= 0) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x + 2) < X && (pt.y = point.y - 1) >= 0) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x + 1) < X && (pt.y = point.y - 2) >= 0) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x - 2) >=0 && (pt.y = point.y + 1) < Y) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x - 1) >=0 && (pt.y = point.y + 2) < Y) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x + 2) < X && (pt.y = point.y + 1) < Y) {
            list.add(new Point(pt));
        }
        if ((pt.x = point.x + 1) < X && (pt.y = point.y + 2) < Y) {
            list.add(new Point(pt));
        }

        return list;
    }

    public static void sort(List<Point> list) {
        list.sort((o1, o2) -> {
            int count1 = next(o1).size();
            int count2 = next(o2).size();
            return Integer.compare(count1, count2);
        });
    }

}
