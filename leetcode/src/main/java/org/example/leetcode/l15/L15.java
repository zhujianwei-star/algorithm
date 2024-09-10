package org.example.leetcode.l15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 第L15题 - 三数之和
 * @question: <a href="https://leetcode-cn.com/problems/3sum/">...</a>
 * @answer:
 */
public class L15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int one = i;
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            for (int i1 = one + 1; i1 < nums.length; i1++) {
                int two = i1;
                if (two > one + 1 && nums[two] == nums[two - 1]) {
                    continue;
                }
                int three = nums.length - 1;
                while (nums[one] + nums[two] + nums[three] > 0 && three > two) {
                    three--;
                }
                if (one != three && two != three && nums[one] + nums[two] + nums[three] == 0) {
                    List<Integer> ints = new ArrayList<>();
                    ints.add(nums[one]);
                    ints.add(nums[two]);
                    ints.add(nums[three]);
                    list.add(ints);
                }
            }
        }
        return list;
    }

}
