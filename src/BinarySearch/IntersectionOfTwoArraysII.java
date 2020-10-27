package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int idx = 0;
        int[] result = new int[list.size()];
        for (int n : list) {
            result[idx++] = n;
        }
        return  result;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
