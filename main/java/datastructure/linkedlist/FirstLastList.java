package datastructure.linkedlist;

import datastructure.linkedlist.node.Link;

public class FirstLastList {

	private Link first;
	private Link last;
	
	public boolean isEmpty(){
		return first == null;
	}

	public void insertFirst(Link newLink){
		if(isEmpty()){
			last = newLink;
		}		
		newLink.next = first;
		first = newLink;		
	}
	
	public void insertLast(Link newLink){
		if(isEmpty()){
			first = newLink;
		}else{
			last.next = newLink;
		}	
		last = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		if(first.next == null){
			last = null;
		}		
		first = first.next;
		return temp;//deleted link
	}
	
//	public Link deleteLast(){//no pointer point to the count down second
//	}
	
	public void displayList(){
		System.out.print("Display FirstLastList(first -> last): ");
		Link current = first;
		while(current != null){
//			current.displayLink();
			System.out.print(current.getData() + " -> ");
			current = current.next;
		}
		System.out.println("");
	}

}
