package algorithm.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by muni on 2019/12/9
 */
public class MoviesOnFlight {
    public static void main(String[] args) {
        int[] movies = new int[]{90, 85, 75, 60, 120, 150, 125};
        System.out.println(Arrays.toString(new MoviesOnFlight().moviesOnFlight(movies, 250)));
    }

    public int[] moviesOnFlight(int[] movies, int duration) {
        Arrays.sort(movies);
        int left = 0;
        int right = movies.length-1;
        int[] rst = new int[2];
        while (left < right) {
            int sum = movies[left] + movies[right];
            if (sum > duration - 30) {
                right--;
            } else {
                rst[0] = movies[left];
                rst[1] = movies[right];
                left++;
            }
        }
        return rst;
    }
}
