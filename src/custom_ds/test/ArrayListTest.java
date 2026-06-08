package test;

import custom_ds.ArrayList;

import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(20); // 20 elements with null values
        ArrayList<Integer> noSizeDeclarationList = new ArrayList<>(); // default 10 elements with null values

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
        ArrayList<Integer> listTwo = new ArrayList<>();
        listTwo.add(33);
        listTwo.add(55);
        System.out.println("boolean addAll(Collection<? extends E> c) = " + list.addAll(listTwo));
        System.out.println(list);

        // 4. boolean addAll(int index, Collection<? extends E> c)
        ArrayList<Integer> listThree = new ArrayList<>();
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
        ArrayList<Integer> listFour = new ArrayList<>();
        listFour.add(55);
        listFour.add(44);
        System.out.println("boolean removeAll(Collection<?> c) = " + list.removeAll(listFour));
        System.out.println(list);

        // 10. boolean retainAll(Collection<?> c)
        ArrayList<Integer> listFive = new ArrayList<>();
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
