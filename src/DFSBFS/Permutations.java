package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        generatePermutations(nums, new ArrayList<>(), subsets, visited);
        return subsets;
    }

    private void generatePermutations(int[] nums, List<Integer> current, List<List<Integer>> subsets, boolean[] visited) {
        if (current.size() == nums.length) {
            subsets.add(new ArrayList<>(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            generatePermutations(nums, current, subsets, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
