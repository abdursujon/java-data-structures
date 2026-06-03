package arrays;

import java.util.Arrays;

/**
 * 1. Arrays.sort(array)
 * 2. Arrays.toString(array)
 * 3. Arrays.deepToString(array)
 * 4. Arrays.equals(arr1, arr2)
 * 5. Arrays.fill(array, value)
 * 6. Arrays.copyOf(array, length)
 * 7. Arrays.copyOfRange(array, from, to)
 * 8. Arrays.binarySearch(array, key)
 * 9. Arrays.stream(array)
 */
public class JavaArrayHelperClass {
    public static void main(String[] args){

        // 1. Arrays.sort(array)
        // 2. Arrays.toString(array)
        int[] nums0 = {1, 3, 4, 65, 33, 12};
        Arrays.sort(nums0);
        System.out.println(Arrays.toString(nums0));

        // 3. Arrays.deepToString(array)
        int[][] nums1 = {{1, 3, 7, 9}, {1, 3, 5, 6}};
        System.out.println(Arrays.deepToString(nums1));


        // 4. Arrays.equals(arr1, arr2)
        int[] nums2 = {1, 3, 4, 67, 33, 12};
        int[] nums3 = {1, 3, 4, 65, 33, 12};
        System.out.println(Arrays.equals(nums2, nums3));

        // 5. Arrays.fill(array, value)
        int[] nums4 = new int[5];
        Arrays.fill(nums4, 7);
        System.out.println(Arrays.toString(nums4));

        // 6. Arrays.copyOf(array, length) copy existing array to new array
        int[] nums5 = {5, 6, 90, 11, 4};
        int[] nums6 = Arrays.copyOf(nums5, 3);
        System.out.println(Arrays.toString(nums6));

        // 7. Arrays.copyOfRange(array, from, to)
        int[] nums7 = { 1, 4, 5, 90, 4};
        int[] nums8 = Arrays.copyOfRange(nums7, 2, 6);
        System.out.println(Arrays.toString(nums8));

        // 8. Arrays.binarySearch(array, key)
        int[] nums9 = {1, 4, 66, 22, 8882, 4};
        System.out.println(Arrays.binarySearch(nums9, 3));
        System.out.println(Arrays.binarySearch(nums9, 4));

        // 9. Arrays.stream(array)
        int[] nums10 = {1, 44, 292, 44, 55};
        int total = Arrays.stream(nums10).sum();
        int maxNum = Arrays.stream(nums10).max().getAsInt();
        int minNum = Arrays.stream(nums10).min().getAsInt();
        System.out.println("Total: " + total + "\nMax: " + maxNum + "\nMin: " + minNum);

    }
}