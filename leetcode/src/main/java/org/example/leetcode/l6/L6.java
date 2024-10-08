package org.example.leetcode.l6;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 第L6题-Z字形变换
 * @question: <a href="https://leetcode-cn.com/problems/zigzag-conversion/">...</a>
 * @answer:
 */
public class L6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(result);
    }

    private static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;   // 到达边界改变方向
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
