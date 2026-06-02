import java.util.LinkedList;
import java.util.Arrays;
/**
 1. add(element)
 2. add(index, element)
 3. addFirst(element)
 4. addLast(element)
 5. get(index) - iterate
 6. getFirst()
 7. getLast()
 8. set(index, element)
 9. remove(index) - iterate backwards
 10. removeIf(condition)
 11. removeFirst()
 12. removeLast()
 13. size()
 14. isEmpty()
 15. contains(element)
 16. indexOf(element)
 17. toArray()
 18. peek() - view first without removing
 19. push(element) - stack operation, adds to front
 20. pop() - stack operation, removes from front
 21. poll() - queue operation, removes from front
 22. clear()
 */
public class LinkedLists {
    public static void musicList() {
        LinkedList<String> music = new LinkedList<>();
        String[] musicItems = {
                "cyan glass shards (riogo, Summerhill)",
                "Silverstream (Decoy Octopus, Aran Sheehy)",
                "malopropist (indicator)",
                "I'm God (Clams Casino, Imogen Heap)",
                "Cherry-coloured Funk (Cocteau Twins)"
        };

        for (String n : musicItems) {
            music.add(n);
        }
        System.out.println(music);

        music.add(1, "Gate 3 (Emptyset)");
        System.out.println(music);

        music.addFirst("Hollow (Zamilska)");
        System.out.println(music);

        music.addLast("Brujita (Throwing Snow)");
        System.out.println(music);

        for (int i = 0; i < music.size(); i++) {
            System.out.println(music.get(i));
        }

        System.out.println(music.getFirst());
        System.out.println(music.getLast());

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

        for (int i = music.size()- 1; i >= 0; i--) {
            if(i >= 5){
                music.remove(i);
            }
        }
        System.out.println(music);

        music.removeIf(n -> n.equals("malopropist (indicator)"));
        System.out.println(music);

        music.removeFirst();
        music.removeLast();
        System.out.println(music);

        System.out.println(music.size());
        System.out.println(music.isEmpty());
        System.out.println(music.contains("cyan glass shards (riogo, Summerhill)"));
        System.out.println(music.contains("I'm God (Clams Casino, Imogen Heap)"));
        System.out.println(music.indexOf("Without U (Pisca)"));
        System.out.println(music.indexOf("I'm God (Clams Casino, Imogen Heap)"));

        String[] musicArray = music.toArray(new String[0]);
        System.out.println(Arrays.toString(musicArray));

        // linked list implements deque which again implements both stack and queue
        System.out.println(music.peek());
        music.push("Heresy (Nine inch Nails)");
        music.pop();
        System.out.println(music);

        System.out.println(music.poll()); // queue operation
        System.out.println(music);

        music.clear();
        System.out.println(music);
    }

    public static void main(String[] args) {
        musicList();
    }
}
