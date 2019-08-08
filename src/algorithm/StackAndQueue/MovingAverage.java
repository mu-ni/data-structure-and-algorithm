package algorithm.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    double sum = 0;
    int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;

        if(queue.size() > size) {
            sum -= queue.poll();
        }

        return sum/queue.size();
    }
}
