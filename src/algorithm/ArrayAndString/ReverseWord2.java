package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWord2 {
    public static void main(String[] args) {
        char[] str = "the sky is blue".toCharArray();
        System.out.println(new ReverseWord2().reverseWords(str));
    }

    public char[] reverseWords(char[] str) { // not fully tested
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            if (c == ' ') {
                list.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(c);
        }
        list.add(sb.toString());
        Collections.sort(list);
        char[] rst = new char[str.length];
        int index = 0;
        for (int i=0; i<list.size(); i++) {
            for (char c : list.get(i).toCharArray()) {
                rst[index] = c;
                index++;
            }
            if (i != list.size()-1) {
                rst[index] = ' ';
                index++;
            }
        }
        return rst;
    }
}
