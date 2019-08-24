package algorithm.TreeAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BuildOrder {
    public static void main(String[] args) {
        char[] projects = new char[]{'a','b','c','d','e','f'};
        char[][] dependencies = new char[][]{{'a','d'},{'f','b'},{'b','d'},{'f','a'},{'d','c'}};
        System.out.println(Arrays.toString(new BuildOrder().buildOrder(projects, dependencies)));
    }

    public char[] buildOrder(char[] projects, char[][] dependencies) {
        int[] indegree = new int[projects.length];
        for (int i=0; i<dependencies.length; i++) {
//            char pre = dependencies[i][0];
            char cur = dependencies[i][1];
            indegree[cur - 'a']++;
        }

        Queue<Character> queue = new LinkedList<>();
        char[] order = new char[projects.length];
        int index = 0;
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                char cur = (char)(i + (int)'a');
                queue.offer(cur);
                order[index++] = cur;
            }
        }

        while(!queue.isEmpty()) {
            char finished = queue.poll();
            for (int i=0; i<dependencies.length; i++) {
                char pre = dependencies[i][0];
                char cur = dependencies[i][1];
                if (pre == finished) {
                    indegree[cur - 'a']--;
                    if (indegree[cur - 'a'] == 0) {
                        queue.offer(cur);
                        order[index++] = cur;
                    }
                }
            }
        }

        return index == projects.length ? order : new char[0];
    }
}
