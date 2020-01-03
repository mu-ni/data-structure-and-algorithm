package algorithm.ArrayAndString;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(new StringCompression().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(new StringCompression().compress2(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(new StringCompression().compress3(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(new StringCompression().compress4(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public int compress(char[] chars) {
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

    public int compress2(char[] chars) {
        int len = 1;
        int index = 0;
        for (int i=0; i<chars.length; i++) {
            if (i != chars.length-1 && chars[i] == chars[i+1]) {
                len++;
                continue;
            }
            chars[index++] = chars[i];
            if (len != 1) {
                for (char n : String.valueOf(len).toCharArray()) {
                    chars[index++] = n;
                }
            }
            len = 1;
        }
        return index;
    }

    public int compress3(char[] chars) {
        if (chars.length <= 1) return chars.length;
        char c = chars[0];
        int count = 1;
        int index = 0;
        for (int i=1; i<chars.length; i++) {
            if (chars[i] == c) {
                count++;
            } else {
                chars[index++] = c;
                if (count != 1) {
                    for (char d : String.valueOf(count).toCharArray()) {
                        chars[index++] = d;
                    }
                }
                c = chars[i];
                count = 1;
            }
        }
        chars[index++] = c;
        if (count != 1) {
            for (char d : String.valueOf(count).toCharArray()) {
                chars[index++] = d;
            }
        }
        return index;
    }

    public int compress4(char[] chars) {
        if (chars.length <= 1) return chars.length;
        char c = chars[0];
        int count = 1;
        int index = 0;
        for (int i=1; i<=chars.length; i++) {
            if (i == chars.length || chars[i] != c) {
                chars[index++] = c;
                if (count != 1) {
                    for (char d : String.valueOf(count).toCharArray()) {
                        chars[index++] = d;
                    }
                }
                if (i != chars.length) {
                    c = chars[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return index;
    }
}
