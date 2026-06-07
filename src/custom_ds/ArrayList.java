import interfaces.List;

import java.util.Collection;
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

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || < " + size );
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, E element) {
        int n = arrayList.length;
        checkIndex(index);
        if(size == n){
            E[] newArrayList = (E[]) new Object[n * 2];
            System.arraycopy(arrayList, 0, newArrayList, 0, n);
            arrayList = newArrayList;
        }

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
    public void addAll(Collection<E> collection) {
        int newListSize = collection.size();
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
        for(E element : collection){
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

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }
}
