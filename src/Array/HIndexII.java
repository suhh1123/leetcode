package Array;

public class HIndexII {
    public int hIndex(int[] citations) {
        // The idea is to search for the first index from the sorted array so that :
        // citations[index] >= length(citations) - index
        int len = citations.length;
        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return len - lo;
    }
}
