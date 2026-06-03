package list;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. add(element)
 * 2. add(index, element)
 * 3. get(index)
 * 4. getFirst()
 * 5. getLast()
 * 6. set(index, element)
 * 7. remove(index)
 * 8. remove(object)
 * 9. removeFirst()
 * 10. removeLast()
 * 11. size()
 * 12. isEmpty()
 * 13. contains(element)
 * 14. indexOf(element)
 * 15. toArray()
 * 16. subList(from, to)
 * 17. Collections.sort(list)
 * 18. addAll(list)
 * 19. clear()
 */
public class ArrayListExample {

    public static void main(String[] args){
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        int[] nums = {11, 9, 7, 5, 3, 1, 10, 12, 14, 16, 18, 20};
        for(int i = 0; i < nums.length; i++){
            // 1. add(element)
            if(nums[i] % 2 == 0){
                evenList.add(nums[i]);
            }
            if(nums[i] % 2 != 0){
                oddList.add(nums[i]);
            }
        }
        System.out.println(evenList);
        System.out.println(oddList);

        // 2. add(index, element)
        evenList.add(6, 22);
        evenList.add(1, 12);
        System.out.println(evenList);

        // 3. get(index)
        System.out.println(evenList.get(4));

        // 4. getFirst()
        System.out.println(evenList.getFirst());

        // 5. getLast()
        System.out.println(evenList.getLast());

        // 6. set(index, element)
        evenList.set(1, 2);
        System.out.println(evenList);
        System.out.println(evenList.get(1)); // 3. get(index)

        // 7. remove(index)
        evenList.remove(0);
        System.out.println(evenList);

        // 8. remove(object)
        for(int i = evenList.size() - 1; i >=0;  i--){
            int limit = 20;
            if(evenList.get(i) < limit){
                evenList.remove(evenList.get(i));
            }
        }
        System.out.println(evenList);

        // 9. removeFirst()
        evenList.removeFirst();
        // 10. removeLast()
        evenList.removeLast();
        System.out.println(evenList);

        // 11. size()
        System.out.println(oddList.size());

        // 12. isEmpty()
        System.out.println(evenList.isEmpty());
        System.out.println(oddList.isEmpty());

        // 13. contains(element)
        System.out.println(oddList.contains(5));
        System.out.println(oddList.contains(55));

        // 14. indexOf(element)
        System.out.println(oddList.indexOf(5));

        // 15. toArray()
        Integer[] arr = oddList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));

        // 16. subList(from, to)
        System.out.println(oddList.subList(0, 2)); // this excludes the last index (e.g 2 will be ignored)

        // 17. Collections.sort(list)
        Collections.sort(oddList);
        System.out.println(oddList);

        // 18. addAll(list)
        evenList.add(nums[7]);
        oddList.addAll(evenList);
        System.out.println(oddList);

        // 19. clear()
        oddList.clear();
        System.out.println(oddList);
    }
}