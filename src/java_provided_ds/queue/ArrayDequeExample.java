package queue;

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
public class ArrayDequeExample {

    public static void main(String[] args){

        ArrayDeque<String> deque = new ArrayDeque<>();

        // 1. add(element)
        deque.add("(");
        deque.add(")");
        // 2. addFirst(element)
        deque.addFirst("[");
        // 3. addLast(element)
        deque.addLast("]");
        System.out.println(deque);

        // 4. offer(element)
        deque.offer("(");
        deque.offer(")");
        // 5. offerFirst(element)
        deque.offerFirst("{");
        // 6. offerLast(element)
        deque.offerLast("}");

        // 7. remove()
        deque.remove();
        deque.remove("}");
        System.out.println(deque);
        // 8. removeFirst()
        deque.removeFirst();
        // 9. removeLast()
        deque.removeLast();
        System.out.println(deque);

        // 10. poll()
        System.out.println(deque.poll());
        System.out.println(deque);
        // 11. pollFirst()
        System.out.println(deque.pollFirst());
        // 12. pollLast()
        System.out.println(deque.pollLast());

        deque.addAll(Arrays.asList("(", "{", "}"));
        System.out.println(deque);

        // 13. peek()
        System.out.println(deque.peek());
        // 14. peekFirst()
        System.out.println(deque.peekFirst());
        // 15. peekLast()
        System.out.println(deque.peekLast());

        // 16. contains(element)
        System.out.println(deque.contains("("));
        System.out.println(deque.contains("9"));
        // 17. size()
        System.out.println(deque.size());
        // 18. isEmpty()
        System.out.println(deque.isEmpty());

        // 19. iterator()
        Iterator<String> i = deque.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        // 20. clear()
        deque.clear();
        System.out.println(deque.isEmpty());

        // Test case for matchingBracket method
        System.out.println(matchingBracket("()()()"));
        System.out.println(matchingBracket("(())"));
        System.out.println(matchingBracket("(()"));
        System.out.println(matchingBracket(")("));
    }

    public static boolean matchingBracket(String s) {
        ArrayDeque<Character> ad = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ad.push(c);
            } else if (c == ')') {
                if (ad.isEmpty()) return false;
                ad.pop();
            }
        }
        return ad.isEmpty();

    }
}