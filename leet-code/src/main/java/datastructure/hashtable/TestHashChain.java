package datastructure.hashtable;

import datastructure.linkedlist.node.Link;

public class TestHashChain {

	public static void main(String[] args) {

		int[] array = {49,57,82,34,75,92,26,33,15,64,1};
		HashChain hashChain = new HashChain(11);//prime
		
		System.out.println("Insert 11 numbers into hashchain:");
		for(int i : array){
			Link link = new Link(i);
			hashChain.insert(link);
		}		
		hashChain.displayHashChain();

		System.out.println("Looking for 26:");
		Link link = hashChain.find(26);
		System.out.println(link.getNumber() + " found");
		
		System.out.println("Delete 75:");
		Link delLink = hashChain.delete(new Link(75));
		System.out.println(delLink.getNumber() + " deleted");
		hashChain.displayHashChain();
	}

}
