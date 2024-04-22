package org.example.leetcode.l55;

/**
 * @description: 第L55题 - 跳跃游戏
 * @question: <a href="https://leetcode-cn.com/problems/jump-game/">...</a>
 * @answer: 使用贪心算法
 * 在这个[3, 2, 1, 0, 4]数组中我们一开始在位置 0，可以跳跃的最大长度为 3，因此最远可以到达的位置被更新为 3；
 * 我们遍历到位置 1，由于 1≤3因此位置1可达，加上它可以跳跃的最大长度2得到3，没有超过最远可以到达的位置；
 * 位置2、位置3 同理，最远可以到达的位置不会被更新；
 * 我们遍历到位置 4，由于 4>3，因此位置 4 不可达，我们也就不考虑它可以跳跃的最大长度了。
 * 在遍历完成之后，位置 4 仍然不可达，因此我们返回 False。
 */
public class L55 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
