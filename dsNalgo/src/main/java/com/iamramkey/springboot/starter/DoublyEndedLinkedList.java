package com.iamramkey.springboot.starter;

public class DoublyEndedLinkedList {

	public Node head;
	public Node tail;

	public void insertAtTail(int data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			this.tail = this.head = newNode;
		}
		if (this.tail != null) {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	

	@Override
	public String toString() {
		String result = "{";
		Node current = this.head;
		while (current != null) {
			result += current.toString() + ", ";
			current = current.getNext();
		}
		result += "}";
		return result;
	}
	
	public static void main(String[] args) {
		DoublyEndedLinkedList ll = new DoublyEndedLinkedList();
		ll.insertAtTail(10);
		ll.insertAtTail(9);
		ll.insertAtTail(8);
		ll.insertAtTail(7);
		
		System.out.println(ll);
	}
}
