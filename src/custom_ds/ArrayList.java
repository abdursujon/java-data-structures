import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    protected E[] arrayList;
    protected int size;

    @SuppressWarnings("unchecked")
    ArrayList(int size){
        // create an Object[] and cast to element type
        arrayList = (E[]) new Object[size];
    }

    ArrayList(){
        this(10);
    }

    private void checkIndexForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size );
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size );
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, E element) {
        int n = arrayList.length;
        checkIndexForAdd(index);
        if(size == n){
            E[] newArrayList = (E[]) new Object[n * 2];
            System.arraycopy(arrayList, 0, newArrayList, 0, n);
            arrayList = newArrayList;
        }

        // shifting element from given index to right one position
        for(int i = size - 1; i >= index; i--){
            arrayList[i + 1] = arrayList[i];
        }

        arrayList[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(E element) {
        int n = arrayList.length;
        if(size == n){
            E[] newArrayList = (E[]) new Object[n * 2];
            System.arraycopy(arrayList, 0, newArrayList, 0, n);
            arrayList = newArrayList;
        }
        arrayList[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addAll(List<E> list) {
        int newListSize = list.size();
        int sizeRequired = size + newListSize;
        if(sizeRequired > arrayList.length){
            // check if new capacity can be satisfied by doubling the size,
            // if not we need extra which capacity.
            // Which is size + newListSize (if list we are adding has > 10 items our arrayList.length * 2 won't work)
            int newCapacity = Math.max(arrayList.length * 2, sizeRequired);
            E[] newArrayList = (E[]) new Object[newCapacity];
            System.arraycopy(arrayList, 0, newArrayList, 0, size);
            arrayList = newArrayList;
        }

        // going through each element in the given list and add each of them into the new list
        for(E element : list){
            arrayList[size++] = element;
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return arrayList[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = arrayList[index];
        arrayList[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedElement = arrayList[index];
        for(int i = index + 1; i < size; i++){
            arrayList[i - 1] = arrayList[i];
        }
        arrayList[--size] = null;
        return removedElement;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index == - 1) return false;
        remove(index);
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            arrayList[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        int index = indexOf(element);
        return index != -1;
    }

    @Override
    public int indexOf(E element) {
        if(element == null){
            for(int i = 0; i < size; i++){
                if(arrayList[i] == null) return i;
            }
        } else{
            for(int i = 0; i < size; i++){
                if(element.equals(arrayList[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Cursor that walks the list array from index 0 to size - 1, allowing
     * the list to be used in an enhanced for loop. Returned by iterator().
     * 1. hasNext() - true while there are unvisited elements
     * 2. next() - returns the current element and advances the cursor
     */
    private class ArrayListIterator implements Iterator<E>{
        private int cursor = 0;

        @Override
        public boolean hasNext(){
            return cursor < size;
        }

        @Override
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return arrayList[cursor++];
        }
    }

    /**
     * Returns a new cursor positioned at the start of the list, enabling
     * traversal and use in an enhanced for loop.
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(arrayList, size));
    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(20); // 20 elements with null values
        ArrayList<Integer> noSizeDeclarationList = new ArrayList<>(); // default 10 elements with null values

        // void add(E element) at rear of the list
        int[] nums = {90, 80, 70, 60, 50, 40, 30, 20, 10};
        for(int n: nums){
            list.add(n);
        }
        System.out.println(list);

        // add(int index, E element);
        list.add(9, 0);
        System.out.println(list);

        // addAll(Collection<E> collection);
        ArrayList<Integer> listTwo = new ArrayList<>();
        listTwo.add(19);
        listTwo.add(32);
        list.addAll(listTwo);

        // E get(int index);
        System.out.println(list.get(3));

        // E set(int index, E element);
        System.out.println(list.set(3, 45));

        // E remove(int index);
        System.out.println(list.remove(3));

        // boolean remove(E element);
        System.out.println(list.remove(1)); // true

        // boolean contains(E element);
        System.out.println(list.contains(9)); // false
        System.out.println(list.contains(100)); // true

        // int indexOf(E element);
        System.out.println(list.indexOf(100));

        // int size();
        System.out.println(list.size());

        // boolean isEmpty();
        System.out.println(list.isEmpty());

        // void clear();
        list.clear();
        System.out.println(list); // empty
        System.out.println(list.isEmpty()); // true
    }
}
