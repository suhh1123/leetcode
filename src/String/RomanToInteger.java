package String;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt1(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int count = 0;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        } else {
            for (int i=0; i<s.length()-1; i++) {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                    count += -map.get(s.charAt(i));
                } else {
                    count += map.get(s.charAt(i));
                }
            }
            count += map.get(s.charAt(s.length()-1));
        }
        return count;
    }

    public int romanToInt2(String s) {
        int count = 0;
        int last = 1000;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (getValue(c) > last) count = count - 2 * last;
            count += getValue(c);
            last = getValue(c);
        }
        return count;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        String s = "MCMXCIV";
        int result = r.romanToInt2(s);
        System.out.println(result);
    }
}
