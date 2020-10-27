package Math;

public class AddDigits {
    public int addDigits(int num) {
        if (num / 10 == 0) return num;
        int currNum = 0;
        while (num != 0) {
            int curr = num % 10;
            num /= 10;
            currNum += curr;
        }
        return addDigits(currNum);
    }
}
