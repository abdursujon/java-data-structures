import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Iterator;

/**
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
public class HashSets {
    static String[] exListOne = {"ABC#TD", "ADB#FM", "AFB#FM", "ATC#FM"};
    static String[] exListTwo = {"ABC#TD", "ADB#FM", "FCD#FM", "CDB#FM", "ADB#FM"};

    public static List<String> uniqueExperiment() {
        Set<String> uniqueSetEx = new HashSet<>();
        for (String s : exListOne) {
            uniqueSetEx.add(s.split("#")[0]);
        }

        for (String s : exListTwo) {
                uniqueSetEx.add(s.split("#")[0]);
        }
        System.out.println(uniqueSetEx);

        uniqueSetEx.add("KDS");
        System.out.println(uniqueSetEx);

        uniqueSetEx.removeIf(s -> s.equals("ABC"));
        uniqueSetEx.remove("CDB");
        System.out.println(uniqueSetEx.contains("KDS"));
        System.out.println(uniqueSetEx.size());
        System.out.println(uniqueSetEx.isEmpty());

        String[] arrEx = uniqueSetEx.toArray(new String[0]);
        System.out.println(Arrays.toString(arrEx));

        List<String> list = new ArrayList<>(Arrays.asList("ACK", "AFK", "ZKD", "ATC"));
        uniqueSetEx.addAll(list);
        System.out.println(uniqueSetEx);

        uniqueSetEx.retainAll(list);
        System.out.println(uniqueSetEx);

        System.out.println(uniqueSetEx.containsAll(list));
        System.out.println(uniqueSetEx);

        Iterator<String> iterator = uniqueSetEx.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
        }

        uniqueSetEx.removeAll(list);
        System.out.println(uniqueSetEx);

        return new ArrayList<>(uniqueSetEx);
    }

    public static void main(String[] args) {
        System.out.println(uniqueExperiment());
    }
}
