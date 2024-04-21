package org.example.leetcode.l4;

/**
 * @description: 第L4题，寻找两个正序数组的中位数
 * @question: <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">...</a>
 * @answer: 获取两个正序数组的中位数时，中位数在合并数组中的结果为(totalNums[ (len1 + len2 + 1) / 2 ] + totalNums[ (len1 + len2 + 2) / 2 ] ) / 2
 *  就是合并数组中索引为(len1 + len2 + 1) / 2 与 (len1 + len2 + 2) / 2位置的值相加在 / 2
 *  比如[1, 3] [2] 合并数组为[1, 2, 3] ，然后索引1的位置为(len1 + len2 + 1) / 2 = (2+1+1)/2 = 2，索引2的位置为(len1 + len2 + 1) / 2 = (2+1+2)/2 = 2
 *  最后的结果为(totalNums[ (len1 + len2 + 1) / 2 ] + totalNums[ (len1 + len2 + 2) / 2 ] ) / 2 = (totalNums[2] + totalNums[2]) / 2 = (2 + 2) / 2 = 2
 *  比如[1, 3, 5, 6] [2, 4] 合并数组为[1, 2, 3, 4, 5, 6] ，然后索引1的位置为(len1 + len2 + 1) / 2 = (4+2+1)/2 = 3，索引2的位置为(len1 + len2 + 1) / 2 = (4+2+2)/2 = 4
 *  最后的结果为(totalNums[ (len1 + len2 + 1) / 2 ] + totalNums[ (len1 + len2 + 2) / 2 ] ) / 2 = (totalNums[3] + totalNums[4]) / 2 = (3 + 4) / 2 = 3.5
 *
 * 又因为在实际计算中，如果 k/2 使用int接收的话，如果又小数，就只会去除小数，所以，结果永远都不会大于k/2
 *  根据这个原理可以对两个数组中取k/2的数组，然后中位数肯定不会在更小的k/2中，然后就可以舍弃掉小的这部分的k/2
 */
public class L4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }
}
