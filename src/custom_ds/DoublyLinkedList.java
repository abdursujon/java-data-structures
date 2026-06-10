package custom_ds;

import interfaces.Collection;
import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E> {

    private class ListNode {
        ListNode next;
        ListNode prev;
        E element;

        ListNode(E element, ListNode prev, ListNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        ListNode() {}
    }

    // head node initially null
    protected ListNode head;
    // tail node initially null and both head and tail points to same object
    protected ListNode tail;
    protected int size;

    // When adding an item with index, we check if the index is less than 0 or more then the size
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size);
        }
    }

    // This one ensure that we check last element of the list with index being 0 and less or equal to size
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 " + " || <= " + size);
        }
    }


    /**
     * First check if index is 0, if so we need to enter the new element in head.
     * We create a node with previous null (since it is head) and head node(which itself has prev, next and element value)
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean add(int index, E element) {
        checkIndexForAdd(index);
        if(index == 0){
            // create new node with it's data, prev node and next node(head)
            ListNode newNode = new ListNode(element, null, head);
            if(head != null){
                // old head now points back to new node
                head.prev = newNode;
            } else {
                // since list was empty tail also point to the same element
                tail = newNode;
            }
            head = newNode;
        } else if(index == size){
            // end: new node's prev is old tail, next is null
            ListNode newNode = new ListNode(element, tail, null);
            tail.next = newNode;  // old tail links forward to new node
            tail = newNode; // new node becomes the tail
        } else {
            ListNode current = head;
            // stop one position before the index we are given so we can add the node in that position
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            ListNode nextNode = current.next;  // the node currently at index
            ListNode newNode = new ListNode(element, current, nextNode);
            current.next = newNode; // previous node links forward to new node
            nextNode.prev = newNode;  // following node links back to new node
        }
        size++;
        return false;
    }


    @Override
    public boolean add(E element) {
        ListNode newNode = new ListNode(element, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> list) {
        if (list == null) return false;
        for (E element : list) {
            add(element);
        }
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        ListNode current = head;
        if(index < size / 2){
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        } else{
            current = tail;
            for(int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current.element;
    }

    @Override
    public E set(int index, E givenElement) {
        checkIndex(index);
        ListNode current;
        if(index < size / 2){
            current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        } else{
            current = tail;
            for(int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }

        E oldValue = current.element;
        current.element = givenElement;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        ListNode current = head;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }

        E removedObject = current.element;

        ListNode prevNode = current.prev;
        ListNode nextNode = current.next;

        if(prevNode != null){
            prevNode.next = nextNode;
        } else{
            head = nextNode;
        }

        if(nextNode != null){
            nextNode.prev = prevNode;
        } else{
            tail = prevNode;
        }
        size--;
        return removedObject;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        int index = indexOf(element);
        return index != -1;
    }

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

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private class DoublyLinkedListIterator implements Iterator<E> {
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
        return new DoublyLinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
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

    public static void main(String[] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // 1. boolean add(E e)
        int[] nums = {1, 33, 454, 2, 22, 4, 32, 24, 2};
        for(int n: nums){
            list.add(n);
        }
        System.out.println(list);

        // 2. void add(int index, E element)
        System.out.println("void add(int index, E element) = " + list.add(1, 44));
        System.out.println(list);

        // 3. boolean addAll(Collection<? extends E> c)
        DoublyLinkedList<Integer> listTwo = new DoublyLinkedList<>();
        listTwo.add(33);
        listTwo.add(55);
        System.out.println("boolean addAll(Collection<? extends E> c) = " + list.addAll(listTwo));
        System.out.println(list);

        // 4. boolean addAll(int index, Collection<? extends E> c)
        DoublyLinkedList<Integer> listThree = new DoublyLinkedList<>();
        listThree.add(99);
        listThree.add(89);
        System.out.println("boolean addAll(int index, Collection<? extends E> c) = " + list.addAll(2, listThree));
        System.out.println(list);

        // 5. E get(int index)
        System.out.println("E get(int index) = " + list.get(1));

        // 6. E set(int index, E element)
        System.out.println("E set(int index, E element) = " + list.set(2, 77));
        System.out.println(list);

        // 7. boolean remove(E e)
        System.out.println("boolean remove(E e) = " + list.remove(Integer.valueOf(77)));

        // 8. E remove(int index)
        System.out.println("E remove(int index) = " + list.remove(2));

        // 9. boolean removeAll(Collection<?> c)
        System.out.println(list);
        DoublyLinkedList<Integer> listFour = new DoublyLinkedList<>();
        listFour.add(55);
        listFour.add(44);
        System.out.println("boolean removeAll(Collection<?> c) = " + list.removeAll(listFour));
        System.out.println(list);

        // 10. boolean retainAll(Collection<?> c)
        DoublyLinkedList<Integer> listFive = new DoublyLinkedList<>();
        listFive.add(33);
        listFive.add(2);
        System.out.println("boolean retainAll(Collection<?> c) = " + list.retainAll(listFive));
        System.out.println(list);


        // 11. boolean contains(E e)
        System.out.println("contains: " +list.contains(2));

        // 12. boolean containsAll(Collection<?> c)
        System.out.println("containsAll: " + list.containsAll(listFive));

        // 13. int indexOf(Object o)
        System.out.println("index of: " + list.indexOf(3));

        // 14. int lastIndexOf(Object o)
        System.out.println("lastIndexOf: " + list.lastIndexOf(2));

        // 15. int size()
        System.out.println("list size: " + list.size());

        // 16. boolean isEmpty()
        System.out.println("list is empty = " + list.isEmpty());

        // 17. Object[] toArray()
        System.out.println(Arrays.toString(list.toArray()));

        // 19. boolean equals(Object o)
        System.out.println("list one equals list two = " + list.equals(listFive));

        // 20. void clear()
        list.clear();
        System.out.println("list after clear " + list);
    }
}
