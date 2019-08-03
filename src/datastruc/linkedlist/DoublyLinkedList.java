package datastruc.linkedlist;

import datastruc.linkedlist.node.DoublyLink;

public class DoublyLinkedList {
	
	private DoublyLink first;
	private DoublyLink last;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(DoublyLink doublyLink){
		if(isEmpty()){
			last = doublyLink;
		}else{
			first.prev = doublyLink;
			doublyLink.next = first;
		}
		first = doublyLink;
	}
	
	public void insertLast(DoublyLink doublyLink){
		if(isEmpty()){
			first = doublyLink;
		}else{
			last.next = doublyLink;
			doublyLink.prev = last;
		}
		last = doublyLink;
	}
	
	public DoublyLink deleteFirst(){
		DoublyLink temp = first;
		
		if(first.next == null){
			last = null;
		}else{
			first.next.prev = null;
		}
		first = first.next;
		return temp;
	}
	
	public DoublyLink deleteLast(){
		DoublyLink temp = last;
		
		if(last.prev == null){
			first = null;
		}else{
			last.prev.next = null;
		}
		last = last.prev;
		return temp;
	}
	
	public boolean insertBefore(DoublyLink doublyLink, DoublyLink newLink){
		DoublyLink current = first;
		
		if(isEmpty()){
			return false;
		}
		
		while(current.getData() != doublyLink.getData()){
			current = current.next;
			if(current == null){
				return false;//not found
			}
		}
		
		if(current == first){
			first = newLink;
			newLink.prev = null;
			newLink.next = first.next;
			first.next = newLink;
		}else{
			newLink.prev = current.prev;	
			current.prev.next = newLink;		
		}
		newLink.next = current;
		current.prev = newLink;
		
		return true;
	}
	
	public boolean insertAfter(DoublyLink doublyLink, DoublyLink newLink){
		DoublyLink current = first;
		
		if(isEmpty()){
			return false;
		}
		
		while(current.getData() != doublyLink.getData()){
			current = current.next;
			if(current == null){
				return false;//not found
			}
		}
		
		if(current == last){
			newLink.next = null;
			last = newLink;
		}else{
			newLink.next = current.next;
			current.next.prev = newLink;
		}
		newLink.prev = current;
		current.next = newLink;
		
		return true;
	}
	
	public DoublyLink delete(DoublyLink doublyLink){
		DoublyLink current = first;
		
		if(isEmpty()){
			return null;
		}
		
		while(current.getData() != doublyLink.getData()){
			current = current.next;
			if(current == null){
				return null;//not found
			}
		}
		
		if(current == first){
			first = first.next;
		}else if(current == last){
			last = last.prev;
		}else{
			current.next.prev = current.prev;
			current.prev.next = current.next;
		}
		
		return current;
	}

	public void displayForward(){
		System.out.print("Display DoublyLinkedList(first -> last): ");
		DoublyLink current = first;
		while(current != null){
			System.out.print(current.getData() + " -> ");
			current = current.next;
		}
		System.out.println("");
	}
	
	public void displayBackward(){
		System.out.print("Display DoublyLinkedList(last -> first): ");
		DoublyLink current = last;
		while(current != null){
			System.out.print(current.getData() + " -> ");
			current = current.prev;
		}
		System.out.println("");
	}
	
	
}
