package cluedo;

class Node{
	int data;
	Node next;
	Node previous;
	
	public Node(int data) {
		this.data = data;
	}
}

public class DoublyLinkedList {
	Node head = null;
	Node tail = null;
	
	public void add(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = tail = newNode;
			
			head.previous = null;
			tail.next = null;
		}
		else {
			tail.next = newNode;
			
			newNode.previous = tail;
			
			tail = newNode;
			
			tail.next = null;
		}
	}
	public Node delete(Node delete)
	    {
	        if (head == null || delete == null)
	            return null;
	 
	        if (head == delete)
	            head = delete.next;
	 
	        if (delete.next != null)
	        	delete.next.previous = delete.previous;
	 
	        if (delete.previous != null)
	        	delete.previous.next = delete.next;
	 
	        delete = null;
	 
	        return head;
    }
	
	public void deleteNodeAtGivenPos(int n)
    {
        if (head == null || n < 0)
            return;
 
        Node current = head;
        int i;
 
        for (i = 0; current != null && i < n; i++)
        {
            current = current.next;
        }
        
        if (current == null)
            return;
 
        delete(current);
    }
	
	public void traverse() {
		Node current = head;
				
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		while(current != null) {
			System.out.println(current.data);
			
			current = current.next;
		}
	}
	
	public int listSize() {
		Node current = head;
		int count = 0;
		
		while(current != null) {
			count++;
			current = current.next;
		}
		
		return count;
	}
	
	public int get(int value) {
		Node current = head;
		int length = 0;
		
		while(current != null) {
			if(length == value)
				return current.data;
			length++;
			current = current.next;
		}
		return tail.data;
	}
	
}
