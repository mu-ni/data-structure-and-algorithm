package algorithm.RecursionAndDP;

import java.util.Stack;

/**
 * Your HanoiStack object will be instantiated and called as such:
 * HanoiStack[] hanoi = new HanoiStack[3];   
 * for (int i = 0; i < 3; i++) hanoi[i] = new HanoiStack(i);
 * for (int i = n - 1; i >= 0; i--) hanoi[0].add(i);   
 * hanoi[0].moveDisks(n, hanoi[2], hanoi[1]);
 * print hanoi[0], hanoi[1], hanoi[2]
 */
public class HanoiStack {
    private Stack<Integer> disks;
    private int n;
    
    public HanoiStack(int i) {
        this.disks = new Stack<>();
        this.n = i;
    }

    public void add(int d) {
        // Add a disk into this HanoiStack
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }
    
    public void moveTopTo(HanoiStack t) {
        // Move the top disk of this HanoiStack to the top of t.
        int top = disks.pop();
        t.add(top);
    }
    
    public void moveDisks(int n, HanoiStack destination, HanoiStack buffer) {
        // Move n Disks from this HanoiStack to destination by buffer HanoiStack
        if(n > 0) {
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}
