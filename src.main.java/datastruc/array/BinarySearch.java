package datastruc.array;


public class BinarySearch {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[] sortedArray = {1,2,3,4,5,6,7,8,9};
		int index = binarySearch(sortedArray, 100);
		System.out.println(index);
	}

	public static int binarySearch(int[] sortedArray, int searchKey){
		
		int low = 0;
		int high = sortedArray.length - 1;
		int index;
		
		while(true){
			index = (low + high)/2;
			
			if(low > high){
				System.out.println("NOT FOUND");
				return sortedArray.length;
			}
			
			if(sortedArray[index] == searchKey){
				return index;
			}
			
			if(sortedArray[index] > searchKey){
				high = index-1;
			}
			
			if(sortedArray[index] < searchKey){
				low = index+1;
			}
		}
		
	}
}
