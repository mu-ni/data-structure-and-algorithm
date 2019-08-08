package algorithm.recursionAndDP;

public class MagicIndex {
    public static void main(String[] args) {
        System.out.print(magicIndex(new int[]{-40,-20,-1,1,1,2,3,5,7,9,12,13}));
    }

    public static int magicIndex(int[] arr) {
        return magicIndex(arr, 0, arr.length-1);
    }

    public static int magicIndex(int[] arr, int start, int end) {
        if(start > end) {
            return -1;
        }
        int pivot = (start + end)/2;
        if(pivot < arr[pivot]) {
            return magicIndex(arr, start, pivot-1);
        }
        if (pivot > arr[pivot]){
            return magicIndex(arr, pivot+1, end);
        }
        return pivot; //pivot == arr[pivot]
    }
}
