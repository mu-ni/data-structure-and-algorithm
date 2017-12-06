package datastructure.linkedlist.node;

public class DoublyLink {

	private String data;
	private int number;
	
	public DoublyLink prev;
	public DoublyLink next;
	
	public DoublyLink(String data){
		this.data = data;
	}

	public DoublyLink(int number){
		this.number = number;
	}
	
	public String getData() {
		return data;
	}


//	public void setData(String data) {
//		this.data = data;
//	}
	

	public int getNumber() {
		return number;
	}


//	public void setNumber(int number) {
//		this.number = number;
//	}


	public void displayLink(){
		System.out.println("Doubly Link data: " + data + ", Link number: " + number);
	}
	
}
