package algorithm.SearchAndSort;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] reordered = new ReorderLogFiles().reorderLogFiles(logs);
        System.out.println(Arrays.toString(reordered));

        logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        reordered = new ReorderLogFiles().reorderLogFiles2(logs);
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
            return isDig1 ? 1 : -1;// s1 > s2 -> return 1
        };
        Arrays.sort(logs, comparator);
        return logs;
    }

    public String[] reorderLogFiles2(String[] logs) {
        Comparator<String> comp = (a, b) -> {
            String[] arrA = a.split(" ");
            String[] arrB = b.split(" ");
            String idA = arrA[1];
            String idB = arrB[1];

            if (isInteger(idA) && isInteger(idB)) return 0;
            if (!isInteger(idA) && !isInteger(idB)) {
                String nextA = String.join(" ", Arrays.copyOfRange(arrA, 1, arrA.length));
                String nextB = String.join(" ", Arrays.copyOfRange(arrB, 1, arrB.length));
                int compStr = nextA.compareTo(nextB);
                if (compStr == 0) {
                    return arrA[0].compareTo(arrB[0]);
                }
                return compStr;
            }
            return isInteger(idA) ? 1 : -1; // 1 -> idB, idA
        };
        Arrays.sort(logs, comp);
        return logs;
    }

    public boolean isInteger(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
