package interfaces;

import java.util.Collection;
import java.util.Iterator;

public interface List<E> extends Iterable<E>{
    void add(int index, E element);
    void add(E element); // add at the last index
    void addAll(List<E> list);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    boolean remove(E element);
    void clear();
    boolean contains(E element);
    int indexOf(E element);
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    @Override
    public String toString();
}
