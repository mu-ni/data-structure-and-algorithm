package datastruc.sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {10,20,15,0,6,   7,2,1,-5,55};
		System.out.println(Arrays.toString(array));
		
		shellSort(array, 3);
		System.out.println(Arrays.toString(array));
	}

	public static void shellSort(int[] array, int blockNumber){//O(n*(logn)^2)	
		int h = 1;
		while(h <= array.length/blockNumber){
			h = h*blockNumber +1;
		}
		
		while(h > 0){
			for(int i=h; i<array.length; i++){
				int temp = array[i];
				int j = i;
				while(j > h-1 && array[j-h] >= temp){
					array[j] = array[j-h];
					j -= h;
				}
				array[j] = temp;
			}
			h = (h-1)/blockNumber;
		}
	}

}
