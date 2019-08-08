package algorithm.recursionAndDP;

public class MultiplyString {
    public static void main(String[] args) {
//        char a = "2580".charAt(2);
//        System.out.println(a);
//        int b = "2580".charAt(2) - '0';
//        System.out.println(b);
        System.out.println(multiply("123", "45"));
    }

    // TODO try with recursion
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] num = new int[len1 + len2];

        for(int i=len1-1; i>=0; i--) {
            for(int j=len2-1; j>=0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2;

                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + num[p2];

                num[p1] = num[p1] + sum/10;
                num[p2] = sum%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p: num) {
            if(sb.length() == 0 && p == 0) continue;
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
