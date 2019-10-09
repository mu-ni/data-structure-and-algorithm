package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.List;

public class ValidWordSquare {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("abcd", "bnrt", "crm", "dt");
        System.out.println(new ValidWordSquare().validWordSquare(words));
        System.out.println(new ValidWordSquare().validWordSquare2(words));
    }

    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for (int i=0; i<n; i++) {
            String w1 = words.get(i);
            String w2 = getWord(words, i);
            if (!w1.equals(w2)) return false;
        }
        return true;
    }

    public String getWord(List<String> words, int i) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (i < word.length()) {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean validWordSquare2(List<String> words) {
        int n = words.size();
        for(int i=0; i<n; i++){
            String w1 = words.get(i);
            for(int j=0; j<w1.length(); j++){
                if (j >= n) return false;
                String w2 = words.get(j);
                if(i >= w2.length() || w2.charAt(i) != w1.charAt(j))
                    return false;
            }
        }
        return true;
    }
}

