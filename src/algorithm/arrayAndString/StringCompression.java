package algorithm.arrayAndString;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("abc"));
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String str) {
        if(str.length() <= 2) return str;

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            count ++;
            if(i == str.length() -1 || str.charAt(i) != str.charAt(i+1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return sb.toString().length() >= str.length() ? str : sb.toString();
    }
}
