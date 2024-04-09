package com.exampel.string;

/**
 * @ClassName : CountAndSay
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/2/24 19:00
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(solution(n));
    }

    private static String solution(int n) {
        StringBuilder builder = new StringBuilder("1");
        StringBuilder res;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            res = builder;
            builder = new StringBuilder();
            count = 0;
            say = res.charAt(0);
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) != say) {
                    builder.append(count).append(say);
                    count = 1;
                    say = res.charAt(j);
                }else {
                    count++;
                }
            }
            builder.append(count).append(say);
        }
        return builder.toString();
    }

}
