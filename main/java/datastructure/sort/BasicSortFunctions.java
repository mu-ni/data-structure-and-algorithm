package datastructure.sort;

public class BasicSortFunctions {

	public static void main(String[] args) {
		/**
		 * https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
		 */
		
		// TODO Auto-generated method stub
		int[] numbers = {10,20,15,0,6,7,2,1,-5,55};
		
//		int[] rst = selectionSort(numbers);//n^2
//		int[] rst = bubbleSort(numbers);//n^2
//		int[] rst = insertSort(numbers);//n^2
		
//		for(int i=0; i<numbers.length; i++){
//			System.out.print(numbers[i] + ",");
//		}

		quickSort(numbers, 0, numbers.length-1);//nlogn
		for(int i=0; i<numbers.length; i++){
			System.out.print(numbers[i] + ",");
		}
	}
	
	public static void selectionSort(int[] array){
		for(int i=0; i<array.length; i++){
			int minIndex = i;
			for(int j=i+1; j<array.length; j++){
				if(array[minIndex] > array[j]){
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}
	
	public static int[] bubbleSort(int[] array){
		
		for(int i=0; i<array.length-1; i++){
			for(int j=0; j<array.length-1-i; j++){
				if(array[j]>array[j+1]){
					swap(array, j, j+1);
				}				
			}
		}		
		return array;		
	}
	
	public static int[] insertSort(int[] array){
		
		for(int i=1;i<array.length;i++){
			for(int j=i; j>0; j--){
				if(array[j] < array[j-1]){
					swap(array, j-1, j);
				}
			}
		}
		return array;	
	}
	
	public static void quickSort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];        
        
        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
               start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        if(start>low) quickSort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) quickSort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }
	
	public static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}


}
