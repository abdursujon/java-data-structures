import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap is identical to HashMap except the keys are automatically sorted.
 * TreeMap has all the methods that HashSet has, but it does on additional thing which is sorting the keys automatically
 * The trade of is TreeMap is slowest of all map, it does insertion, searching and deleting in O(log n)
 */
public class TreeMaps{
    public static void main(String[] args){
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(6, "Apple");
        treeMap.put(99, "Banana");
        treeMap.put(1, "Mango");
        System.out.println(treeMap);
    }
}