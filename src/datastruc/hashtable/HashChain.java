package datastruc.hashtable;

import datastruc.linkedlist.SortedList;
import datastruc.linkedlist.node.Link;
public class HashChain {
	
	private SortedList[] hashArray;
	private int arraySize;

	public HashChain(int size){
		this.arraySize = size;
		this.hashArray = new SortedList[size];
		for(int i=0;i<size;i++){
			hashArray[i] = new SortedList();
		}
	}
	
	private int hashFunc(int id){
		return id%arraySize;
	}
	
	public void insert(Link link){
		int hashVal = hashFunc(link.getNumber());
		hashArray[hashVal].insert(link);
	}
	
	public Link delete(Link link){
		int hashVal = hashFunc(link.getNumber());
		return hashArray[hashVal].delete(link);
	}
	
	public Link find(int key){
		int hashVal = hashFunc(key);
		return hashArray[hashVal].find(key);
	}
	
	public void displayHashChain(){
		for(int i=0;i<arraySize;i++){
			System.out.print(i + ". ");
			hashArray[i].displayList();
		}
	}
}
