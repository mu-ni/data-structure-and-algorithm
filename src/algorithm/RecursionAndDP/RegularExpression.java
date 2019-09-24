package algorithm.RecursionAndDP;

public class RegularExpression {
    public static void main(String[] args) {
        System.out.println(new RegularExpression().isMatch0("aa", "a."));
        System.out.println(new RegularExpression().isMatch("aa", "a*c*a"));
        System.out.println(new RegularExpression().isMatch2("aab", "c*a*b"));
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

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        boolean first_match = !text.isEmpty() &&
                (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) ||
                    first_match && isMatch(text.substring(1), pattern);
        }
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }

    public boolean isMatch2(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j = 2; j <=n; j +=2){
            if(pattern.charAt(j - 1) == '*' && dp[0][j - 2]){
                dp[0][j] = true;
            }
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                if (pattern.charAt(j-1) == '*') {
                    if(pattern.charAt(j - 2) != '.' && pattern.charAt(j - 2) != text.charAt(i - 1)){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
