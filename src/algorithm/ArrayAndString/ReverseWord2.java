package algorithm.ArrayAndString;


public class ReverseWord2 {
    public static void main(String[] args) {
        char[] str = "the sky is blue".toCharArray();
        System.out.println(new ReverseWord2().reverseWords(str));
    }

    public char[] reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        int start = 0;
        for (int i=0; i<str.length; i++) {
            if (i == str.length-1) {
                reverse(str, start, i);
                continue;
            }
            if (str[i] == ' ') {
                reverse(str, start, i-1);
                start = i+1;
            }
        }
        return str;
    }

    public void reverse(char[] str, int start, int end) {
        while(start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;

            start++;
            end--;
        }
    }
}
