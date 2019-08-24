package algorithm.TreeAndGraph;

import java.util.*;

public class BuildOrder {
    public static void main(String[] args) {
        char[] projects = new char[]{'a','b','c','d','e','f'};
        char[][] dependencies = new char[][]{{'a','d'},{'f','b'},{'b','d'},{'f','a'},{'d','c'}};
        System.out.println(Arrays.toString(new BuildOrder().buildOrder(projects, dependencies)));
        System.out.println(Arrays.toString(new BuildOrder().buildOrder2(projects, dependencies)));
    }

    public char[] buildOrder(char[] projects, char[][] dependencies) { //bfs
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

    public char[] buildOrder2(char[] projects, char[][] dependencies) {// dfs
        List<Character>[] lists = new List[projects.length];
        for (char pre : projects) {
            lists[pre - 'a'] = new ArrayList<>();
        }
        int[] indegree = new int[projects.length];
        for (int i=0; i<dependencies.length; i++) {
            char pre = dependencies[i][0];
            char cur = dependencies[i][1];
            lists[pre - 'a'].add(cur);
            indegree[cur - 'a']++;
        }

        int[] visited = new int[projects.length];
        Stack<Character> stack = new Stack<>();
        for (char pre : projects) {
            if (!topoSort(lists, pre, visited, stack)) return new char[0];
        }

        char[] order = new char[projects.length];
        int index = 0;
        while(!stack.isEmpty()) {
            char pre = stack.pop();
            order[index++] = pre;
        }

        return order;
    }

    public boolean topoSort(List<Character>[] lists, char pre, int[] visited, Stack<Character> stack) {
        if (visited[pre - 'a'] == 1) return false;
        if (visited[pre - 'a'] == 2) return true;

        visited[pre-'a'] = 1;
        for (char cur : lists[pre - 'a']) {
            if (!topoSort(lists, cur, visited, stack)) return false;
        }

        visited[pre - 'a'] = 2;
        stack.push(pre);
        return true;
    }
}
