package algorithm.SearchAndSort;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] reordered = new ReorderLogFiles().reorderLogFiles(logs);
        System.out.println(Arrays.toString(reordered));
    }

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = (o1, o2) -> {
            int i1 = o1.indexOf(" ");
            int i2 = o2.indexOf(" ");
            boolean isDig1 = Character.isDigit(o1.charAt(i1+1));
            boolean isDig2 = Character.isDigit(o2.charAt(i2+1));
            if (!isDig1 && !isDig2) {
                int comp = o1.substring(i1+1).compareTo(o2.substring(i2+1));
                return comp == 0 ? o1.substring(0, i1).compareTo(o2.substring(0, i2)) : comp;
            }
            if (isDig1 && isDig2) {
                return 0;
            }
            return isDig1 ? 1 : -1;
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
