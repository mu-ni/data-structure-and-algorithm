package test;

import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {17,6,8,92,45,34,61,72,59,23,16};		
		new TestSort().quickSort(array1, 0, array1.length-1);
		System.out.println("Quick Sort: " + Arrays.toString(array1));
		
		int[] array2 = {17,6,8,92,45,34,61,72,59,23,16};
		new TestSort().bubbleSort(array2);
		System.out.println("Bubble Sort: " + Arrays.toString(array2));

		int[] array3 = {17,6,8,92,45,34,61,72,59,23,16};
		new TestSort().selectionSort(array3);
		System.out.println("Selection Sort: " + Arrays.toString(array3));
		
		int[] array4 = {17,6,8,92,45,34,61,72,59,23,16};
		new TestSort().insertSort(array4);
		System.out.println("Insert Sort: " + Arrays.toString(array4));
	}
	
	public void quickSort(int[] array, int left, int right) {
		if(right - left < 1) {
			return;
		}else {
			int pivot = array[right];
			int partition = partition(array, left, right, pivot);
			quickSort(array, left, partition - 1);
			quickSort(array, partition + 1, right);
		}		
	}
	
	private int partition(int[] array, int left, int right, int pivot) {
		int leftPointer = left;
		int rightPointer = right - 1;
		
		while(true) {
			while(leftPointer < right && array[leftPointer] < pivot) {
				leftPointer++;
			}
			while(rightPointer > left && array[rightPointer] > pivot) {
				rightPointer--;
			}
			
			if(leftPointer == rightPointer) {
				break;
			}else if(leftPointer > rightPointer) {
				break;
			}else {
				swap(array, leftPointer, rightPointer);
			}
		}
		swap(array, leftPointer, right);
		return leftPointer;
	}
	
	public void bubbleSort(int[] array) {		
		for(int i=0; i< array.length; i++) {
			for(int j=i; j< array.length-i; j++) {//array.length-i
				if(array[i] > array[j]) {
					swap(array, i, j);
				}
			}
		}
	}
	
	public void selectionSort(int[] array) {		
		for(int i=0; i< array.length; i++) {
			int minIndex = i;
			for(int j=i+1; j< array.length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				swap(array, i, minIndex);				
			}
		}
	}
	
	public void insertSort(int[] array) {		
		for(int i=0; i< array.length; i++) {
			for(int j=i; j>0; j--) {
				if(array[j] < array[j-1]) {
					swap(array, j, j-1);
				}
			}
		}
	}
	
	private void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

}
