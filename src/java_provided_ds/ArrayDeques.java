import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

/**
 * ArrayDeque can work both as queue (FIFO) and stack (LIFO)
 * 1. add(element)
 * 2. addFirst(element)
 * 3. addLast(element)
 * 4. offer(element)
 * 5. offerFirst(element)
 * 6. offerLast(element)
 * 7. remove()
 * 8. removeFirst()
 * 9. removeLast()
 * 10. poll()
 * 11. pollFirst()
 * 12. pollLast()
 * 13. peek()
 * 14. peekFirst()
 * 15. peekLast()
 * 16. contains(element)
 * 17. size()
 * 18. isEmpty()
 * 19. iterator()
 * 20. clear()
 */
public class ArrayDeques{
    public static boolean matchingBracket(String s){
        ArrayDeque<Character> ad = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') {
                ad.push(c);
            } else if (c == ')'){
                if(ad.isEmpty()) return false;
                ad.pop();
            }
        }
        return ad.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(matchingBracket("()()()"));
        System.out.println(matchingBracket("(())"));
        System.out.println(matchingBracket("(()"));
        System.out.println(matchingBracket(")("));

        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.add("(");
        deque.add(")");
        deque.addFirst("[");
        deque.addLast("]");
        System.out.println(deque);

        // difference between add and offer is that if array is full and we try to add more element with offer
        // the program won't fail with exception it will return false instead.
        deque.offer("(");
        deque.offer(")");
        deque.offerFirst("{");
        deque.offerLast("}");

        deque.remove();
        deque.remove("}");
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);

        System.out.println(deque.poll()); // deque operation it removes and returns first element
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());

        deque.addAll(Arrays.asList("(", "{", "}"));
        System.out.println(deque);

        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque.contains("("));
        System.out.println(deque.contains("9"));
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());

        Iterator<String> i = deque.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        deque.clear();
        System.out.println(deque.isEmpty());
    }
}