package Array;

public class FindCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i <= n; i++) {
            if (!knows(i, candidate)) {
                candidate = i;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (candidate == i) continue;
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }

    public boolean knows(int a, int b) {
        return false;
    }
}