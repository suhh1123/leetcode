package BinarySearch;

public class FirstBadVersion {
    public boolean isBadVersion(int n) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid;
            }
            if (isBadVersion(mid) && isBadVersion(mid - 1)) {
                right = mid - 1;
            } else if (!isBadVersion(mid)) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
