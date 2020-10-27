package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums1) set.add(n);

        HashSet<Integer> intersection = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                intersection.add(n);
            }
        }

        int[] result = new int[intersection.size()];
        int idx = 0;
        for (int n : intersection) {
            result[idx++] = n;
        }
        return result;
    }
}
