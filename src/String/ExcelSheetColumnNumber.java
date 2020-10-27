package String;

public class ExcelSheetColumnNumber {
    public static int titleToNumber1(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            count += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i);
        }
        return count;
    }

    public static int titleToNumber2(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            count *= 26;
            count += s.charAt(i) - 'A' + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(ExcelSheetColumnNumber.titleToNumber2("AB"));
    }
}
