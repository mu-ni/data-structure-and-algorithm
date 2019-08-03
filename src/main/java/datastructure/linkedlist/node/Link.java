package datastructure.linkedlist.node;

public class Link {
	
	private String data;
	private int number;
	
	public Link next;
	
	public Link(String data){
		this.data = data;
	}

	public Link(int number){
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
		System.out.println("Link data: " + data + ", Link number: " + number);
	}
}
