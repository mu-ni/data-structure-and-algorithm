package algorithm.ArrayAndString;

import java.util.Arrays;

public class MeetingRooms2 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{7,10},{2,4}};
        System.out.println(new MeetingRooms2().minMeetingRooms(intervals));
        intervals = new int[][]{{2, 11}, {6, 16}, {11, 16}};
        System.out.println(new MeetingRooms2().minMeetingRooms(intervals));
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
}
