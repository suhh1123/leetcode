package Array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff += (gas[i] - cost[i]);
        }
        if (diff < 0) {
            return -1;
        } else {
            int start = 0;
            int tank = 0;
            for (int i = 0; i < gas.length; i++) {
                tank = tank + gas[i] - cost[i];
                if (tank < 0) {
                    start = i + 1;
                    tank = 0;
                }
            }
            return start;
        }
    }

    /*public int canComplete(int[] gas, int[] cost, int k) {
        int fuel = gas[k];
        for (int i = 0; i < gas.length; i++) {
            if (fuel < cost[k]) return k;
            fuel = fuel - cost[k];
            k = (k + 1) % gas.length;
            fuel = fuel + gas[k];
        }
        return -1;
    }*/

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        GasStation g = new GasStation();
        int result = g.canCompleteCircuit(gas, cost);
        System.out.print(result);
    }
}
