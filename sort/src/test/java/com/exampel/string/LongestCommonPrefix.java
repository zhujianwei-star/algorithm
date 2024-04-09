package com.exampel.string;

/**
 * @ClassName : LongestCommonPrefix
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * @Author : Zhujw
 * @CreateDate : 2022/2/25 15:43
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] str = {"flower","flow","flight"};
        String[] str = {"flow","flower","flight"};
//        System.out.println(solution(str));
        System.out.println(officialSolution(str));
    }

    private static String solution(String[] strs) {
        String res = null;
        StringBuilder builder = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            res = builder.toString();
            builder = new StringBuilder();
            for (int j = 0; j < res.length() && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    break;
                } else {
                    builder.append(res.charAt(j));
                }
            }
        }
        return builder.toString();
    }

    private static String officialSolution (String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        //默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //不断的截取
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}
