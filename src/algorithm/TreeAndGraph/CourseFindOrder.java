package algorithm.TreeAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseFindOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseFindOrder().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            int cur = prerequisites[i][0];
//            int pre = prerequisites[i][1];
            indegree[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[numCourses];
        int index = 0;
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                order[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int finished = queue.poll();
            for (int i = 0; i<prerequisites.length; i++) {
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
}
