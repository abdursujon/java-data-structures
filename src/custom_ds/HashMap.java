import interfaces.Map;

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
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int capacity;
    private float loadFactor;
    private int size;
    private Node<K, V>[] table;

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
     */
    private int hash(K key){
        // 1. how does this works
        return key.hashCode() % capacity;
    }

    private void resize(){
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];
        for(int i = 0; i < capacity; i++){
            Node<K, V> node = table[i];
            while(node != null){
                Node<K, V> next = node.next;
                int index = hash(node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
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
            if(node.key.equals(key)){
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(key, value, null);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
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
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;

        while(node != null){
            if(node.key.equals(key)){
                if(prev == null){
                    table[index] = node.next;
                } else{
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
        return false;
    }

    @Override
    public boolean containsValue(V value) {
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

    }

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map.put(1, "Apple")); // null
        System.out.println(map.put(1, "Mango")); // Apple
    }
}
