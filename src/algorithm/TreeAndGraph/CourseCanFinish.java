package algorithm.TreeAndGraph;

import java.util.*;

public class CourseCanFinish {
    public static void main(String[] args) {
        System.out.println(new CourseCanFinish().canFinish(3, new int[][]{{2,0},{2,1}}));
        System.out.println(new CourseCanFinish().canFinish2(3, new int[][]{{2,0},{2,1}}));
        System.out.println(new CourseCanFinish().canFinish3(3, new int[][]{{2,0},{2,1}}));
        System.out.println(new CourseCanFinish().canFinish4(3, new int[][]{{2,0},{2,1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) { // adjMatrix, bfs
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[cur]++;
            matrix[pre][cur] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            for (int cur=0; cur<numCourses; cur++) {
                if (matrix[pre][cur] == 1) {
                    indegree[cur]--;
                    if (indegree[cur] == 0) queue.offer(cur);
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) { // adjList, bfs
        List<Integer>[] list = new List[numCourses];
        for (int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            list[pre].add(cur);
            indegree[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int cur : list[pre]) {
                indegree[cur]--;
                if (indegree[cur] == 0) queue.offer(cur);
            }
            count++;
        }

        return count == numCourses;
    }

    public boolean canFinish3(int numCourses, int[][] prerequisites) { // adjMatrix, dfs
        int[][] matrix = new int[numCourses][numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            matrix[pre][cur] = 1;
        }

        boolean[] visited = new boolean[numCourses];
        for(int pre = 0; pre < numCourses; pre++) {
            if (!topoSort(matrix, pre, visited)) return false;
        }

        return true;
    }

    public boolean topoSort(int[][] matrix, int pre, boolean[] visited) {
        if (visited[pre]) return false;
        visited[pre] = true;

        for (int cur=0; cur<matrix.length; cur++) {
            if (matrix[pre][cur] == 1) {
                if (!topoSort(matrix, cur, visited)) return false;
            }
        }
        visited[pre] = false;
        return true;
    }

    public boolean canFinish4(int numCourses, int[][] prerequisites) { // adjList, dfs
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            lists[pre].add(cur);
        }

        boolean[] visited = new boolean[numCourses];
        for (int pre = 0; pre < numCourses; pre++) {
            if (!topoSort(lists, pre, visited))
                return false;
        }

        return true;
    }

    public boolean topoSort(List<Integer>[] lists, int pre, boolean[] visited) {
        if(visited[pre]) return false;
        visited[pre] = true;

        for(int cur : lists[pre]){
            if(!topoSort(lists,cur, visited))
                return false;
        }
        visited[pre] = false;
        return true;
    }
}
