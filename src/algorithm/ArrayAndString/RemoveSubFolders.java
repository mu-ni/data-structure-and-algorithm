package algorithm.ArrayAndString;

import java.util.*;

public class RemoveSubFolders {
    public static void main(String[] args) {
        System.out.println(new RemoveSubFolders().removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
        System.out.println(new RemoveSubFolders().removeSubfolders2(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for (String f : folder) {
            boolean found = false;
            for (int i=0; i<f.length(); i++) {
                if (f.charAt(i) != '/') continue;
                String parent = f.substring(0, i);
                if (set.contains(parent)) {
                    found = true;
                    break;
                }
            }
            if (!found) set.add(f);
        }
        return new ArrayList<>(set);
    }

    public List<String> removeSubfolders2(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for (String f : folder) {
            boolean found = false;
            String[] arr = f.split("/");
            List<String> list = new ArrayList<>();
            for (String s : arr) {
                list.add(s);
                if (set.contains(String.join("/", list))) {
                    found = true;
                    break;
                }
            }
            if (!found) set.add(String.join("/", list));
        }

        return new ArrayList<>(set);
    }

//    public List<String> removeSubfolders3(String[] folder) {
//        // TODO TRIE
//
//    }
}
