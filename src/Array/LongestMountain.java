package Array;

public class LongestMountain {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) return 0;
        int start = 0;
        int max = 0;
        int n = A.length;
        while (start < n) {
            int end = start;
            if (end + 1 < n && A[end] < A[end + 1]) {
                while (end + 1 < n && A[end] < A[end + 1]) {
                    end ++;
                }
                if (end + 1 < n && A[end] > A[end + 1]) {
                    while (end + 1 < n && A[end] > A[end + 1]) {
                        end ++;
                    }
                }
            }
            max = Math.max(max, end - start + 1);
            start = Math.max(start + 1, end);
        }
        return max;
    }
}
