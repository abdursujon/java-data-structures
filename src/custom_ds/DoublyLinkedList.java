import interfaces.List;

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

    protected ListNode head;
    protected ListNode tail;
    protected int size;

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

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        if(index == 0){
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
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            ListNode nextNode = current.next;  // the node currently at index
            ListNode newNode = new ListNode(element, current, nextNode);
            current.next = newNode; // previous node links forward to new node
            nextNode.prev = newNode;  // following node links back to new node
        }
        size++;
    }

    @Override
    public void add(E element) {
        ListNode newNode = new ListNode(element, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void addAll(List<E> list) {
        if (list == null) return;
        for (E element : list) {
            add(element);
        }
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

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // void add(E element) at rear of the list
        int[] nums = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        for (int n : nums) {
            list.add(n);
        }
        System.out.println("after adding all items DoublyLinkedList is: " + list);

        // add(int index, E element);
        list.add(0, 55);
        System.out.println("added extra element then list looks like: " + list);

        // addAll(Collection<E> collection);
        LinkedList<Integer> listTwo = new LinkedList<>();
        listTwo.add(19);
        listTwo.add(32);
        list.addAll(listTwo);
        System.out.println("list two added on list one, now list one is = " + list);

        // E get(int index);
        System.out.println("element of given index: " + list.get(3));

        // E set(int index, E element);
        System.out.println("set new element and removed element is: " + list.set(0, 45));
        System.out.println("updated list after set is : " + list);

        // E remove(int index);
        System.out.println("removed element is: " + list.remove(3));
        System.out.println("removed given index element, updated list is " + list);

        // boolean remove(E element);
        System.out.println("removed given element: " + list.remove(Integer.valueOf(45))); // true
        System.out.println("updated list is : " + list);

        // boolean contains(E element);
        System.out.println("contains given element: " + list.contains(9)); // false
        System.out.println("contains given element: " + list.contains(100)); // true

        // int indexOf(E element);
        System.out.println("index of given element is: " + list.indexOf(90));
        System.out.println("index of given element is: " + list.indexOf(60));

        // int size();
        System.out.println("size of the list is: " + list.size());

        // boolean isEmpty();
        System.out.println("list is empty: " + list.isEmpty());

        // void clear();
        list.clear();
        System.out.println("list is empty after clear: " + list );
        System.out.println("list is empty: " + list.isEmpty()); // true
    }
}
