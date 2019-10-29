package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinTimeDifference {
    public static void main(String[] args) {
        System.out.println(new MinTimeDifference().findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int min = Integer.MAX_VALUE;
        for (int i=1; i<timePoints.size(); i++) {
            int diff = getMin(timePoints.get(i)) - getMin(timePoints.get(i-1));
            min = Math.min(min, diff);
        }
        int corner = 24*60 + getMin(timePoints.get(0)) - getMin(timePoints.get(timePoints.size() - 1));

        return Math.min(min, corner);
    }

    public int getMin(String str) {
        String[] time = str.split(":");
        return Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
    }
}
