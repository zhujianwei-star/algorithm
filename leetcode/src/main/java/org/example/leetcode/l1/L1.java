package org.example.leetcode.l1;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第一题，两数之和
 * @question: <a href="https://leetcode-cn.com/problems/two-sum/">...</a>
 * @answer: 这种遇到数组之前某一个元素和当前元素能否形成某个状态时，就需要使用hash的思想。
 *  以数组值为key数组下标为value存储在map集合中，如果「target-数组值」能够获取到数组下标，就说明在map中有可以和当前数组值相加为target的键，那么直接返回map中值和当前数组下标
 *      如果找不到，那么把当前的数组值为键数组下标为值，存储到map中。
 */
public class L1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

}
