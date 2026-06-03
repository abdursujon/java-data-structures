package map;

import java.util.TreeMap;

/**
 * 1. put(key, value)
 * 2. get(key)
 * 3. getOrDefault(key, default)
 * 4. containsKey(key)
 * 5. remove(key)
 * 6. size()
 * 7. isEmpty()
 * 8. keySet()
 * 9. values()
 * 10. entrySet()
 * 11. forEach((k, v) -> ...)
 * 12. firstKey() / lastKey()
 * 13. ceilingKey(k)
 * 14. floorKey(k)
 * 15. subMap(from, to)
 * 16. merge(key, value, remappingFn)
 * 17. computeIfAbsent(key, mappingFn)
 */
public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> trainSchedule = new TreeMap<>();

        // 1. put(key, value)
        trainSchedule.put(900, "London");
        trainSchedule.put(630, "Manchester");
        trainSchedule.put(1745, "Leeds");
        trainSchedule.put(1215, "Liverpool");
        trainSchedule.put(2030, "York");
        System.out.println(trainSchedule);

        // 2. get(key)
        System.out.println(trainSchedule.get(900));

        // 3. getOrDefault(key, default)
        System.out.println(trainSchedule.getOrDefault(1000, "no train"));

        // 4. containsKey(key)
        System.out.println(trainSchedule.containsKey(900));

        // 5. remove(key)
        trainSchedule.remove(2030);
        System.out.println(trainSchedule);

        // 6. size()
        System.out.println(trainSchedule.size());

        // 7. isEmpty()
        System.out.println(trainSchedule.isEmpty());

        // 8. keySet()
        System.out.println(trainSchedule.keySet());

        // 9. values()
        System.out.println(trainSchedule.values());

        // 10. entrySet()
        System.out.println(trainSchedule.entrySet());

        // 11. forEach((k, v) -> ...)
        trainSchedule.forEach((time, dest) -> System.out.println(time + " -> " + dest));

        // 12. firstKey() / lastKey()
        System.out.println(trainSchedule.firstKey() + " / " + trainSchedule.lastKey());

        // 13. ceilingKey(k)
        System.out.println(trainSchedule.ceilingKey(800));

        // 14. floorKey(k)
        System.out.println(trainSchedule.floorKey(800));

        // 15. subMap(from, to)
        System.out.println(trainSchedule.subMap(630, 1745));

        // 16. merge(key, value, remappingFn)
        trainSchedule.merge(900, " (delayed)", String::concat);
        System.out.println(trainSchedule);

        // 17. computeIfAbsent(key, mappingFn)
        trainSchedule.computeIfAbsent(800, time -> "Glasgow");
        System.out.println(trainSchedule);
    }
}