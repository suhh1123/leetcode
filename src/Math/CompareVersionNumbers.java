package Math;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int p1 = 0, p2 = 0;
        while (p1 < v1.length || p2 < v2.length) {
            String s1 = p1 < v1.length ? v1[p1] : "0";
            String s2 = p2 < v2.length ? v2[p2] : "0";
            int x1 = Integer.parseInt(s1);
            int x2 = Integer.parseInt(s2);
            if (x1 > x2) return 1;
            else if (x1 < x2) return -1;
            else {
                p1 ++;
                p2 ++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        int res = c.compareVersion(version1, version2);
        System.out.print(res);
    }
}
