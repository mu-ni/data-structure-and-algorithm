package algorithm.ArrayAndString;

public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int i1 = 0;
        int i2 = 0;
        while (i1 < levels1.length && i2 < levels2.length) {
            int v1 = Integer.valueOf(levels1[i1]);
            int v2 = Integer.valueOf(levels2[i2]);
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
            i1++;
            i2++;
        }
        while (i1 < levels1.length) {
            int v1 = Integer.valueOf(levels1[i1]);
            if (v1 != 0) return 1;
            i1++;
        }
        while (i2 < levels2.length) {
            int v2 = Integer.valueOf(levels2[i2]);
            if (v2 != 0) return -1;
            i2++;
        }
        return 0;
    }
}
