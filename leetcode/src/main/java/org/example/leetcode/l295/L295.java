package org.example.leetcode.l295;

import java.util.PriorityQueue;

/**
 * @description: 第L295题-数据流的中位数
 * @question: <a href="https://leetcode-cn.com/problems/find-median-from-data-stream/">...</a>
 * @answer: 中位数是指一组数据当中处于中间位置的值。如果数据流中元素的个数为奇数，那么中位数为中间的那个元素；如果数据流中元素的个数为偶数，那么中位数为中间的两个元素的平均值。
 * @TODO：没有解决，待解决
 */
public class L295 {

    public static void main(String[] args) {


        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        System.out.println(finder.findMedian()); // 2.0
        finder.addNum(4);
        System.out.println(finder.findMedian()); // 2.5
        finder.addNum(5);
        System.out.println(finder.findMedian()); // 3.0
    }

    static class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
            queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (queMin.isEmpty() || num <= queMin.peek()) {
                queMin.offer(num);
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.offer(queMin.poll());
                }
            } else {
                queMax.offer(num);
                if (queMax.size() > queMin.size()) {
                    queMin.offer(queMax.poll());
                }
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            }
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }

}
