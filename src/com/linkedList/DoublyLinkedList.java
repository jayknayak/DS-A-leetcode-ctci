package com.linkedList;

public class DoublyLinkedList {
	Node head;

	static private class Node{
		Node next;
		Node prev;
		int data;
		public Node(int data) {
			this.data=data;
		}
	}

	public Node initializeLinkedList (int data) {
		head=new Node(data);
		return head;
	}
	//appending an element at the end of linked list
	public void appendAtTail (int data) {
		if(head==null) {
			initializeLinkedList(data);
			return;
		}
		Node current=head;
		while (current.next!=null) {
			current=current.next;
		}
		current.next=new Node(data);
		current.next.prev=current;
	}
	//prepending an element before the head node
	public void prepend(int data) {
		if(head==null) {
			initializeLinkedList(data);
			return;
		}
		Node newHead=new Node(data);
		head.prev=newHead;
		newHead.next=head;
		head=newHead;
	}
	//inserting element at a specified index
	public void appendAt (int index, int data) {
		if(head==null) {
			return;
		}
		Node newNode=new Node(data);
		if(index==0) {
			head.prev=newNode;
			newNode.next=head; 
			head= newNode;
		}
		else {
			Node current=head;
			for (int i=0; i<index-1; i++) {
				current=current.next;
			}
			current.next.prev=newNode;
			newNode.next=current.next;
			newNode.prev=current;
			current.next=newNode;
		}
	}
	//deleting a specific element by value in the linked list
	public void deleteWithValue (int data) {
		if(head==null) {
			return;
		}
		if(head.data==data) {
			head=head.next;
			head.prev=null;
			return;
		}
		Node current = head;
		while(current.next!=null) {
			if(current.next.data==data) {
				current.next=current.next.next;
				current.next.prev=current;
				return;
			}
			current=current.next;
		}
	}
	//deleting a specific element by index in the linked list
	public void deleteWithIndex (int index) {
		if(head==null) {
			return;
		}
		if(index==0) {
			head=head.next;
			head.prev=null;
		}
		else {
			Node current = head;
			for (int i=0; i<index-1;i++) {
				current=current.next;
			}
			if(current.next!=null) {
				current.next=current.next.next;
				current.next.prev=current;
			}
		}
	}
	public void showLinkedList() {
		if(head==null) {
			return;
		}
		Node current = head;
		System.out.println("Forward Doubly Linked List:");
		while(current.next!=null) {
			System.out.println(current.data);
			current=current.next;
		}
		System.out.println(current.data);
	}
	public void showReversedLinkedList() {
		if(head==null) {
			return;
		}
		Node current = head;
		System.out.println("Reversed Doubly Linked List:");
		while(current.next!=null) {
			current=current.next;
		}
		while(current!=null) {
			System.out.println(current.data);
			current=current.prev;
		}
	}
}

