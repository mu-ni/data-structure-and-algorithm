package algorithm.RecursionAndDP;

public class RegularExpression {
    public static void main(String[] args) {
        System.out.println(new RegularExpression().isMatch0("aa", "a."));
        System.out.println(new RegularExpression().isMatch("aab", "c*a*b"));
    }

    // if only . no *
    public boolean isMatch0(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty()) return true;
        if (text.isEmpty() || pattern.isEmpty()) return false;

        if (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') {
            return isMatch0(text.substring(1), pattern.substring(1));
        }
        return false;
    }

//    public boolean isMatch(String text, String pattern) {
//        if (text.isEmpty() && pattern.isEmpty()) return true;
//        if (text.isEmpty() && pattern.length() == 1 && pattern.charAt(0) == '*') return true;
//        if (text.isEmpty() || pattern.isEmpty()) return false;
//
//        if (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') {
//            return isMatch(text.substring(1), pattern.substring(1));
//        }
//
//        if (pattern.charAt(0) == '*') {
//            return isMatch(text.substring(1), pattern) || isMatch(text.substring(1), pattern.substring(1));
//        }
//
//        return false;
//    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        }
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}
