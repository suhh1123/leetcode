package String;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String key = getHashKey(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }

    private String getHashKey(String s) {
        if (s.length() == 1) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append((s.charAt(i) - s.charAt(i - 1) + 26) % 26);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupShiftedStrings g = new GroupShiftedStrings();
        String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> result = g.groupStrings(strings);
        System.out.println(result);
    }
}
