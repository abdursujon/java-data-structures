package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection is the root interface of the collections hierarchy.
 * It defines the common operations every List/Set/Queue must support:
 * 1. add(element) — add a single item
 * 2. addAll(collection) — add every item from another collection
 * 3. contains(element) — is this item present?
 * 4. containsAll(collection) — are all of these items present?
 * 5. size() — number of elements
 * 6. isEmpty() — true when size is 0
 * 7. iterator() — get an Iterator to walk the elements
 * 8. toArray() — copy elements into an Object[]
 * 9. retainAll(collection) — keep only items also in the given collection
 * 10. remove(element) — remove a single item
 * 11. removeAll(collection) — remove every item found in the given collection
 * 12. clear() — remove all elements
 */
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
