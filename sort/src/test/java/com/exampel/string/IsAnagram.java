package com.exampel.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName : IsAnagram
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/2/18 17:29
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "aaa", t = "aaabb";
        System.out.println(solution(s, t));

    }

    private static boolean solution(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
        }
        for (int i = 0; i < tChars.length; i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Character character : sMap.keySet()) {
            if (!Objects.equals(sMap.get(character), tMap.get(character))) {
                return false;
            }
        }
        return true;
    }
}
