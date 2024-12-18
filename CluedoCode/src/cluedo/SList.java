package cluedo;

public class SList {
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node head = null;
	Node tail = null;
	
	public void addNode(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = tail = newNode;
			tail.next = null;
			
		}
		else {
			tail.next = newNode;
			tail = newNode;
			tail.next = null;
		}
	}
	
	public void deleteNode(int data) {
		
	}
	
	public void display() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			
			current = current.next;
		}
	}
	public boolean traverse(int data, int bound) {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			
			current = current.next;
		}
		return true;
	}
}