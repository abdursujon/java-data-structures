import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionInterfaceInJava {
    public static void main(String[] args){
        // Collection interface is implemented by list, and list is implemented by arraylist
        // We can instantiate arraylist through collection as it follows substitutioni principle
        Collection<String> collection = new ArrayList<>();

        // 1. add item
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Orange");

        // 2. addAll(collection)
        Collection<String> moreCollection = new ArrayList<>(Arrays.asList("Grape", "Pineapple"));
        collection.addAll(moreCollection);
        System.out.println(collection);

        // 3. contains(element)
        System.out.println(collection.contains("Orange"));

        // 4. containsAll(collection)
        System.out.println(collection.containsAll(moreCollection));

        // 5. size()
        System.out.println(collection.size());

        // 6. isEmpty()
        System.out.println(collection.isEmpty());

        // 7. iterator() - iterates over element
        Iterator it = collection.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // 8. toArray - convert list of collection to array
        Object[] arr = collection.toArray();
        System.out.println(Arrays.toString(arr));

        // 9. retainAll - keep item that only matches given list
        Collection<String> keepOnly = new ArrayList<>(Arrays.asList("Grape", "Orange", "Banana"));
        collection.retainAll(keepOnly);
        System.out.println(collection);

        // 10.  remove(element)
        collection.remove("Orange");
        System.out.println(collection);

        // 11. removeAll(collection)
        moreCollection.add("Biscuit");
        moreCollection.add("Butter");
        collection.addAll(moreCollection);
        System.out.println(collection);
        collection.removeAll(moreCollection);
        System.out.println(collection);

        // 12. clear
        collection.clear();
        System.out.println(collection);

    }
}
