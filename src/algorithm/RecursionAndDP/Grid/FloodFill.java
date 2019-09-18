package algorithm.RecursionAndDP.Grid;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] filled = floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        System.out.println(Arrays.deepToString(filled));
        filled = floodFill(new int[][]{{0,0,0}, {0,1,1}}, 1, 1, 1);
        System.out.println(Arrays.deepToString(filled));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;
        if (image[sr][sc] == newColor) return image;

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void fill(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) return;
        if (image[x][y] != oldColor) return;

        image[x][y] = newColor;
        fill(image, x-1, y, oldColor, newColor);
        fill(image, x+1, y, oldColor, newColor);
        fill(image, x, y-1, oldColor, newColor);
        fill(image, x, y+1, oldColor, newColor);
    }
}
