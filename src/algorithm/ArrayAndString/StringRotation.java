package algorithm.ArrayAndString;

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(new StringRotation().rotateString("abcde", "cdeab"));
        System.out.println(new StringRotation().rotateString2("abcde", "cdeab"));
    }

    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        return (A + A).contains(B);
    }

    public boolean rotateString2(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.length()==0 && B.length()==0) return true;

        for(int i=1; i<B.length(); i++) {
            String first = B.substring(0, i);
            String second = B.substring(i, B.length());
            if(A.equals(second+first)) return true;
        }
        return false;
    }
}
