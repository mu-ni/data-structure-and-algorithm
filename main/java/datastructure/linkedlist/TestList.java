package datastructure.linkedlist;

import datastructure.linkedlist.node.DoublyLink;
import datastructure.linkedlist.node.Link;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testLinkList();
//		testFirstLastList();
//		testSortedList();
		testDoublyLinkedList();
	}
	
	public static void testLinkList(){
		System.out.println("Test Link List:");
		
		Link link1 = new Link("Hello1");
		Link link2 = new Link("Hello2");
		Link link3 = new Link("Hello3");
		Link link4 = new Link("Hello4");
		
		LinkList list = new LinkList();
		list.insertFirst(link1);
		list.insertFirst(link2);
		list.insertFirst(link3);
		list.insertFirst(link4);
		
		list.displayList();
		
		System.out.println("Looking for Link: " + link2.getData());
		Link foundLink = list.find(link2);
		System.out.println("Found link: " + foundLink.getData());

		System.out.println("Delete Link: " + link3.getData());
		Link deletedLink = list.delete(link3);
		if(deletedLink == null){
			System.out.println("Deleted Link: Not exist");
		}else{
			System.out.println("Deleted link: " + deletedLink.getData());
		}
		
		list.displayList();
	}

	public static void testFirstLastList(){
		System.out.println("Test First Last List:");
		
		Link link1 = new Link("Hello1");
		Link link2 = new Link("Hello2");
		Link link3 = new Link("Hello3");
		Link link4 = new Link("Hello4");
		
		FirstLastList list = new FirstLastList();
		list.insertFirst(link1);
		list.insertFirst(link2);
		list.insertLast(link3);
		list.insertLast(link4);
		
		list.displayList();
		
		System.out.println("Delete the first link:");
		Link deletedLink = list.deleteFirst();
		if(deletedLink == null){
			System.out.println("Deleted Link: Not exist");
		}else{
			System.out.println("Deleted link: " + deletedLink.getData());
		}
		
		list.displayList();		
	}
	
	public static void testSortedList(){
		System.out.println("Test Sorted List:");
		
		Link link1 = new Link(12);
		Link link2 = new Link(9);
		Link link3 = new Link(7);
		Link link4 = new Link(52);
		Link link5 = new Link(46);

		Link link6 = new Link(18);
		
		SortedList list = new SortedList();
		list.insert(link1);
		list.insert(link2);
		list.insert(link3);
		list.insert(link4);
		list.insert(link5);
		
		list.displayList();
		
		System.out.println("Delete link:" + link3.getNumber());
		Link deletedLink = list.delete(link3);
		if(deletedLink == null){
			System.out.println("Deleted Link: Not exist");
		}else{
			System.out.println("Deleted Link: " + deletedLink.getNumber());
		}
		
		
		list.displayList();	
		
		System.out.println("Delete link:" + link6.getNumber());
		Link deletedNotExistLink = list.delete(link6);
		if(deletedNotExistLink == null){
			System.out.println("Deleted Link: Not exist");
		}else{
			System.out.println("Deleted Link: " + deletedNotExistLink.getNumber());
		}		
		
		list.displayList();		
	}
	
	public static void testDoublyLinkedList(){
		System.out.println("Test Doubly Linked List:");
		
		DoublyLink link1 = new DoublyLink("Hello1");
		DoublyLink link2 = new DoublyLink("Hello2");
		DoublyLink link3 = new DoublyLink("Hello3");
		DoublyLink link4 = new DoublyLink("Hello4");
		
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertFirst(link1);
		list.insertFirst(link2);
		list.insertLast(link3);
		list.insertLast(link4);
		
		list.displayForward();
		list.displayBackward();
		
		System.out.println("Insert link before:" + link2.getData());
		list.insertBefore(link2, new DoublyLink("before"));
		
		list.displayForward();
		
		System.out.println("Insert link after:" + link2.getData());
		list.insertAfter(link2, new DoublyLink("after"));
		
		list.displayForward();
		
		System.out.println("Delete Link: " + link3.getData());
		DoublyLink deletedLink = list.delete(link3);
		if(deletedLink == null){
			System.out.println("Deleted Link: Not exist");
		}else{
			System.out.println("Deleted link: " + deletedLink.getData());
		}
		
		list.displayForward();
	}
	
	
}
