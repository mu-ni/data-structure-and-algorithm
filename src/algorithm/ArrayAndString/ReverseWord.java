package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWord {
    public static void main(String[] args) {
        String s = "a good  example  ";
        System.out.println(new ReverseWord().reverseWords(s));
        System.out.println(new ReverseWord().reverseWords2(s));
    }

    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            if (str.isEmpty()) continue;
            list.add(0, str);
        }
        return String.join(" ", list);
    }

    public String reverseWords2(String s) {
        String[] arr = s.trim().split(" +");
        Collections.reverse(Arrays.asList(arr));
        return String.join(" ", arr);
    }
}
