package PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int res = minHeap.remove();
        return res;
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
