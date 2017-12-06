package datastructure.hashtable;

public class TestHashTable {

	public static void main(String[] args) {

		int[] array = {49,57,82,34,75,92,26,33,15,64};
		
		testOpenAddressHashTable(array);
		testReHashHashTable(array);
	}
	
	public static void testOpenAddressHashTable(int[] array){
		System.out.println("Test HashTable1 with linear detection function");
		HashTable1 hashTable = new HashTable1(19);//prime
		
		System.out.println("Insert 10 numbers into hashtable1:");
		for(int i : array){
			DataItem item = new DataItem(i);
			hashTable.insert(item);
		}		
		hashTable.displayTable();
		
		System.out.println("Looking for 26:");
		DataItem findtItem = hashTable.find(26);
		System.out.println(findtItem.getId() + " found");
		
		System.out.println("Delete 75:");
		DataItem deltItem = hashTable.delete(75);
		System.out.println(deltItem.getId() + " deleted");
		hashTable.displayTable();
	}
	
	public static void testReHashHashTable(int[] array){
		System.out.println("Test HashTable2 with re-hash function");
		HashTable2 hashTable = new HashTable2(19, 11);//prime
		
		System.out.println("Insert 10 numbers into hashtable2:");
		for(int i : array){
			DataItem item = new DataItem(i);
			hashTable.insert(item);
		}		
		hashTable.displayTable();
		
		System.out.println("Looking for 26:");
		DataItem findtItem = hashTable.find(26);
		System.out.println(findtItem.getId() + " found");
		
		System.out.println("Delete 75:");
		DataItem deltItem = hashTable.delete(75);
		System.out.println(deltItem.getId() + " deleted");
		hashTable.displayTable();
	}

}
