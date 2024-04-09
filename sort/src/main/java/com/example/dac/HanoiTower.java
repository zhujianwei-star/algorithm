package com.example.dac;

/**
 * @author ZhuJW
 * @classname HanoiTower
 * @description 汉诺塔模型演示分治算法
 * @date 2022/6/19 19:33
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num < 2) {
            // 当放块只有一个时
            System.out.println("将第" + num + "个方块从" + a + "移动到" + c);
        } else {
            // 将上面n-1个方块从a移动到b
            hanoiTower(num - 1, a, c, b);

            // 移动当前方块到c
            System.out.println("将第" + num + "个方块从" + a + "移动到" + c);

            // 将上面num - 1个方块从b一定到c
            hanoiTower(num - 1, b, a, c);
        }

    }
}
