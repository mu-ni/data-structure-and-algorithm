package datastruc.hashtable;

public class HashTable1 {//Open Address: linear detection
	
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public HashTable1(int size){
		this.arraySize = size;
		this.hashArray = new DataItem[size];
		this.nonItem = new DataItem(-1);
	}
	
	private int hashFunc(int id){
		return id%arraySize;
	}
	
	public DataItem find(int id){
		//assumes table is not full
		
		int hashVal = hashFunc(id);
		
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getId() == id){
				return hashArray[hashVal];
			}else{
				hashVal ++;
				hashVal = hashFunc(hashVal);
			}
		}
		
		return null;//can't find item
	}
	
	public void insert(DataItem dataItem){
		//assumes table is not full
		
		int id = dataItem.getId();
		int hashVal = hashFunc(id);
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getId() != -1){
			hashVal ++;
			hashVal = hashFunc(hashVal);
		}
		
		hashArray[hashVal] = dataItem;		
	}
	
	public DataItem delete(int id){
		
		int hashVal = hashFunc(id);
		
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getId() == id){
				DataItem delItem = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return delItem;
			}else{
				hashVal ++;
				hashVal = hashFunc(hashVal);
			}
		}
		
		return null;//can't find item
	}
	
	public void displayTable(){
		System.out.print("HashTable1: ");
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
