package algorithm.ArrayAndString.LongestSubstring;

public class CommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String rst = strs[0];
        for(String str : strs) {
            while(str.indexOf(rst) != 0) {
                rst = rst.substring(0, rst.length()-1);
            }
        }
        return rst;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];

        String prefix = "";
        for (int i=0; i<strs.length-1;i++) {
            String s1 = strs[i];
            String s2 = strs[i+1];
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<Math.min(s1.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    break;
                }
                sb.append(s1.charAt(j));
            }

            if (i == 0 || prefix.length() > sb.toString().length()) {
                prefix = sb.toString();
            }
        }

        return prefix;
    }
}
