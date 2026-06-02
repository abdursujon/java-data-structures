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
 * 15. clear()
 * 16. toArray()
 * 17. subList(from, to)
 * 18. Collections.sort(list)
 * 19. addAll(list)
 */
public class ArrayListDemo {

    public static void main(String[] args){
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        int[] nums = {11, 9, 7, 5, 3, 1, 10, 12, 14, 16, 18, 20};
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                evenList.add(nums[i]);
            }
            if(nums[i] % 2 != 0){
                oddList.add(nums[i]);
            }
        }
        System.out.println(evenList);
        System.out.println(oddList);

        evenList.add(6, 22);
        evenList.add(1, 12);
        System.out.println(evenList);

        System.out.println(evenList.get(4));

        System.out.println(evenList.getFirst());

        System.out.println(evenList.getLast());

        evenList.set(1, 2);
        System.out.println(evenList);
        System.out.println(evenList.get(1));

        // remove index
        evenList.remove(0);
        System.out.println(evenList);

        // remove object
        for(int i = evenList.size() - 1; i >=0;  i--){
            int limit = 20;
            if(evenList.get(i) < limit){
                evenList.remove(evenList.get(i));
            }
        }
        System.out.println(evenList);

        evenList.removeFirst();
        evenList.removeLast();
        System.out.println(evenList);

        System.out.println(oddList.size());

        System.out.println(evenList.isEmpty());
        System.out.println(oddList.isEmpty());

        System.out.println(oddList.contains(5));
        System.out.println(oddList.contains(55));

        System.out.println(oddList.indexOf(5));

        Integer[] arr = oddList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));

        System.out.println(oddList.subList(0, 2)); // this excludes the last index (e.g 2 will be ignored)

        Collections.sort(oddList);
        System.out.println(oddList);

        evenList.add(nums[7]);
        oddList.addAll(evenList);
        System.out.println(oddList);
        oddList.clear();
        System.out.println(oddList);
    }
}
