package algorithm.ArrayAndString;

public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion2("0.1", "1.1"));
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

    public static int compareVersion2(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len = Math.min(arr1.length, arr2.length);
        for (int i=0; i<len; i++) {
            int v1 = Integer.valueOf(arr1[i]);
            int v2 = Integer.valueOf(arr2[i]);
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        for (int i=len; i<arr1.length; i++) {
            int v1 = Integer.valueOf(arr1[i]);
            if (v1 != 0) return 1;
        }
        for (int i=len; i<arr2.length; i++) {
            int v2 = Integer.valueOf(arr2[i]);
            if (v2 != 0) return -1;
        }
        return 0;
    }
}
