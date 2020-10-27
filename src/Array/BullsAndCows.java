package Array;

import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] number = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull ++;
            } else {
                if (number[secret.charAt(i) - '0']++ < 0) cow ++;
                if (number[guess.charAt(i) - '0']-- > 0) cow ++;
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        String hint = getHint(secret, guess);
        System.out.print(hint);
    }
}
