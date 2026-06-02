import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 1. map.put(key, value)            - add entry
 * 2. map.get(key)                   - get value by key
 * 3. map.containsKey(key)           - check if key exists
 * 4. map.containsValue(value)       - check if value exists
 * 5. map.remove(key)                - remove entry by key
 * 6. map.size()                     - number of entries
 * 7. map.isEmpty()                  - check if empty
 * 8. map.keySet()                   - get all keys
 * 9. map.values()                   - get all values
 * 10. map.entrySet()                - get all key-value pairs
 * 11. map.getOrDefault(key, default)- get value or default if key missing
 */
public class HashMaps {

    public Map<String, Map<Integer, String>> universityOfSalfordDegreeDetails() {
        Map<String, Map<Integer, String>> details = new HashMap<>();
        Map<Integer, String> courseMap = new HashMap<>();

        String[] computerScienceYearOne = {
                "Programming 1", "Programming 2", "Linux and Computer System",
                "Database System", "HCI and Web Development", "Professional Development"
        };

        String[] computerScienceYearTwo = {
                "AI and Data Mining", "Data Structure and Algorithm",
                "Client Server System", "Career Development",
                "Networking and Security", "Design Patterns",
                "Software Project with Agile Technique"
        };

        String[] computerScienceYearThree = {
                "Project for Computer Science", "Visual Information Analysis",
                "Software Quality Management", "Mobile Development",
                "Virtual Reality and 3D Games", "Deep Learning",
                "Business Development", "Information Security Management",
                "Deep Learning", "Advanced Web Development"
        };

        String[] allCourse = Stream.of(computerScienceYearOne, computerScienceYearTwo, computerScienceYearThree).flatMap(Arrays::stream).toArray(String[]::new);
        int i = 0;
        Random random = new Random();
        while(i < allCourse.length){
            int randomKey = random.nextInt(23);
            if(!courseMap.containsKey(randomKey)){
                courseMap.put(randomKey, allCourse[i]);
                i++;
            }
        }
        System.out.println("Total Course: " + allCourse.length);
        System.out.println(courseMap);

        details.put("Computer Science", courseMap);
        System.out.println(courseMap.get(0));
        System.out.println(courseMap.containsKey(22));
        System.out.println(courseMap.containsKey(25));
        System.out.println(courseMap.containsValue("Database System"));
        System.out.println(courseMap.containsValue("Maths for Computer Science"));
        courseMap.put(23,"Maths for Computer Science");
        courseMap.remove(23);
        System.out.println(courseMap.size());
        System.out.println(courseMap.isEmpty());
        System.out.println(courseMap.keySet());
        System.out.println(courseMap.values());
        System.out.println(courseMap.entrySet());
        System.out.println(courseMap.getOrDefault(45, "Not found"));
        return details;
    }

    public static void main(String[] args) {
        HashMaps map = new HashMaps();
        System.out.println(map.universityOfSalfordDegreeDetails());
    }
}
