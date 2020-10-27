package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(0, candidates, target, new ArrayList<>(), combs);
        return combs;
    }

    private void generateCombinations(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> combs) {
        if (target == 0) {
            combs.add(new ArrayList<>(current));
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            generateCombinations(i, candidates, target - candidates[i], current, combs);
            current.remove(current.size() - 1);
        }
    }
}
