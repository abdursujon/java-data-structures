package interfaces;

public interface Set<E>{
    boolean add(E element);
    boolean remove(E element);
    boolean contains(E element);
    <T> T[] toArray(T[] a);
    int size();
    boolean isEmpty();
    void clear();
}
