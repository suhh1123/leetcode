package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        } else if  (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        } else {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int low = Math.max(0, left - k);
            int high = Math.min(arr.length - 1, left + k);
            while (high - low + 1 > k) {
                if (low < 0 || (x - arr[low]) <= (arr[high] - x)) {
                    high --;
                } else if (high > arr.length - 1 || (x - arr[low]) >= (arr[high] - x)) {
                    low ++;
                }
            }
            for (int i = low; i <= high; i++) {
                result.add(arr[i]);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        FindKClosestElements f = new FindKClosestElements();
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        List<Integer> result = f.findClosestElements(arr, 3, 5);
        System.out.print(result);
    }
}
