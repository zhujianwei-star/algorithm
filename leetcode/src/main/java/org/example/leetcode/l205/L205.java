package org.example.leetcode.l205;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第L205题-同构字符串
 * @question: <a href="https://leetcode-cn.com/problems/isomorphic-strings/">...</a>
 * @answer: 将字符串转为01编码，然后比较即可
 */
public class L205 {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int i = 0;
        StringBuilder newSSB = new StringBuilder();
        Map<Character, Integer> sChars = new HashMap<>();
        for (int i1 = 0; i1 < s.length(); i1++) {
            char c = s.charAt(i1);
            Integer i2 = sChars.getOrDefault(c, 0);
            if (i2 > 0) {
                newSSB.append(i2);
            } else {
                i++;
                newSSB.append(i);
                sChars.put(c, i);
            }
        }
        int j = 0;
        Map<Character, Integer> tChars = new HashMap<>();
        StringBuilder newTSB = new StringBuilder();
        for (int j1 = 0; j1 < t.length(); j1++) {
            char c = t.charAt(j1);
            Integer j2 = tChars.getOrDefault(c, 0);
            if (j2 > 0) {
                newTSB.append(j2);
            } else {
                j++;
                newTSB.append(j);
                tChars.put(c, j);
            }
        }
        return newSSB.toString().contentEquals(newTSB);
    }

}
