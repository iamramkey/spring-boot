package com.iamramkey.springboot.starter;

public class DoublyLinkedList {
	private DoubleLinkedNode head;

	public void insertAtHead(int data) {
		DoubleLinkedNode newNode = new DoubleLinkedNode(data);
		newNode.setNext(this.head);
		if (this.head != null) {
			this.head.setPrev(newNode);
		}
		this.head = newNode;
	}
	
	public int length() {
		int length = 0;
		DoubleLinkedNode current = this.head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}
	
	public DoubleLinkedNode find(int data) {
		DoubleLinkedNode current = this.head;
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
		DoubleLinkedNode current = this.head;
		while (current != null) {
			result += current.toString() + ", ";
			current = current.getNext();
		}
		result += "}";
		return result;
	}
	
}

class DoubleLinkedNode {
	private int data;
	private DoubleLinkedNode next;
	private DoubleLinkedNode prev;

	DoubleLinkedNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoubleLinkedNode getNext() {
		return next;
	}

	public void setNext(DoubleLinkedNode next) {
		this.next = next;
	}

	public DoubleLinkedNode getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedNode prev) {
		this.prev = prev;
	}

}