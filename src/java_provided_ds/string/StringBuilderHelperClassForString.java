package string;

/**
 * StringBuilder is a helper class, which helps us manipulate string and character data type
 * The key methods are:
 * 1. new StringBuilder(str) — construct from a starting string
 * 2. append(str) — add to the end
 * 3. insert(index, str) — add at a position
 * 4. charAt(index) — read one character
 * 5. delete(start, end) — remove a range
 * 6. deleteCharAt(index) — remove one character
 * 7. replace(start, end, str) — swap a range for new text
 * 8. length() — number of characters
 * 9. substring(start, end) — copy out a portion as a String
 * 10. indexOf(str) — position of a substring (-1 if absent)
 * 11. ensureCapacity(n) — grow internal buffer to hold at least n chars
 * 12. capacity() — current buffer size (>= length)
 * 13. toString() — convert back to an immutable String
 * 14. reverse() — reverse the characters in place
 */
public class StringBuilderHelperClassForString {

    public static void main(String[] args) {
        // 1. new StringBuilder(str)
        StringBuilder sb = new StringBuilder("I");

        // 2. append(str)
        sb.append(" LOVE COFFEE");
        System.out.println(sb);

        // 3. insert(index, str)
        sb.insert(6, " CAT AND");
        System.out.println(sb);

        // 4. charAt(index)
        System.out.println("Character at index 5 is: " + sb.charAt(5));

        // 5. delete(start, end)
        sb.delete(7, 15);
        System.out.println(sb);

        // 6. deleteCharAt(index)
        sb.deleteCharAt(0);
        System.out.println(sb);

        // 7. replace(start, end, str)
        sb.replace(6, 12, "FOOTBALL");
        System.out.println(sb);

        // 8. length()
        System.out.println("Length of string builder is " + sb.length());

        // 9. substring(start, end)
        System.out.println("Substring of string builder is " + sb.substring(0, 6));

        // 10. indexOf(str)
        System.out.println("Index of FOOTBALL is: " + sb.indexOf("FOOTBALL"));

        // 11. ensureCapacity(n)
        sb.ensureCapacity(200);

        // 12. capacity()
        System.out.println("Capacity of string buffer here is: " + sb.capacity());

        // 13. toString()
        String myHobby = sb.toString();
        System.out.println(myHobby);

        // 14. reverse()
        System.out.println("Reverse of lOVE FOOTBALL :  " + sb.reverse());

        hobby(new String[] {"Football", "Cricket", "Hiking"});
    }

    public static void hobby(String[] hobbyNames) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hobbyNames.length; i++) {
            sb.append(hobbyNames[i]);
            sb.append(" ");
        }

        sb.insert(sb.length(), "Music");

        if (sb.substring(0, 8).equals("Football")) {
            sb.replace(0, 8, "Chess");
        }

        System.out.print(sb + " \n");
    }
}