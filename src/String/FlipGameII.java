package String;

// You are playing the following Flip Game with your friend: Given a string that contains only
// these two characters: + and -, you and your friend take turns to flip two consecutive "++"
// into "--". The game ends when a person can no longer make a move and therefore the other person
// will be the winner.

// Write a function to determine if the starting player can guarantee a win.

// Amazon Question
public class FlipGameII {
    public boolean canWin(String s) {
        char[] arr = s.toCharArray();
        return canWinHelper(arr);
    }

    public boolean canWinHelper(char[] arr) {
        if (arr == null || arr.length < 2) return false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                if (!canWinHelper(arr)) {
                    return true;
                }
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }
        return false;
    }
}
