package algorithm.ArrayAndString;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] chars) {
        int i = 0;
        int len = 1;
        int index = 0;
        while (i < chars.length) {
            while (i+1 < chars.length && chars[i] == chars[i+1]) {
                len++;
                i++;
            }

            chars[index++] = chars[i];
            if (len != 1) {
                for (char n : String.valueOf(len).toCharArray()) {
                    chars[index++] = n;
                }
            }
            len = 1;
            i++;
        }
        return index;
    }
}
