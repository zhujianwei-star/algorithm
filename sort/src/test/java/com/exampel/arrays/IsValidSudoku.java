package com.exampel.arrays;

/**
 * @ClassName : IsValidSudoku
 * @Description: 非法的数独，合法的数独返回true，非法的返回false
 * @Author : Zhujw
 * @CreateDate : 2022/2/16 9:24
 */
public class IsValidSudoku {

    public static void main(String[] args) {

    }

    /**
     * 自己解不出来，直接看的官方的
     * 定义三个数组，第一个用来存储每一行，和每一个数组出现的个数。第二个用来存储每一列，和每一个数组出现的个数。
     * 第三个用来存储每一个九宫格（行和列/3，取商，就可以获得每一个九宫格的下标），和每一个数组出现的个数。
     * 如果出现这个数据，就直接将数组中的元素加1
     * 如果这三个数组中有大于1的数，就表示这个数组中有数据出现两次，就直接返回false
     * @param board
     * @return
     */
    private static boolean solution(char[][] board) {
        int length = board.length;
        int[][] rowNums = new int[length][length];
        int[][] colNums = new int[length][length];
        int[][][] cell = new int[length][length][length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                rowNums[i][num]++;
                colNums[j][num]++;
                cell[i / 3][j / 3][num]++;
                if (rowNums[i][num] > 1 || colNums[j][num] > 1 || cell[i / 3][j / 3][num] > 1)
                    return false;
            }
        }
        return true;
    }

}
