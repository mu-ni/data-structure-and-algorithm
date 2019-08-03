package datastruc.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {17,6,8,92,45,34,61,72,59,23,16};
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
		
//		partition(array, 0, array.length-1, 21);
//		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int[] array, int left, int right){//O(n*logn)
		if(right - left < 1){
			return;
		}else{
			int pivot = array[right];
			int partition = partitionForQuickSort(array, left, right, pivot);
			quickSort(array, left, partition-1);
			quickSort(array, partition+1, right);
		}		
	}
	
	public static int partitionForQuickSort(int[] array, int left, int right, int pivot){
		int leftPointer = left;
		int rightPointer = right-1;//except the right(pivot) item
		
		while(true){
			
			while(leftPointer < right && array[leftPointer] < pivot){//"leftPointer < right && " can be removed, because pivot is array[right]. Faster
				leftPointer++;
			}
			
			while(rightPointer > left && array[rightPointer] > pivot){
				rightPointer --;
			}
			
			if(leftPointer == rightPointer){//pointer meet
				System.out.println("Pivot " + pivot + " index is " + leftPointer);
				break;
			}
			else if(leftPointer > rightPointer){//pointer cross
				System.out.println("Pivot " + pivot + " not found");
				break;
			}
			else{
				swap(array, leftPointer, rightPointer);
			}
		}		
		swap(array, leftPointer, right);//leftPointer meet rightPointer, or already cross right pointer
		return leftPointer;
	}
	
	public static void partition(int[] array, int left, int right, int pivot){
		int leftPointer = left;
		int rightPointer = right;
		
		while(true){
			
			while(leftPointer < right && array[leftPointer] < pivot){
				leftPointer++;
			}
			
			while(rightPointer > left && array[rightPointer] > pivot){
				rightPointer --;
			}
			
			if(leftPointer == rightPointer){//pointer meet
				System.out.println("Pivot " + pivot + " index is " + leftPointer);
				break;
			}else if(leftPointer > rightPointer){//pointer cross
				System.out.println("Pivot " + pivot + " not found. It should between index " + rightPointer + "-" + leftPointer);
				break;
			}else{
				swap(array, leftPointer, rightPointer);
			}
		}
	}
	
	public static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
