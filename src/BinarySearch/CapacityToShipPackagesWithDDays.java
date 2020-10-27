package BinarySearch;

public class CapacityToShipPackagesWithDDays {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = 0;
        for (int num : weights) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = split(weights, mid);
            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] weights, int largestW) {
        int day = 1;
        int tempSum = 0;
        for (int num : weights) {
            if (tempSum + num > largestW) {
                tempSum = num;
                day ++;
            } else {
                tempSum += num;
            }
        }
        return day;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithDDays c = new CapacityToShipPackagesWithDDays();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int result = c.shipWithinDays(weights, D);
        System.out.println(result);
    }
}
