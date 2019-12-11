package flag.amz;

/**
 * Created by muni on 2019/12/9
 */
public class LongestStringOnlyVowels {
    public static void main(String[] args) {
        System.out.println(new LongestStringOnlyVowels().longestString("earthproblem"));
    }

    // TODO
    public int longestString(String s){
        int len = s.length();
        int start = 0, end = len - 1;
        while(start < len && isVowel(s.charAt(start))) ++start;
        while(end >= 0 && isVowel(s.charAt(end))) --end;
        // checking area come to [start, end]
        if(start >= len) return len;
        int res = start + len - 1 - end;
        int longest = 0, sum = 0;
        for(int i = start + 1; i <= end; ++i){
            if(isVowel(s.charAt(i)))
                ++sum;
            else
                sum = 0;
            longest = Math.max(sum, longest);
        }
        return longest + res;
    }


    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
