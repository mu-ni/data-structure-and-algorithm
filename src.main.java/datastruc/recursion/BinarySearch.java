package datastruc.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArray = {1,2,3,4,5,6,7,8,9};
		binarySearch(sortedArray, 8, 0, sortedArray.length-1);
	}

	public static int binarySearch(int[] array, int searchKey, int low, int upper){
		if(low > upper){
			System.out.println("Not found");
			return -1;
		}
		if(searchKey == array[(low + upper)/2]){
			System.out.println("Key index = " + (low + upper)/2);
			System.out.println("Key = " + array[(low + upper)/2]);
			return (low + upper)/2;
		}else if(searchKey > array[(low + upper)/2]){
			return binarySearch(array, searchKey, (low + upper)/2+1, upper);
		}else{
			return binarySearch(array, searchKey, 0, (low + upper)/2-1);
		}
	}
}
