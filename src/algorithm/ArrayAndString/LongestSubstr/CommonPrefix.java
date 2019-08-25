package algorithm.ArrayAndString.LongestSubstr;

public class CommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
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
}
