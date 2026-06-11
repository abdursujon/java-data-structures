import custom_ds.LinkedList;
import interfaces.Set;

import java.util.Arrays;

public class HashSet<E> implements Set<E> {

    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    private Node<E>[] hashTable;
    private int size;

    public HashSet() {
        this.hashTable = new Node[16];
    }

    /**
     * So in 0x7fffffff:
     * - 7 = 0111
     * - each f = 1111
     * - there are 8 hex digits × 4 bits = 32 bits (one full int)
     */
    private int hashKey(E key) {
        return key.hashCode() & 0x7fffffff;
    }

    private int getIndex(E key) {
        return hashKey(key) % hashTable.length;
    }

    private double getLoadFactor() {
        return (double) size / hashTable.length;
    }

    private void resize() {
        int newSize = hashTable.length * 2;
        Node<E>[] newHashTable = new Node[newSize];

        for (Node<E> head : hashTable) {
            while (head != null) {
                Node<E> next = head.next;
                int newIndex = hashKey(head.val) % newSize;
                head.next = newHashTable[newIndex]; // in case of a collision, we insert node at the hea
                newHashTable[newIndex] = head;
                head = next;
            }
        }

        hashTable = newHashTable;
    }

    @Override
    public boolean add(E element) {
        if (getLoadFactor() >= 0.75) {
            resize();
        }

        // check if node already exist in the map if yes do not insert and return true immediately
        if (contains(element)) return true;

        // get element index
        int index = getIndex(element);

        // insert new node at the beginning of bucket at index
        Node newNode = new Node(element);
        newNode.next = hashTable[index];
        // new node also stored in the same index
        hashTable[index] = newNode;
        size++;
        return false;
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        Node<E> curr = hashTable[index];

        if (hashTable[index] == null) return false;

        // element is the head of the chain
        if (curr.val.equals(element)) {
            hashTable[index] = curr.next;
            size--;
        }

        // search the rest of the chain
        while (curr.next != null) {
            if (curr.next.val.equals(element)) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        int index = getIndex(element);
        Node<E> curr = hashTable[index];

        if (hashTable[index] == null) return false;

        // element is the head of the chain
        if (curr.val.equals(element)) {
            return true;
        }

        // search the rest of the chain
        while (curr.next != null) {
            if (curr.next.val.equals(element)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if (a.length < size) {
            // make a new array of the caller's type, sized to fit
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        }
        int i = 0;
        for (Node<E> head : hashTable) {
            for (Node<E> node = head; node != null; node = node.next) {
                a[i++] = (T) node.val;
            }
        }
        return a;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(hashTable, null);
        size = 0;
    }

    @Override
    public String toString() {
        if(size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(HashSet.Node<E> t: hashTable){
            for(HashSet.Node<E> node = t; node != null; node = node.next){
                sb.append(node.val).append(", ");
            }
        }
        sb.setLength(sb.length() - 2);
        return sb.append("]").toString();
    }


    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);


        if(set.contains(5)){
            set.remove(5);
        }
        System.out.println(set);

        Integer[] setToArray = set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(setToArray));

        System.out.println(set.size());

        System.out.println(set.isEmpty());

        set.clear();

        System.out.println(set.isEmpty());
        System.out.println(set);
    }
}
