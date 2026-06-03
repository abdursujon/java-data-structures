package arrays;

import java.util.Arrays;

/**
 * 1. Create array with new, fill using a loop
 * 2. Iterate array and compute per-element values to change array index values
 * 3. Array literal initialization and .length
 * 4. System.arraycopy(src, srcPosition, dest, destPosition, length)
 * 5. Arrays.copyOf(array, newLength) to resize
 */
public class OneDimensionalArray {
    public static void main(String[] args){

        // 1. Create array with new, fill using a loop
        int[] nums0 = new int[10];
        for(int i = 0; i < nums0.length; i++){
            nums0[i] = i;
        }
        System.out.println(Arrays.toString(nums0));

        // 2. Iterate array and compute per-element values to change array index values
        int[] nums1 = {1, 3, 5, 7, 9};
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = nums1[i] + 1;
        }
        System.out.println(Arrays.toString(nums1));

        // 3. Array literal initialization and .length
        int[] nums2 = new int[] {1, 3, 5, 7, 9};
        System.out.println("Array content: " + Arrays.toString(nums2) + "\nLength: " + nums2.length);

        // 4. System.arraycopy(src, srcPosition, dest, destPosition, length (how many items we want to copy)
        int[] nums3 = new int[nums2.length];
        System.arraycopy(nums2, 0, nums3, 0, nums2.length);
        System.out.println(Arrays.toString(nums3));

        // 5. Arrays.copyOf(array, newLength) to resize
        int[] nums4 = Arrays.copyOf(nums3, 10);
        System.out.println(Arrays.toString(nums4));
    }
}