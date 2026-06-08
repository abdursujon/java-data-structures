package interfaces;

public interface List<E> extends Collection<E>{
    boolean add(int index, E element);
    boolean addAll(int index, Collection<? extends E> c);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    int indexOf(E e);
    int lastIndexOf(E e);
}
