package com.iamramkey.springboot.starter;

public class LinkedList {

	private Node head;

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.setNext(this.head);
		this.head = newNode;
	}

	public int length() {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}

	public void deleteFromHead() {
		Node itemNextToHead = this.head.getNext();
		this.head.setNext(null);
		this.head = itemNextToHead;
	}
	
	public Node find(int data) {
		Node current = this.head;
		while(current != null) {
			if(current.getData() == data) {
				return current;
			}
			current = current.getNext();
		}
		return null;
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
		LinkedList ll = new LinkedList();
		ll.insertAtHead(10);
		ll.insertAtHead(20);
		ll.insertAtHead(30);
		ll.insertAtHead(40);
		ll.insertAtHead(50);
		ll.insertAtHead(60);
		ll.insertAtHead(70);
		ll.insertAtHead(80);
		System.out.println(ll);
	}
}

class Node {
	private int data;
	private Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "data= " + data;
	}

}