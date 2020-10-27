package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                generateSubsets(i + 1, nums, current, subsets);
                current.remove(current.size() - 1);
            }
        }
    }
}
