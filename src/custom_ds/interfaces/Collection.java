package interfaces;

import java.util.Iterator;

public interface Collection<E> extends Iterable<E> {
   int size();
   boolean isEmpty();
   boolean contains(E e);
   Iterator<E> iterator();
   Object[] toArray();
   boolean add(E e);
   boolean remove(E e);
   boolean containsAll(Collection<?> c);
   boolean addAll(Collection<? extends E> c);
   boolean removeAll(Collection<?> c);
   boolean retainAll(Collection<?>c);
   void clear();
   boolean equals(Object o);
}
