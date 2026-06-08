package custom_ds;

import interfaces.Collection;
import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 1. add(E e)
 * 2. add(int index, E element)
 * 3. addAll(Collection<? extends E> c)
 * 4. addAll(int index, Collection<? extends E> c)
 * 5. get(int index)
 * 6. set(int index, E element)
 * 7. remove(E e)
 * 8. remove(int index)
 * 9. removeAll(Collection<?> c)
 * 10. retainAll(Collection<?> c)
 * 11. contains(E e)
 * 12. containsAll(Collection<?> c)
 * 13. indexOf(Object o)
 * 14. lastIndexOf(Object o)
 * 15. size()
 * 16. isEmpty()
 * 17. toArray()
 * 18. iterator()
 * 19. equals(Object o)
 * 20. clear()
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

    protected E[] arrayList;
    protected int size;

    @SuppressWarnings("unchecked")
    public ArrayList(int size){
        // create an Object[] and cast to element type
        arrayList = (E[]) new Object[size];
    }

    public ArrayList(){
        this(10);
    }


    private void checkIndexForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size );
        }
    }

    // This one ensure that we check last element of the list
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size );
        }
    }


    // * 1. add(E e)
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(E element) {
        int prevSize = size;
        int n = arrayList.length;
        if(size == n){
            E[] newArrayList = (E[]) new Object[n * 2];
            System.arraycopy(arrayList, 0, newArrayList, 0, n);
            arrayList = newArrayList;
        }
        arrayList[size] = element;
        size++;
        int currentSize = size;
        return currentSize > prevSize;
    }


    // * 2. add(int index, E element)
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(int index, E element) {
        int n = arrayList.length;
        int oldSize = size;
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
        return oldSize < size;
    }


    // * 3. addAll(Collection<? extends E> c)
    // ? - the wildcard, meaning "some unknown type."
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends E> list) { // ? extends E means some type that is E or a subclass of E
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
        return newListSize > 0;
    }


    // * 4. addAll(int index, Collection<? extends E> c)
    @Override
    public boolean addAll(int index, Collection<? extends E> list) {
        checkIndexForAdd(index);
        int newListSize = list.size();
        int sizeRequired = size + newListSize;

        if(sizeRequired > arrayList.length){
            int newCapacity = Math.max(arrayList.length * 2, sizeRequired);
            E[] newArrayList = (E[]) new Object[newCapacity];
            System.arraycopy(arrayList, 0, newArrayList, 0, size);
            arrayList = newArrayList;
        }

        // shift elements from index right by newListSize to open the gap
        for(int i = size - 1; i >= index; i--){
            arrayList[i + newListSize] = arrayList[i];
        }

        int i = index;
        for(E e : list){
            arrayList[i++] = e;
        }
        size  += newListSize;

        return newListSize > 0;
    }


    // * 5. get(int index)
    @Override
    public E get(int index) {
        checkIndex(index);
        return arrayList[index];
    }


    // * 6. set(int index, E element)
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = arrayList[index];
        arrayList[index] = element;
        return oldElement;
    }


    // * 7. remove(E e)
    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index == -1) return false;
        remove(index);
        return true;
    }


    // * 8. remove(int index)
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


    // * 9. boolean removeAll(Collection<?> c)
    @Override
    public boolean removeAll(Collection<?> c){
        boolean removed = false;
        for(Object o: c){
            // remove each match of given object collection from another collection
            while(remove((E) o)){
                removed = true;
            }
        }
        return removed;
    }


    // * 10. retainAll(Collection<?> c)
    @Override
    public boolean retainAll(Collection<?> c){
        boolean retain = false;
        for(int i = size - 1; i >= 0; i--){
            boolean found = false;
            for(Object o : c){
                if (Objects.equals(o, arrayList[i])) {
                    found = true;
                    break;
                }
            }
            if(!found){
                remove(i);
                retain = true;
            }
        }
        return retain;
    }

    // * 11. clear()
    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            arrayList[i] = null;
        }
        size = 0;
    }


    // * 12. contains(E e)
    @Override
    public boolean contains(E element) {
        int index = indexOf(element);
        return index != -1;
    }

    // * 13. containsAll(Collection<?> c)
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o: c){
            if(!contains((E) o)) return false;
        }
        return true;
    }

    // * 14. indexOf(Object o)
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


    // * 15. lastIndexOf(E e)
    @Override
    public int lastIndexOf(E e){
        return -1;
    }


    // * 16. size()
    @Override
    public int size() {
        return size;
    }


    // * 17. isEmpty()
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // * 18. toArray()
    @Override
    public Object[] toArray(){
        return Arrays.copyOf(arrayList, size);
    }


    // * 19. iterator()
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


    // * 20. equals(Object o)
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof ArrayList)) return false;

        ArrayList<?> other = (ArrayList<?>) o;
        if (size != other.size) return false;

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(arrayList[i], other.arrayList[i])) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(arrayList, size));
    }
}
