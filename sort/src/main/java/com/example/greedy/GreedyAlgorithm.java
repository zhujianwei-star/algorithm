package com.example.greedy;

import java.util.*;

/**
 * @author ZhuJW
 * @classname GreedyAlgorithm
 * @description 贪心算法之覆盖率问题
 * @date 2022/6/26 13:25
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        map.put("K1", hashSet1);

        Set<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        map.put("K2", hashSet2);

        Set<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        map.put("K3", hashSet3);

        Set<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        map.put("K4", hashSet4);

        Set<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        map.put("K5", hashSet5);

        Set<String> allSet = new HashSet<>();
        for (Map.Entry<String, Set<String>> stringSetEntry : map.entrySet()) {
            allSet.addAll(stringSetEntry.getValue());
        }

        List <String> result = new ArrayList<>();
        String mapKey = null;
        int num = 0;
        Set<String> areaSet = new HashSet<>();
        while (allSet.size() > 0) {
            mapKey = null;
            for (Map.Entry<String, Set<String>> stringSetEntry : map.entrySet()) {
                areaSet.addAll(allSet);
                areaSet.retainAll(stringSetEntry.getValue());
                if (mapKey == null || (areaSet.size() > num)) {
                    num = areaSet.size();
                    mapKey = stringSetEntry.getKey();
                }
            }
            if (mapKey != null) {
                allSet.removeAll(map.get(mapKey));
                result.add(mapKey);
            }
        }

        System.out.println(result);
    }

}
