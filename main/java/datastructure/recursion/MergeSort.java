package datastructure.recursion;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] array = {9,7,5,8,12,78,24,15,6,3};
		System.out.println(Arrays.toString(array));
		
		mergeSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
		
		int[] arrayA = {1,3,4,8};
		int[] arrayB = {0,2,5,6,7,9};
		System.out.println(Arrays.toString(merge(arrayA, arrayB)));
	}

	public static int[] mergeSort(int[] array, int low, int high){//O(nlogn)
		
		int mid = (low+high)/2;
		if(low < high){
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge(array, low, mid, high);
		}else{}
		return array;		
	}
	
	private static void merge(int[] array, int low, int mid, int high){
		
		int n = high - low +1;
		int[] workspace = new int[n];
		
		int leftPointer = low;
		int rightPointer = mid +1;
		
		int k = 0;
		
		while(leftPointer <= mid && rightPointer <= high){
			if(array[leftPointer] < array[rightPointer]){
				workspace[k++] = array[leftPointer++];
			}else{
				workspace[k++] = array[rightPointer++];
			}
		}
		
		while(leftPointer <= mid){
			workspace[k++] = array[leftPointer++];
		}
		
		while(rightPointer <= high){
			workspace[k++] = array[rightPointer++];
		}

		for(int i=0; i< n; i++){
			array[low + i] = workspace[i];
		}
	}
	
	public static int[] merge(int[] arrayA, int[] arrayB){// merge 2 sorted arrays
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		
		int aSize = arrayA.length;
		int bSize = arrayB.length;
		
		int[] arrayC = new int[aSize + bSize];
		
		while(aIndex < aSize && bIndex < bSize){
			if(arrayA[aIndex] < arrayB[bIndex]){
				arrayC[cIndex++] = arrayA[aIndex++];
			}else{
				arrayC[cIndex++] = arrayB[bIndex++];
			}
		}
		
		while(aIndex < aSize){
			arrayC[cIndex++] = arrayA[aIndex++];
		}
		
		while(bIndex < bSize){
			arrayC[cIndex++] = arrayB[bIndex++];
		}
		
		return arrayC;
	}

}
