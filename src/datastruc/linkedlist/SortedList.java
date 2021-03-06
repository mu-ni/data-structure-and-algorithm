package datastruc.linkedlist;

import datastruc.linkedlist.node.Link;

public class SortedList {

	public Link first;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insert(Link newLink){
		Link current = first;
		Link previous = null;
		
		while(current != null && newLink.getNumber() > current.getNumber()){
			previous = current;
			current = current.next;
		}
		
		if(previous == null){
			first = newLink;
		}else{
			previous.next = newLink;
		}
		
		newLink.next = current;		
	}
	
	public Link delete(Link link){
		Link current = first;
		Link previous = null;
		
		while(current.getNumber() != link.getNumber()){
			if(current.next == null){
				return null;//not found
			}else{
				previous = current;
				current = current.next;
			}
		}
		
		if(current == first){
			first = first.next;
		}else{
			previous.next = current.next;
		}
		
		return current;
	}
	
	public Link find(int key){
		Link current = first;
		
		while(current != null && current.getNumber() <= key){
			if(current.getNumber() == key){
				return current;
			}else{
				current = current.next;
			}
		}
		return null;//not found
	}
	
	public void displayList(){
		System.out.print("Display SortedList(small -> big): ");
		Link current = first;
		while(current != null){
//			current.displayLink();
			System.out.print(current.getNumber() + " -> ");
			current = current.next;
		}
		System.out.println("");
	}	

}
