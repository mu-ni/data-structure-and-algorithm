package algorithm.Graph;

import java.util.*;

public class CourseFindOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseFindOrder().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(new CourseFindOrder().findOrder2(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(new CourseFindOrder().findOrder3(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) { // bfs
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
//            int pre = prerequisites[i][1];
            indegree[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                order[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int finished = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                int cur = prerequisites[i][0];
                int pre = prerequisites[i][1];
                if (pre == finished) {
                    indegree[cur]--;
                    if (indegree[cur] == 0) {
                        queue.offer(cur);
                        order[index++] = cur;
                    }
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) { //adjMatrix, dfs
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[cur]++;
            matrix[pre][cur] = 1;
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int pre = 0; pre < numCourses; pre++) {
            if (!topoSort(matrix, pre, visited, stack)) return new int[0];
        }

        int index = 0;
        int[] order = new int[numCourses];
        while (!stack.isEmpty()) {
            int pre = stack.pop();
            order[index++] = pre;
        }
        return order;
    }

    public boolean topoSort(int[][] matrix, int pre, int[] visited, Stack<Integer> stack) {
        if (visited[pre] == 2) return true;
        if (visited[pre] == 1) return false;
        visited[pre] = 1;

        for (int cur = 0; cur < matrix.length; cur++) {
            if (matrix[pre][cur] == 1) {
                if (!topoSort(matrix, cur, visited, stack)) return false;
            }
        }
        visited[pre] = 2;
        stack.push(pre);
        return true;
    }

    public int[] findOrder3(int numCourses, int[][] prerequisites) { //adjList, dfs
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            lists[pre].add(cur);
            indegree[cur]++;
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int pre = 0; pre < numCourses; pre++) {
            if (!topoSort(lists, pre, visited, stack)) return new int[0];
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            int pre = stack.pop();
            order[index++] = pre;
        }

        return order;
    }

    public boolean topoSort(List<Integer>[] lists, int pre, int[] visited, Stack<Integer> stack) {
        if (visited[pre] == 2) return true;
        if (visited[pre] == 1) return false;
        visited[pre] = 1;

        for (int cur : lists[pre]) {
            if (!topoSort(lists, cur, visited, stack)) return false;
        }
        visited[pre] = 2;
        stack.push(pre);
        return true;
    }
}