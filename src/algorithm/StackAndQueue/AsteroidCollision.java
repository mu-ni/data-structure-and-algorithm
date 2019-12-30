package algorithm.StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by muni on 2019/12/30
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision2(new int[]{5,10,-5})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        int[] next = helper(asteroids);
        while (next.length != helper(next).length) {
            next = helper(next);
        }
        return next;
    }

    public int[] helper(int[] asteroids) {
        if (asteroids.length == 0) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int n : asteroids) {
            if (!stack.isEmpty() && (stack.peek() > 0 && n < 0)){
                int val = stack.pop();
                if (Math.abs(val) > Math.abs(n)) {
                    stack.push(val);
                } else if (Math.abs(val) < Math.abs(n)) {
                    stack.push(n);
                }
            } else {
                stack.push(n);
            }
        }

        int[] rst = new int[stack.size()];
        int index = stack.size()-1;
        while (!stack.isEmpty()) {
            rst[index--] = stack.pop();
        }
        return rst;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int n : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && n < 0 && stack.peek() < -n) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > 0 && n < 0 && stack.peek() == -n) {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() > 0 && n < 0 && stack.peek() > -n) {
            } else {
                stack.push(n);
            }
        }

        int[] rst = new int[stack.size()];
        int index = stack.size()-1;
        while (!stack.isEmpty()) {
            rst[index--] = stack.pop();
        }
        return rst;
    }
}
