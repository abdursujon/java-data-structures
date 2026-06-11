package interfaces;

public interface Queue<E> {
    boolean isEmpty();
    E peek();
    E remove();
    void put(Object o);
}
