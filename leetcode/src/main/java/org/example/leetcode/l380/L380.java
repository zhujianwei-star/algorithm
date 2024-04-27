package org.example.leetcode.l380;

/**
 * @description: 第L380题 - 常数时间插入、删除和获取随机元素
 * @question: <a href="https://leetcode-cn.com/problems/insert-delete-getrandom-o1">...</a>
 * @answer: 变长数组可以在 O(1) 的时间内完成获取随机元素操作，但是由于无法在 O(1) 的时间内判断元素是否存在，因此不能在 O(1)的时间内完成插入和删除操作。
 *  哈希表可以在 O(1) 的时间内完成插入和删除操作，但是由于无法根据下标定位到特定元素，因此不能在 O(1) 的时间内完成获取随机元素操作。
 *  为了满足插入、删除和获取随机元素操作的时间复杂度都是 O(1)，需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。
 */
public class L380 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        randomizedSet.getRandom();
        randomizedSet.remove(0);
        randomizedSet.insert(0);
    }
}
