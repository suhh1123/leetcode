package Array;

import java.util.*;

public class MajorityElement {
    public int majorityElement1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) + 1 > nums.length / 2) {
                return nums[i];
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        Random rand = new Random();
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        long timeInMills = calendar.getTimeInMillis();;
        rand.setSeed(timeInMills);
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            int count = 0;
            for (int i : nums) {
                if (i == candidate && ++count > nums.length / 2) {
                    return candidate;
                }
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public int majorityElement4(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }

    public int majorityElement5(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        // recurse on left and right halve of this slice
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);
        if (left == right) return left;
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, hi, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count ++;
            }
        }
        return count;
    }
}
