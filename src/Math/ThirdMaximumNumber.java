package Math;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for (Integer num : nums) {
            if (num.equals(max) || num.equals(second_max) || num.equals(third_max)) {
                continue;
            }

            if (max == null || num > max) {
                third_max = second_max;
                second_max = max;
                max = num;
            } else if (second_max == null || num > second_max) {
                third_max = second_max;
                second_max = num;
            } else if (third_max == null || num > third_max) {
                third_max = num;
            }
        }
        if (third_max == null) {
            return max;
        } else {
            return third_max;
        }
    }
}
