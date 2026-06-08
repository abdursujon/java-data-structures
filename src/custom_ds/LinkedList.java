package custom_ds;

import interfaces.Collection;
import interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
 * 11. clear()
 * 12. contains(E e)
 * 13. containsAll(Collection<?> c)
 * 14. indexOf(Object o)
 * 15. lastIndexOf(Object o)
 * 16. size()
 * 17. isEmpty()
 * 18. toArray()
 * 19. iterator()
 * 20. equals(Object o)
 * @param <E>
 */
public class LinkedList<E> implements List<E> {

    private class ListNode {
        ListNode next;
        E element;

        ListNode(E element, ListNode next) {
            this.element = element;
            this.next = next;
        }

        ListNode() {
        }
    }

    protected ListNode head;
    protected int size;

    public LinkedList() {
        head = null;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size);
        }
    }

    // This one ensure that we check last element of the list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size);
        }
    }


    // * 1. add(E e)
    @Override
    public boolean add(E element) {
        if (size == 0) {
            head = new ListNode(element, head);
        } else {
            ListNode current = head;
            for (int i = 0; i < size - 1; i++) {
                current = current.next;
            }
            current.next = new ListNode(element, current.next);
        }
        size++;
        return true;
    }


    // * 2. add(int index, E element)
    @Override
    public boolean add(int index, E element) {
        checkIndexForAdd(index);
        if (index == 0) {
            // inserting at the front: new node becomes head and points to the old head
            head = new ListNode(element, head);
        } else {
            // inserting in the middle: walk to the node just before index (index - 1),
            // then link the new node between it and its current next
            ListNode current = head;
            // loops stops one position before the index we give
            // now we can point that index object to the element we want to add
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // add the new element and point it to the next object
            current.next = new ListNode(element, current.next);
        }
        size++;
        return false;
    }


    // * 3. addAll(Collection<? extends E> c)
    @Override
    public boolean addAll(Collection<? extends E> list) {
        if (list == null) return false;
        int newListSize = list.size();
        for (E element : list) {
            add(element);
        }
        return newListSize > 0;
    }


    // * 4. addAll(int index, Collection<? extends E> c)
    @Override
    public boolean addAll(int index, Collection<? extends E> list) {
        checkIndexForAdd(index);
        int newListSize = list.size();
        int i = index;
        for (E element : list) {
            add(i++, element);
        }
        return newListSize > 0;
    }


    /**
     * A linked list has no O(1) index access, so the lookup walks from the head
     * one node at a time, following next until the node at the given index is
     * reached, then returns its element. Example: for index = 3, the loop steps
     * 3 times (positions 1, 2, 3) and returns the element at node 3.
     *
     * @param index position of the element to retrieve
     * @return the element stored at the given index
     */
    // * 5. get(int index)
    @Override
    public E get(int index) {
        checkIndex(index);
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }


    // * 6. set(int index, E element)
    @Override
    public E set(int index, E givenElement) {
        checkIndex(index);
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        ListNode temp = current;
        E tempValue = temp.element;
        current.element = givenElement;
        return tempValue;
    }


    // * 7. remove(E e)
    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index == -1) return false;
        remove(index);
        return true;
    }


    // * 8. remove(int index)
    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedObject = null;
        if (index == 0) {
            removedObject = head.element;
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedObject = current.next.element;
            current.next = current.next.next;
        }
        size--;
        return removedObject;
    }


    // * 9. removeAll(Collection<?> c)
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }


    // * 10. retainAll(Collection<?> c)
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    // * 11. clear()
    @Override
    public void clear() {
        head = null;
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
        return false;
    }


    // * 14. indexOf(Object o)
    @Override
    public int indexOf(E givenElement) {
        //search for the element
        ListNode current = head;
        int index = 0;
        while (current != null && !current.element.equals(givenElement)) {
            current = current.next;//move to the next node
            index++;
        }
        if (current == null)// head is empty
            return -1;
        else
            return index;
    }


    // * 15. lastIndexOf(Object o)
    @Override
    public int lastIndexOf(E e) {
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
    public Object[] toArray() {
        return new Object[]{};
    }


    // * 19. iterator()
    private class LinkedListIterator implements Iterator<E> {
        private ListNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E val = current.element;
            current = current.next;
            return val;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }


    // * 20. equals(Object o)
    @Override
    public boolean equals(Object o) {
        return false;
    }


    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
