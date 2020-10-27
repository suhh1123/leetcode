package String;

import java.util.ArrayList;
import java.util.List;

// You are playing the following Flip Game with your friend: Given a string that contains only
// these two characters: + and -, you and your friend take turns to flip two consecutive "++"
// into "--". The game ends when a person can no longer make a move and therefore the other person
// will be the winner.

// Write a function to compute all possible states of the string after one valid move.

// Amazon Questions
public class FlipGame {
    public static List<String> generatePossibleNextMoves1(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length()-1; i++) {
            if (sb.charAt(i) == sb.charAt(i+1) && sb.charAt(i) == '+') {
                sb.setCharAt(i,'-');
                sb.setCharAt(i+1,'-');
                result.add(sb.toString());
                sb.setCharAt(i,'+');
                sb.setCharAt(i,'+');
            }
        }
        return result;
    }

    public static List<String> generatePossibleNextMoves2(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<s.length()-1; i++) {
            if (chars[i] == chars[i+1] && chars[i] == '+') {
                chars[i] = '-';
                chars[i+1] = '-';
                result.add(new String(chars));
                chars[i] = '+';
                chars[i+1] = '+';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "++--+-++--++";
        List<String> result = FlipGame.generatePossibleNextMoves2(s);
        for (String curr : result) {
            System.out.println(curr);
        }
    }
}
