package DFSBFS;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        generateCombinations(1, n, k, new ArrayList<>(), combs);
        return combs;
    }

    private void generateCombinations(int index, int n, int k, List<Integer> current, List<List<Integer>> combs) {
        if (current.size() > k) return;
        if (current.size() == k) {
            combs.add(new ArrayList<>(current));
        }
        for (int i = index; i <= n; i++) {
            current.add(i);
            generateCombinations(i + 1, n, k, current, combs);
            current.remove(current.size() - 1);
        }
    }
}
