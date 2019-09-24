package algorithm.RecursionAndDP;

import java.util.Stack;

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

    // 递增栈
    public int largestRectangleArea2(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                // 出栈元素构成的最大面积
                int h = heights[stack.pop()];
                int w = i - (stack.isEmpty() ? 0 : stack.peek()+1);
                max = Math.max(max, h*w);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = heights.length - (stack.isEmpty() ? 0 : stack.peek()+1);
            max = Math.max(max, h*w);
        }

        return max;
    }
}
