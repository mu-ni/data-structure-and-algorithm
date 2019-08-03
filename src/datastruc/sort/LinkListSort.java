package datastruc.sort;

import java.util.Arrays;

import datastruc.linkedlist.SortedList;
import datastruc.linkedlist.node.Link;

public class LinkListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {14,56,21,9,16,50,12,18,90};
		linkListSort(array);
		System.out.println(Arrays.toString(array));		
	}

	public static void linkListSort(int[] array){

		SortedList linkList = new SortedList();
		
		for(int a: array){
			linkList.insert(new Link(a));
		}
		
		linkList.displayList();
		
		Link current = linkList.first;
		for(int i=0; i<array.length; i++){
			array[i] = current.getNumber();
			current = current.next;
		}		
	}
}
