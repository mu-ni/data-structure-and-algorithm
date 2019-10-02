package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 11}, {6, 16}, {11, 16}};
        System.out.println(new MeetingRooms2().minMeetingRooms(intervals));
        System.out.println(new MeetingRooms2().minMeetingRooms2(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int overlap = 0;
        int i = 0;
        int j = 0;
        while (i < intervals.length && j < intervals.length) {
            if (start[i] < end[j]) {
                i++;
                overlap++;
            } else {
                j++;
                overlap--;
            }
            rooms = Math.max(rooms, overlap);
        }

        return rooms;
    }

    public int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0][1]);
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }
}
