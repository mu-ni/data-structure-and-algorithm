package datastruc.hashtable;

public class HashTable2 {//Open Address:re-hash
	
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	private int constant;
	//private stepSize = constant - (id%constant);//stepSize from 1 to 5

	public HashTable2(int size, int constant){
		this.arraySize = size;
		this.constant = constant;
		this.hashArray = new DataItem[size];
		this.nonItem = new DataItem(-1);
	}
	
	private int hashFunc1(int id){
		return id%arraySize;
	}
	
	private int hashFunc2(int id){
		return constant - id%constant;
	}
	
	public DataItem find(int id){
		//assumes table is not full
		
		int hashVal = hashFunc1(id);
		int stepSize = hashFunc2(id);
		
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getId() == id){
				return hashArray[hashVal];
			}else{
				hashVal += stepSize;
				hashVal = hashFunc1(hashVal);
			}
		}
		
		return null;//can't find item
	}
	
	public void insert(DataItem dataItem){
		//assumes table is not full
		
		int id = dataItem.getId();
		int hashVal = hashFunc1(id);
		int stepSize = hashFunc2(id);
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getId() != -1){
			hashVal += stepSize;
			hashVal = hashFunc1(hashVal);
		}
		
		hashArray[hashVal] = dataItem;		
	}
	
	public DataItem delete(int id){

		int hashVal = hashFunc1(id);
		int stepSize = hashFunc2(id);
		
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getId() == id){
				DataItem delItem = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return delItem;
			}else{
				hashVal += stepSize;
				hashVal = hashFunc1(hashVal);
			}
		}
		
		return null;//can't find item
	}
	
	public void displayTable(){
		System.out.print("HashTable2: ");
		for(DataItem dataItem : hashArray){
			if(dataItem != null){
				System.out.print(dataItem.getId() + " ");
			}else{
				System.out.print("-- ");
			}
		}
		System.out.println();
	}
}
