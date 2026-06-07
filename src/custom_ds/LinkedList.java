import interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Override
    public void add(int index, E element) {
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
    }

    @Override
    public void add(E element) {
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
    }

    @Override
    public void addAll(List<E> list) {
        if (list == null) return;
        for (E element : list) {
            ListNode newNode = new ListNode(element, null);
            if (head == null) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) { // walk to the last node
                    current = current.next;
                }
                current.next = newNode;
            }
        }
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

    @Override
    public E get(int index) {
        checkIndex(index);
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public E set(int index, E givenElement) {
        checkIndex(index);
        ListNode current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        ListNode temp = current;
        E tempValue = temp.element;
        current.element = givenElement;
        return tempValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedObject = null;
        if(index == 0){
            removedObject = head.element;
            head = head.next;
        } else{
            ListNode current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            removedObject = current.next.element;
            current.next = current.next.next;
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
        LinkedList<Integer> list = new LinkedList<>();

        // void add(E element) at rear of the list
        int[] nums = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        for (int n : nums) {
            list.add(n);
        }
        System.out.println("after adding all items LinkedList is: " + list);

        // add(int index, E element);
        list.add(9, 0);
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
        System.out.println("updated list is : " + list);

        // E remove(int index);
        System.out.println("removed element is: " + list.remove(3));
        System.out.println("removed given index element, updated list is " + list);

        // boolean remove(E element);
        System.out.println("removed given element: " + list.remove(Integer.valueOf(45))); // true
        System.out.println("updated list is : " + list);

        // boolean contains(E element);
        System.out.println("contains given element: " + list.contains(9)); // false
        System.out.println("contains given element: " + list.contains(90)); // true

        // int indexOf(E element);
        System.out.println("index of given element is: " + list.indexOf(90));

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
