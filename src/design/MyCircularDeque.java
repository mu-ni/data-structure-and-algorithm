package design;

public class MyCircularDeque {
    int[] arr;
    int head;
    int tail;
    int k;
    int len;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        this.head = k-1;
        this.tail = 0;
        this.k = k;
        this.len = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (head == k-1) {
            head = 0;
        } else {
            head++;
        }
        arr[head] = value;
        len++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (tail == 0) {
            tail = k-1;
        } else {
            tail--;
        }
        arr[tail] = value;
        len++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        // arr[head] = 0;
        if (head == 0) {
            head = k-1;
        } else {
            head--;
        }
        len--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        // arr[tail] = 0;
        if (tail == k-1) {
            tail = 0;
        } else {
            tail++;
        }
        len--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == k;
    }

    public static void main(String[] args) {
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.insertLast(1));
        System.out.println(cd.insertLast(2));
        System.out.println(cd.insertFront(3));
        System.out.println(cd.insertFront(4));
        System.out.println(cd.getRear());
        System.out.println(cd.isFull());
        System.out.println(cd.deleteLast());
        System.out.println(cd.insertFront(4));
        System.out.println(cd.getFront());

        MyCircularDeque cd = new MyCircularDeque(4);
        System.out.println(cd.insertFront(9));
        System.out.println(cd.deleteLast());
        System.out.println(cd.getRear());
        System.out.println(cd.getFront());
        System.out.println(cd.deleteFront());
        System.out.println(cd.insertFront(6));
        System.out.println(cd.insertLast(5));
        System.out.println(cd.insertFront(9));
        System.out.println(cd.getFront());
        System.out.println(cd.insertFront(6));
    }
}
