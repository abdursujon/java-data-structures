import java.time.LocalDate;
import java.util.*;

/**
 * PriorityQueue - min-heap by default (smallest element at the head)
 * 1.  add(element)
 * 2.  offer(element)
 * 3.  peek()
 * 4.  element()
 * 5.  contains(element)
 * 6.  size()
 * 7.  isEmpty()
 * 8.  iterator()
 * 9.  toArray()
 * 10. addAll(collection)
 * 11. remove(element)
 * 12. remove()
 * 13. poll()
 * 14. clear()
 */
public class PriorityQueues {
    static Map<Integer, List<String>> conditionMap = new HashMap<>();

    static {
        conditionMap.put(1, new ArrayList<>(Arrays.asList("broken arm", "heart attack", "stroke", "cancer", "severe bleeding")));
        conditionMap.put(2, new ArrayList<>(Arrays.asList("allergic reaction", "severe mental disorder")));
        conditionMap.put(3, new ArrayList<>(Arrays.asList("severe tooth pain", "severe stomach pain")));
        conditionMap.put(4, new ArrayList<>(Arrays.asList("typhoid", "pneumonia")));
        conditionMap.put(5, new ArrayList<>(Arrays.asList("fever", "headache")));
    }

    static int getUrgencyLevel(String condition) {
        for (Map.Entry<Integer, List<String>> entry : conditionMap.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equalsIgnoreCase(condition)) {
                    return entry.getKey();
                }
            }
        }
        return 5;
    }

    static class Patient {
        String name;
        LocalDate dob;
        String condition;
        int urgencyLevel;

        Patient(String name, LocalDate dob, String condition) {
            this.name = name;
            this.dob = dob;
            this.condition = condition;
            this.urgencyLevel = getUrgencyLevel(condition);
        }

        public String toString() {
            return "\nPatient Name: " + name + " \n" +
                    "DOB: " + dob + "\n" +
                    "Urgency Level: " + urgencyLevel + "\n" +
                    "Condition details: " + condition +  "\n" +
                    "====================================";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> nextUrgentPatient = new PriorityQueue<>(Comparator.comparingInt(p -> p.urgencyLevel));

        // 1. add
        nextUrgentPatient.add(new Patient("Sujon", LocalDate.of(1988, 10, 10), "fever"));
        nextUrgentPatient.add(new Patient("Maria", LocalDate.of(1985, 3, 22), "heart attack"));
        nextUrgentPatient.add(new Patient("James", LocalDate.of(2001, 7, 14), "typhoid"));
        nextUrgentPatient.add(new Patient("Ayesha", LocalDate.of(1990, 1, 5), "allergic reaction"));


        // 2. offer(element)
        Patient rakib = new Patient("Rakib", LocalDate.of(1998, 6, 6), "stomach ach");
        boolean offerNewPatient = nextUrgentPatient.offer(rakib);
        System.out.println("Patient " + rakib.name + " accepted (true / false) -> " + offerNewPatient);

        // 3. peek() - return the top priority item
        System.out.println(nextUrgentPatient.peek());

        // 4. element() - returns the top priority item as well
        System.out.println(nextUrgentPatient.element());

        // 5. contains(element)
        System.out.println("Contains the object rakib: " + nextUrgentPatient.contains(rakib));

        // 6. size
        System.out.println("Number of patient waiting: " + nextUrgentPatient.size());

        // 7. isEmpty();
        System.out.println("Is the patient waiting list zero? : " + nextUrgentPatient.isEmpty());


        // 8. iterator over the patient list
        Iterator<Patient> patients = nextUrgentPatient.iterator();
        while (patients.hasNext()) {
            System.out.println(patients.next());
        }

        // 9. toArray()
        Patient[] pt = nextUrgentPatient.toArray(new Patient[0]);
        for (Patient p : pt) {
            System.out.println(p);
        }

        // 10. addAll
        nextUrgentPatient.addAll(Arrays.asList(
            new Patient("Mike", LocalDate.of(1995, 4, 12), "stroke"),
            new Patient("Sara", LocalDate.of(2000, 8, 3), "headache")
        ));
        System.out.println("PRINTING VALUE AFTER ADD ALL");
        System.out.println(nextUrgentPatient);
        System.out.println("ADD ALL END ADD ALL END ");

        // 11. remove(element) returns true of false
        System.out.println(nextUrgentPatient.remove(rakib));

        // 12. remove() removes the priority object and returns it
        System.out.println("Removed Item: " + nextUrgentPatient.remove());

        // 13. poll() remove and peek first priority item
        while (!nextUrgentPatient.isEmpty()) {
            System.out.println(nextUrgentPatient.poll());
        }

    }
}