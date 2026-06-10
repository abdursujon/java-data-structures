import interfaces.Map;

import java.util.Arrays;
import java.util.Objects;

public class HashMap<K, V> implements Map<K, V>{

    private static class Node<K, V>{
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 16 * 0.75 = 12: resize to 32 when size hits 12. Optimal trade-off:
     * 0.5 -> resizes too early, wastes memory (but fewer collisions, fast get)
     * 0.95 -> resizes too late, more collisions, slow get (but saves memory)
     * We don't wait until the bucket is full because that means each bucket can get crowded with many nodes
     * such as table[3] -> [keyA=1] -> [keyB=2] -> [keyC=3] -> null then our get will become O(n) instead of O(1)
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int capacity;
    private float loadFactor;
    private int size;
    // table stores nodes only
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashMap(int capacity, float loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Node<K, V>[]) new Node[capacity];
    }

    public HashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * The hash function is responsible for taking a key and returning a unique index
     * for that key in the array. The hash function returns same index for the same key
     * every time it is called. Here, the length of the key is used as index.
     * hashCode() method provided by default class Object which is inherited by every class in java
     * Example: "cat".hashCode() → 98262 → % 16 → bucket 6
     */
    private int hash(K key){
        return key.hashCode() % capacity;
    }

    /**
     * When size reach to 12, we use resize() in put() to increase the size of the table so buckets are not all full.
     */
    private void resize(){
        int newCapacity = capacity * 2;
        // create a new table with new capacity
        Node<K, V>[] newTable = new Node[newCapacity];

        // store the objects of old table to new table
        for(int i = 0; i < capacity; i++){
            Node<K, V> node = table[i];
            while(node != null){
                Node<K, V> nextNode = node.next;  // save the next node before we rewire node.next
                int index = hash(node.key);
                node.next = newTable[index]; // prepend: point this node at the new bucket's current head
                newTable[index] = node; // make this node the new head of that bucket
                node = nextNode; // move on to the saved next node
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    /**
     * Hash collision can happen when we use the put method and two or more keys are hashed
     * to the same index in the array. This will cause collision if we try to store
     * multiple values at the same index. There are two main technique to handle this:
     * chaining or open addressing. Chaining involves creating a linked list
     * at each index in the storing array. When collision occurs, a new node is added
     * to the linked list. Open addressing involves searching for the next available index
     * in the array until an empty index is found·
     * return: put(key, value) returns the previous value associated with the key (V), or null if
     * there was no mapping (or the key was previously mapped to null).
     */
    @Override
    public V put(K key, V value) {
        int index = hash(key);
        // create a node in the table array of given index
        Node<K, V> node = table[index];

        while(node != null){
            // if given key equals to any key we currently have, overwrite the key value and return the old value
            if(node.key.equals(key)){
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }

        // if no key found this section of the code runs
        Node<K, V> newNode = new Node<>(key, value, null);
        // chaining of nodes all stores in current index
        newNode.next = table[index]; // new node points to the current head
        table[index] = newNode; // new node becomes the new head

        size++;

        // if size > 12 (16 * .75f = 12) resize the table and make the capacity 32
        if(size > capacity * loadFactor){
            resize();
        }
        return null;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        // jump to the bucket index we need instead of going through each index, making the operation o(1)
        int index = hash(key);
        Node<K, V> node = table[index];
        // check if node we are removing is the head of the node objects chained
        Node<K, V> prev = null;

        // walking into the chain of stored object in that index
        while(node != null){
            if(node.key.equals(key)){
                // if our key is head, and means node.prev = null, we need to point next object node.prev = null
                if(prev == null){
                    // make the next object the head of the index
                    table[index] = node.next;
                } else{
                    // if prev not null make the object before the object we remove point to next object since we are removing the next object
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while(node != null){
            if(node.key.equals(key)){
                return true;
            } else{
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(Node<K, V> t : table){
            for(Node<K, V> node = t; node != null; node = node.next){
                if(Objects.equals(node.value, value)){
                    return true;
                }
            }
        }
        return false;
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
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public String toString(){
        if(size == 0) return "{}";
        StringBuilder sb = new StringBuilder("{");
        for(Node<K, V> t: table){
            for(Node<K, V> node = t; node != null; node = node.next){
                sb.append(node.key).append("=").append(node.value).append(", ");
            }
        }
        sb.setLength(sb.length() - 2);
        return sb.append("}").toString();
    }

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<>();
        String[] fruits = {"Orange", "Banana", "Apple", "Melon"};
        int id = 0;
        for(String f: fruits){
            map.put(id, f);
            id++;
        }
        System.out.println(map);
        // Override a key value which returns the old object
        System.out.println(map.put(0, "Grape")); // will set 0 to grape and return old object orange

        System.out.println(map.get(2)); // apple
        System.out.println(map.get(88)); // null since key 88 does not exists

        System.out.println(map.remove(1)); // remove the object banana and return it

        System.out.println(map.containsKey(1)); // true
        System.out.println(map.containsKey(88)); // false

        System.out.println(map.containsValue("Melon")); // true
        System.out.println(map.containsValue("Cherry")); // false

        map.clear();
        System.out.println(map);

    }
}
