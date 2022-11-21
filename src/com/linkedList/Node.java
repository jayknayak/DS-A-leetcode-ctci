package com.linkedList;

public class Node {
	Node next;
	//		Node prev;
	int data;
	public Node(int data) {
		this.data=data;
	}
	public static void main(String[] args){
		LinkedList linkedList=new LinkedList();
// Basic implementation of Doubly linked list
		//		linkedList.appendAtTail(4);
		//		linkedList.appendAtTail(2);
		//		linkedList.appendAtTail(5);
//		linkedList.prepend(0);
//		linkedList.appendAt(1, 3);
//		linkedList.deleteWithValue(3);
//		//		linkedList.deleteWithIndex(1);
//		System.out.println("Forward Linked List:");
//		linkedList.showLinkedList();
		
//TO reverse linked list with iteration	
//		linkedList.reverseLinkList();
//		System.out.println("Reversed Singly Linked List with Iterations:");
//		linkedList.showLinkedList();
		
// TO print linked list in reverse using recursion - original list is not reversed
//		linkedList.printReverseLinkedList();
		
// TO reverse linked list with recursion		
//		Node head1 = linkedList.appendAtTail(null,1);
//		head1=linkedList.appendAtTail(head1,2);
//		head1=linkedList.appendAtTail(head1,3);
//		head1=linkedList.appendAtTail(head1,15);
//		Node head = linkedList.reverseLinkedListWithRecursion(head1);
//		System.out.println("Reversed Singly Linked List with Recursion:");
//		linkedList.showLinkedList();
//		System.out.println("The Modified Head in Reversed Singly Linked List with Recursion is:");
//		System.out.println(head.data);
		
//To return Nth node from end of linked list
//		Node nthNode= linkedList.returnNthFromEnd(2);
//		System.out.println("The nth node from last is:");
//		System.out.println(nthNode.data);

//To merge two sorted linked lists with iteration
		Node head1 = linkedList.appendAtTail(null,1);
		head1=linkedList.appendAtTail(head1,2);
		head1=linkedList.appendAtTail(head1,3);
		head1=linkedList.appendAtTail(head1,15);
		Node head2= linkedList.appendAtTail(null,5);
		head2=linkedList.appendAtTail(head2,10);
		head2=linkedList.appendAtTail(head2,20);

				Node head3= linkedList.mergeTwoSortedLists(head1,head2);
				System.out.println(head3.data);
				System.out.println("Merged two sorted linked lists:");
				linkedList.showLinkedList(head3);
//		
////To merge two sorted linked lists with recursion
//		Node head4=linkedList.mergeSortedListsWithRecursion(head1,head2);
//		System.out.println(head4.data);
//		System.out.println("Merged two sorted linked lists with Recursion:");
//		linkedList.showLinkedList(head4);

// To check palindrome linked list
//		Node head5 = new Node(0);
//		head5=linkedList.appendAtTail(null,1);
//		head5=linkedList.appendAtTail(head5,2);
//		head5=linkedList.appendAtTail(head5,3);
//		head5=linkedList.appendAtTail(head5,4);
////		head5=linkedList.appendAtTail(head5,5);
////		head5=linkedList.appendAtTail(head5,6);
//		head5=linkedList.appendAtTail(head5,4);
//		head5=linkedList.appendAtTail(head5,3);
//		head5=linkedList.appendAtTail(head5,2);
//		head5=linkedList.appendAtTail(head5,1);
		
// To check palindrome linked list with iterations (preferred)
		//boolean isPalindrome = linkedList.isPalindrome(head5);
		
// To check palindrome linked list with recursion
//		boolean isPalindrome = linkedList.isPalindromeWithRecursion(head5);
		
//		System.out.println("Is the Linked List Panlindrome:");
//		System.out.println(isPalindrome);

//To remove duplicates in linked list
//		Node head6 = new Node(0);
//		head6=linkedList.appendAtTail(null,1);
//		head6=linkedList.appendAtTail(head6,2);
//		head6=linkedList.appendAtTail(head6,3);
//		head6=linkedList.appendAtTail(head6,3);
//		head6=linkedList.appendAtTail(head6,4);
//		head6=linkedList.appendAtTail(head6,4);
//		head6=linkedList.appendAtTail(head6,5);
//		head6=linkedList.appendAtTail(head6,5);
//		linkedList.removeDuplicates(null);
//		System.out.println("Linked list after removing duplicates:");
//		linkedList.showLinkedList(head6);
		
// To check cyclic linked list
//		Node head7 = new Node(0);
//		head7=linkedList.appendAtTail(null,3);
//		head7=linkedList.appendAtTail(head7,2);
//		head7=linkedList.appendAtTail(head7,0);
//		head7=linkedList.appendAtTail(head7,4);
//		linkedList.createCyclicList(head7, 2);
//		System.out.println("linkedList cyclic?");
//		System.out.println(linkedList.checkLinkedListCycle(head7));

// Basic implementation of Doubly linked list
//		DoublyLinkedList doublyLinkedList=new DoublyLinkedList();
//		doublyLinkedList.appendAtTail(14);
//		doublyLinkedList.appendAtTail(12);
//		doublyLinkedList.appendAtTail(15);
//		doublyLinkedList.prepend(10);
//		doublyLinkedList.appendAt(1, 13);
//		//		linkedList.deleteWithValue(3);
//		doublyLinkedList.deleteWithIndex(1);
//		doublyLinkedList.showLinkedList();
//		doublyLinkedList.showReversedLinkedList();

// Basic implementation of circular linked list
//		CircularLinkedList circularLinkedList = new CircularLinkedList();
//		circularLinkedList.appendAtTail(3);
//		circularLinkedList.appendAtTail(5);
//		circularLinkedList.appendAtTail(6);
//		circularLinkedList.appendAtTail(8);
//		circularLinkedList.prepend(2);
//		circularLinkedList.appendAt(0, 9);
//		circularLinkedList.deleteWithValue(8);
//		circularLinkedList.showLinkedList();
	}
}
