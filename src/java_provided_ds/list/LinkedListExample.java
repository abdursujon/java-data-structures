
package list;

import java.util.LinkedList;
import java.util.Arrays;

/**
 * 1. add(element)
 * 2. add(index, element)
 * 3. addFirst(element)
 * 4. addLast(element)
 * 5. get(index) - iterate
 * 6. getFirst()
 * 7. getLast()
 * 8. set(index, element)
 * 9. remove(index) - iterate backwards
 * 10. removeIf(condition)
 * 11. removeFirst()
 * 12. removeLast()
 * 13. size()
 * 14. isEmpty()
 * 15. contains(element)
 * 16. indexOf(element)
 * 17. toArray()
 * 18. peek() - view first without removing
 * 19. push(element) - stack operation, adds to front
 * 20. pop() - stack operation, removes from front
 * 21. poll() - queue operation, removes from front
 * 22. clear()
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> music = new LinkedList<>();
        String[] musicItems = {
                "cyan glass shards (riogo, Summerhill)",
                "Silverstream (Decoy Octopus, Aran Sheehy)",
                "malopropist (indicator)",
                "I'm God (Clams Casino, Imogen Heap)",
                "Cherry-coloured Funk (Cocteau Twins)"
        };

        // 1. add(element)
        for (String n : musicItems) {
            music.add(n);
        }
        System.out.println(music);

        // 2. add(index, element)
        music.add(1, "Gate 3 (Emptyset)");
        System.out.println(music);

        // 3. addFirst(element)
        music.addFirst("Hollow (Zamilska)");
        System.out.println(music);

        // 4. addLast(element)
        music.addLast("Brujita (Throwing Snow)");
        System.out.println(music);

        // 5. get(index) - iterate
        for (int i = 0; i < music.size(); i++) {
            System.out.println(music.get(i));
        }

        // 6. getFirst()
        System.out.println(music.getFirst());

        // 7. getLast()
        System.out.println(music.getLast());

        // 8. set(index, element)
        for (int i = 0; i < music.size(); i++) {
            if (i == 2 || i == music.size() - 1) {
                if( i == 2){
                    music.set(i, "Without U (Pisca)");
                } if(i == music.size() - 1){
                    music.set(i , "Bitches Brew (Crosses)");
                }
            }
        }
        System.out.println(music);

        // 9. remove(index) - iterate backwards
        for (int i = music.size()- 1; i >= 0; i--) {
            if(i >= 5){
                music.remove(i);
            }
        }
        System.out.println(music);

        // 10. removeIf(condition)
        music.removeIf(n -> n.equals("malopropist (indicator)"));
        System.out.println(music);

        // 11. removeFirst()
        music.removeFirst();

        // 12. removeLast()
        music.removeLast();
        System.out.println(music);

        // 13. size()
        System.out.println(music.size());

        // 14. isEmpty()
        System.out.println(music.isEmpty());

        // 15. contains(element)
        System.out.println(music.contains("cyan glass shards (riogo, Summerhill)"));
        System.out.println(music.contains("I'm God (Clams Casino, Imogen Heap)"));

        // 16. indexOf(element)
        System.out.println(music.indexOf("Without U (Pisca)"));
        System.out.println(music.indexOf("I'm God (Clams Casino, Imogen Heap)"));

        // 17. toArray()
        String[] musicArray = music.toArray(new String[0]);
        System.out.println(Arrays.toString(musicArray));

        // linked list implements deque which again implements both stack and queue

        // 18. peek() - view first without removing
        System.out.println(music.peek());

        // 19. push(element) - stack operation, adds to front
        music.push("Heresy (Nine inch Nails)");

        // 20. pop() - stack operation, removes from front
        music.pop();
        System.out.println(music);

        // 21. poll() - queue operation, removes from front
        System.out.println(music.poll());
        System.out.println(music);

        // 22. clear()
        music.clear();
        System.out.println(music);
    }
}
