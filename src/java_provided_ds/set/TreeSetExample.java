package set;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Iterator;

/**
 * <p>
 * TreeSet's speciality is that it keeps the unique elements in sorted order
 * automatically, without any manual sorting.
 * Example: search results on an e-commerce site like Amazon.
 * If we type "ca" it can show cake, camera, car, cat etc. in order.
 * </p>
 *
 * 1. add(element)
 * 2. removeIf(condition)
 * 3. remove(element)
 * 4. contains(element)
 * 5. size()
 * 6. isEmpty()
 * 7. toArray()
 * 8. addAll(collection)
 * 9. retainAll(collection)
 * 10. containsAll(collection)
 * 11. iterator()
 * 12. removeAll(collection)
 */
public class TreeSetExample {
    public static void main(String[] args) {
        String[] exListOne = {"ABC#TD", "ADB#FM", "AFB#FM", "ATC#FM"};
        String[] exListTwo = {"ABC#TD", "ADB#FM", "FCD#FM", "CDB#FM", "ADB#FM"};

        // 1. add(element) - duplicates ignored, elements kept in sorted order
        Set<String> uniqueSetEx = new TreeSet<>();
        for (String s : exListOne) {
            uniqueSetEx.add(s.split("#")[0]);
        }
        for (String s : exListTwo) {
            uniqueSetEx.add(s.split("#")[0]);
        }
        System.out.println(uniqueSetEx);

        uniqueSetEx.add("KDS");
        System.out.println(uniqueSetEx);

        // 2. removeIf(condition)
        uniqueSetEx.removeIf(s -> s.equals("ABC"));
        // 3. remove(element)
        uniqueSetEx.remove("CDB");

        // 4. contains(element)
        System.out.println(uniqueSetEx.contains("KDS"));
        // 5. size()
        System.out.println(uniqueSetEx.size());
        // 6. isEmpty()
        System.out.println(uniqueSetEx.isEmpty());

        // 7. toArray()
        String[] arrEx = uniqueSetEx.toArray(new String[0]);
        System.out.println(Arrays.toString(arrEx));

        // 8. addAll(collection)
        List<String> list = new ArrayList<>(Arrays.asList("ACK", "AFK", "ZKD", "ATC"));
        uniqueSetEx.addAll(list);
        System.out.println(uniqueSetEx);

        // 9. retainAll(collection) - keep only items also in list
        uniqueSetEx.retainAll(list);
        System.out.println(uniqueSetEx);

        // 10. containsAll(collection)
        System.out.println(uniqueSetEx.containsAll(list));
        System.out.println(uniqueSetEx);

        // 11. iterator()
        Iterator<String> iterator = uniqueSetEx.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
        }

        // 12. removeAll(collection)
        uniqueSetEx.removeAll(list);
        System.out.println(uniqueSetEx);
    }
}