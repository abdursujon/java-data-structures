package ds_helper_classes;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Queue;


/**
 * Collections is a utility class of static methods that operate on or return
 * collections (List, Set, Queue). It provides practical operations such as
 * sorting, searching, reversing, shuffling, and creating read-only or fixed
 * views, so we can use these useful methods without writing any manual code.
 *
 * Key useful methods of Collections helper class are:
 * 1. Collections.sort(list)
 * 2. Collections.max(collection)
 * 3. Collections.min(collection)
 * 4. Collections.frequency(collection, element)
 * 5. Collections.binarySearch(list, key)
 * 6. Collections.reverse(list)
 * 7. Collections.sort(list, Collections.reverseOrder())
 * 8. Collections.swap(list, i, j)
 * 9. Collections.rotate(list, distance)
 * 10. Collections.shuffle(list)
 * 11. Collections.addAll(collection, elements...)
 * 12. Collections.disjoint(collection1, collection2)
 * 13. Collections.nCopies(count, element)
 * 14. Collections.fill(list, element)
 * 15. Collections.unmodifiableList(list)
 */
public class CollectionsHelperClass {
    public static void main(String[] args){

        // 1. Collections.sort(list) - sorts the list in ascending (natural) order
        List<Integer> list = new ArrayList<>();
        int n = 30;
        for(int i = n; i>0; i--){
            list.add(i);
        }
        // List before sorted
        System.out.println(list);
        Collections.sort(list);
        // List after sorted
        System.out.println(list);

        // 2. Collections.max(collection) - returns the largest element
        Set<Integer> set = new HashSet<>(List.of(89, 45, 11, 90, 44, 56));
        int maxNum = Collections.max(set);
        System.out.println(maxNum);


        /**
         * 3. Collections.min(collection) - returns the smallest element
         * Collections works on all data structure that implements collection interface. Therefore, Collections works on queue as well.
         * There are three class (ds) that implements queue interface they are LinkedList, ArrayDequeue, PriorityQueue
         * Hence we can apply Collections on all of them.
         */
        Queue<Integer> collectionOnLinkedList = new LinkedList<>(List.of(90, 1, 0, 1, 3, 3, 77, 33, 22, 1, 0));
        Queue<Integer> collectionOnArrayDeque = new ArrayDeque<>(List.of(90, 1, 0, 1, 3, 3, 77, 33, 22, 1, 0));
        Queue<Integer> collectionOnPriorityQueue = new PriorityQueue<>(List.of(90, 1, 0, 1, 3, 3, 77, 33, 22, 1, 0));
        // All output should be 0
        System.out.println(Collections.min(collectionOnLinkedList));
        System.out.println(Collections.min(collectionOnArrayDeque));
        System.out.println(Collections.min(collectionOnPriorityQueue));

        // 4. Collections.frequency(collection, element) - counts how many times element appears
        // Given an array of nums, find the frequency of a target element
        int[] nums0 = {89, 66, 11, 2, 3, 8, 3, 9, 1, 2, 3, 41, 3, 4, 9};
        int target = 3;
        List<Integer> numsList0 = Arrays.stream(nums0).boxed().toList();
        System.out.println(Collections.frequency(numsList0, target));

        // 5. Collections.binarySearch(list, key) - returns index of key (list must be sorted ascending)
        int[] nums1 = {89, 66, 11, 2, 3, 8, 8, 2, 3, 41, 3, 4, 9};
        Arrays.sort(nums1);
        List<Integer> numsList1 = Arrays.stream(nums1).boxed().toList();
        System.out.println(numsList1);
        System.out.println(Collections.binarySearch(numsList1, 3));
        System.out.println(Collections.binarySearch(numsList1, 88)); // negative integer since 88 is not in the list

        // 6. Collections.reverse(list) - reverses the order of elements in place
        List<Integer> numsList2 = new ArrayList<>(List.of(89, 66, 11, 2, 3));
        Collections.reverse(numsList2);
        System.out.println(numsList2);

        // 7. Collections.sort(list, Collections.reverseOrder()) - sorts in descending order
        List<Integer> numsList3 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 89, 100));
        Collections.sort(numsList3, Collections.reverseOrder());
        System.out.println(numsList3);

        // 8. Collections.swap(list, i, j) - swaps the elements at index i and j
        List<Integer> numsList4 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 89, 100));
        Collections.swap(numsList4, 0, numsList4.size() - 1); // swap first element with last
        System.out.println(numsList4);

        // 9. Collections.rotate(list, distance) - shifts elements right by distance, wrapping around
        List<Integer> numsList5 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 100));
        Collections.rotate(numsList5, numsList5.size() / 2); // rotate element by half the size of the list
        System.out.println(numsList5);

        // 10. Collections.shuffle(list) - randomly reorders the elements
        List<Integer> numsList6 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 100));
        Collections.shuffle(numsList6);
        System.out.println(numsList6);

        // 11. Collections.addAll(collection, elements...) - adds the given elements to the collection
        List<Integer> numsList7 = new ArrayList<>();
        Integer n2 = 10;
        for(int i = 0; i < n2; i++){
            Collections.addAll(numsList7, i);
        }
        System.out.println(numsList7);

        // 12. Collections.disjoint(collection1, collection2) - true if they share no elements
        List<Integer> numsList8 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 100));
        List<Integer> numsList9 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 100));
        List<Integer> numsList10 = new ArrayList<>(List.of(1, 33, 19, 67, 5, 13, 71, 101));
        System.out.println(Collections.disjoint(numsList8, numsList9)); // false
        System.out.println(Collections.disjoint(numsList9, numsList10)); // true

        // 13. Collections.nCopies(count, element) - returns an immutable list of element repeated count times with the object passed
        List<Integer> numsList11 = new ArrayList<>();
        int defaultListWithNumberOfItems = 3;
        System.out.println(Collections.nCopies(defaultListWithNumberOfItems, 8));
        // we can create mutable as well
        List<Integer> numsList12 = new ArrayList<>(Collections.nCopies(10, 5));
        // now we can add value
        numsList12.add(6);
        System.out.println(numsList12);

        // 14. Collections.fill(list, element) - replaces every element with the given element
        List<Integer> numsList13 = new ArrayList<>(List.of(2, 3, 11, 66, 4, 12, 70, 100));
        Collections.fill(numsList13, 13);
        System.out.println(numsList13);

        // 15. Collections.unmodifiableList(list) - returns a read-only view of the list
        List<Integer> numsList14 = Collections.unmodifiableList(new ArrayList<>(List.of(13, 55, 90, 22)));
        numsList14.add(12); // returns UnsupportedOperationException
        System.out.println(numsList14);
    }
}
