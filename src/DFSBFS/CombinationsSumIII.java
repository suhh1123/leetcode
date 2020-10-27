package DFSBFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combs = new ArrayList<>();
        generateCombinations(1, k, n, new ArrayList<>(), combs);
        return combs;
    }

    private void generateCombinations(int index, int k, int n, List<Integer> current, List<List<Integer>> combs) {
        if (current.size() == k && n == 0) {
            combs.add(new ArrayList<>(current));
        }
        if (n < 0 || current.size() > k) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            current.add(i);
            generateCombinations(i + 1, k, n - i, current, combs);
            current.remove(current.size() - 1);
        }
    }
}
