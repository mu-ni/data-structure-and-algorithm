package algorithm.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    public static void main(String[] args) {
        System.out.println(new RestoreIpAddress().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<>();
        backtrack(rst, s, new ArrayList<>(), 0);
        return rst;
    }

    public void backtrack(List<String> rst, String s, List<String> path, int start) {
        if (path.size() == 4 && start == s.length()) {
            rst.add(String.join(".", new ArrayList<>(path)));
        }
        if (path.size() >= 4) return;

        for (int i = start; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (!isValidSeg(str)) continue;
            path.add(str);
            backtrack(rst, s, path, i);
            path.remove(path.size() - 1);
        }
    }

    public boolean isValidSeg(String s) {
        if (s.isEmpty() || s.length() > 3) return false;
        int n = Integer.valueOf(s);
        return n <= 255 && s.length() == String.valueOf(n).length();
    }
}
