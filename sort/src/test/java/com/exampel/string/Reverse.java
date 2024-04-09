package com.exampel.string;

/**
 * @ClassName : Reverse
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/2/17 21:25
 */
public class Reverse {

    private static int solution(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0，判断数字是否超过整型
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }
}
