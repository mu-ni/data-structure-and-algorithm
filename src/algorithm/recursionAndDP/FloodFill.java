package algorithm.recursionAndDP;

import java.util.Arrays;

/**
 * Created by muni on 2019/8/5
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] filled = floodFill(new int[][]{{1,1,1}, {1,1,0},{1,0,1}}, 1, 1, 2);
        System.out.println(Arrays.deepToString(filled));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void fill(int[][] image, int r, int c, int oldColor, int newColor) {
        if(r< 0 || r>image.length-1 || c <0 || c>image[0].length-1) {
            return;
        }
        if(image[r][c] != oldColor) {
            return;
        }

        image[r][c] = newColor;
        fill(image, r-1, c, oldColor, newColor);
        fill(image, r, c-1, oldColor, newColor);
        fill(image, r+1, c, oldColor, newColor);
        fill(image, r, c+1, oldColor, newColor);
    }
}
