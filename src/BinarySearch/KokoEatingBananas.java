package BinarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        int left = 1, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!possible(piles, H, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles) {
            time += (int) Math.ceil((double) p / K);
        }
        return time <= H;
    }

    public static void main(String[] args) {
        KokoEatingBananas k = new KokoEatingBananas();
        int[] piles = {30,11,23,4,20};
        int result = k.minEatingSpeed(piles, 5);
        System.out.print(result);
    }
}
