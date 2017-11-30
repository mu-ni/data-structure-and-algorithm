package datastructure.linkedlist;

import datastructure.linkedlist.node.Link;

public class LinkList {

	private Link first;
	
	public boolean isEmpty(){
		return first == null;
	}

	public Link getFirst(){
		return first;
	}
	
	public void setFirst(Link link){
		first = link;
	}
	
	public void insertFirst(Link newLink){
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;//deleted link
	}
	
	public Link find(Link link){//compare data value
		Link current = first;
		while(current.getData() != link.getData()){
			if(current.next == null){
				return null;//not found
			}else{
				current = current.next;
			}			
		}		
		return current;
	}
	
	public Link delete(Link link){
		Link current = first;
		Link previous = first;
		while(current.getData() != link.getData()){
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
	
	public ListIterator getIterator(){
		return new ListIterator(this);
	}
	
	public void displayList(){
		System.out.print("Display LinkList(first -> last): ");
		Link current = first;
		while(current != null){
//			current.displayLink();
			System.out.print(current.getData() + " -> ");
			current = current.next;
		}
		System.out.println("");
	}
}
