package String;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n --;
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ExcelSheetColumnTitle.convertToTitle(26));
    }
}