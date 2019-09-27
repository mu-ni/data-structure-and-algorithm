package algorithm.ArrayAndString;

public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c: tasks) {
            arr[c - 'A']++;
        }

        //Most frequent task.
        int max = 0;
        for (int val : arr) {
            max = Math.max(val, max);
        }

        //how many tasks that has the same frequency as the top frequent task.(include itself)
        //these tasks will be set in the last round, so just add p
        int p = 0;
        for (int val : arr) {
            if (val == max) {
                p++;
            }
        }

        //Totally intervals to fill out all empty space.
        int total = (max - 1) * (n + 1) + p;
        return Math.max(total, tasks.length);
    }
}
