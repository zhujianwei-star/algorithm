package org.example.leetcode.l380;

import java.util.*;

/**
 * @description: 第RandomizedSet题
 * @question: <a href="">...</a>
 * @answer:
 */
public class RandomizedSet {

    public List<Integer> list;

    public Map<Integer, Integer> map;

    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        int index = list.size() - 1;
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer remove = map.get(val);
        Integer last = list.get(list.size() - 1);
        list.set(remove, last);
        list.remove(list.size() - 1);
        map.put(last, remove);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }

}
