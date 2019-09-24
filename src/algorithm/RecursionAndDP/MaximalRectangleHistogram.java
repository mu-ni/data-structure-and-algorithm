package algorithm.RecursionAndDP;

public class MaximalRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(new MaximalRectangleHistogram().largestRectangleArea(heights));
        System.out.println(new MaximalRectangleHistogram().largestRectangleArea2(heights));
    }

    // brute force TLE
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i=0; i<heights.length; i++) {
            for (int j=i; j<heights.length; j++) {
                area = Math.max(area, minHeight(heights, i, j)*(j-i+1));
            }
        }
        return area;
    }

    public int minHeight(int[] heights, int start, int end) {
        int min = heights[start];
        for (int i=start; i<=end; i++) {
            min = Math.min(min, heights[i]);
        }
        return min;
    }

    public int largestRectangleArea2(int[] heights) {
        int[] left = new int[heights.length];
        left[0] = heights[0];
        for (int i=1; i<heights.length; i++) {
            left[i] = Math.min(left[i-1], heights[i]);
        }
        int[] right = new int[heights.length];
        right[heights.length-1] = heights[heights.length-1];
        for (int i=heights.length-2; i>=0; i--) {
            heights[i] = Math.min(heights[i+1], heights[i]);
        }

        int rst = 0;
        for (int i=0; i<heights.length; i++) {
            int area = heights[i]*(right[i] - left[i] - 1);
            rst = Math.max(rst, area);
        }
        return rst;
    }
}
