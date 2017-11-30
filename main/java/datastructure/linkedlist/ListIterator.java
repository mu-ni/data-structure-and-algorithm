package datastructure.linkedlist;

import datastructure.linkedlist.node.Link;

public class ListIterator {

	private Link current;
	private Link previous;
	private LinkList list;
	
	public ListIterator(LinkList list){
		this.list = list;
		reset();
	}

	public void reset(){
		current = list.getFirst();
		previous = null;
	}
	
	public void nextLink(){
		previous = current;
		current = current.next;
	}
	
	public Link getCurrent(){
		return current;
	}
	
	public boolean atEnd(){
		return current.next == null;
	}
	
	public void insertBefore(Link newLink){
		if(previous == null){
			newLink.next = list.getFirst();
			list.setFirst(newLink);
			reset();
		}else{
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;
		}
	}
	
	public void insertAfter(Link newLink){
		if(list.isEmpty()){
			list.setFirst(newLink);
			current = newLink;
		}else{
			newLink.next = current.next;
			current.next = newLink;
			nextLink();
		}
	}
	
	public Link deleteCurrent(){
		Link temp = current;
		if(previous == null){
			list.setFirst(current.next);
			reset();
		}else{
			previous.next = current.next;
			if(atEnd()){
				reset();
			}else{
				current = current.next;
			}
		}
		
		return temp;
	}
}
