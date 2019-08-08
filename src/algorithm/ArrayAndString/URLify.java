package algorithm.ArrayAndString;

public class URLify {
    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith       ", 13));
    }

    public static String urlify(String s, int len) {
        char[] arr = new char[s.length()];
        int index = s.length()-1;

        for(int i= len-1; i>=0; i--) {
            if(s.charAt(i) == ' ') {
                arr[index] = '0';
                arr[index-1] = '2';
                arr[index-2] = '%';
                index -= 3;
                continue;
            }
            arr[index] = s.charAt(i);
            index --;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            if(c != ' ') {
                sb.append(c);
            }
        }

        System.out.println(sb.toString().length());
        return sb.toString();
    }
}
