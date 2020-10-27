package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill(visited, false);
        generatePermutations(nums, new ArrayList<>(), subsets, visited);
        return subsets;
    }

    private void generatePermutations(int[] nums, List<Integer> current, List<List<Integer>> subsets, boolean[] visited) {
        if (current.size() == nums.length) {
            subsets.add(new ArrayList<>(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            if (visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            generatePermutations(nums, current, subsets, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
