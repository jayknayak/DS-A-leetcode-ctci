package com.linkedList;

public class CircularLinkedList {
	Node tail;

	private static class Node{
		Node next;
		int data;
		public Node (int data) {
			this.data=data;
		}
		/*
		 * public Node getNext() { return next; } public void setNext (Node next) {
		 * this.next=next; }
		 */
	}
	int size = 0;
	//Add First element in linked list
	public void addFirstElement (int data) {
		tail = new Node (data);
		tail.next=tail;
		size++;
		return;
	}
	public void appendAtTail (int data) {
		if(size==0) {
			addFirstElement(data);
			return;
		}
		//		newNode.setNext(tail.getNext());
		//		tail.setNext(newNode);
		//		tail=tail.getNext();
		Node newNode = new Node (data);
		newNode.next=tail.next;
		tail.next=newNode;
		tail=newNode;
		size++;
	}

	//prepending an element before the head node
	public void prepend(int data) {
		if(size==0) {
			addFirstElement(data);
			return;
		}
		Node newNode=new Node(data);
		newNode.next=tail.next;
		tail.next=newNode;
		size++;
	}
	//inserting element at a specified index
	public void appendAt (int index, int data) {
		if(size==0) {
			addFirstElement(data);
			return;
		}
		if(index==0) {
			prepend(data);
		}
		else {
			Node newNode=new Node(data);
			Node current = tail.next;
			for(int i=0; i<index-1; i++) {
				current = current.next;
			}
			newNode.next=current.next;
			current.next=newNode;
			size++;
			return;
		}
	}

	//deleting a specific element by value in the linked list
	public void deleteWithValue (int data) {
		if (size==0) {
			return;
		}
		if(tail.next.data==data) {
			tail.next=tail.next.next;
			size--;
			return;
		}
		Node current = tail.next;
		for (int i=0; i<size; i++) {
			if(current.next.data==data) {
				current.next=current.next.next;
				size--;
				return;
			}
			current = current.next;
		}

	}

	public void showLinkedList() {
		System.out.println("Circular Linked List:");
		if(size==0) {
			return;
		}
		Node current = tail.next;
		for (int i=0; i<size;i++) {
			System.out.println(current.data);
			current=current.next;
		}
	}
}
