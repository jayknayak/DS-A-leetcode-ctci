package com.linkedList;

public class LinkedList {
	Node head;
	public Node initializeLinkedList (int data) {
		head=new Node(data);
		return head;
	}
	//appending an element at the end of linked list
	//	public void appendAtTail (int data) {
	//		if(head==null) {
	//			initializeLinkedList(data);
	//			return;
	//		}
	//		Node current=head;
	//		while (current.next!=null) {
	//			current=current.next;
	//		}
	//		current.next=new Node(data);
	//		//current.next.prev=current;
	//	}
	//prepending an element before the head node
	public void prepend(int data) {
		if(head==null) {
			initializeLinkedList(data);
			return;
		}
		Node newHead=new Node(data);
		//head.prev=newHead;
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
			//head.prev=newNode;
			newNode.next=head; 
			head= newNode;
		}
		else {
			Node current=head;
			for (int i=0; i<index-1; i++) {
				current=current.next;
			}
			//current.next.prev=newNode;
			newNode.next=current.next;
			//newNode.prev=current;
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
			//head.prev=null;
			return;
		}
		Node current = head;
		while(current.next!=null) {
			if(current.next.data==data) {
				current.next=current.next.next;
				//current.next.prev=current;
				return;
			}
			current=current.next;
		}
	}

	// reversing a linked list
	public void reverseLinkList() {
		if(head==null) {
			return;
		}
		Node prev=null, next;
		Node current=head;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}

	//deleting a specific element by index in the linked list
	public void deleteWithIndex (int index) {
		if(head==null) {
			return;
		}
		if(index==0) {
			head=head.next;
			//head.prev=null;
		}
		else {
			Node current = head;
			for (int i=0; i<index-1;i++) {
				current=current.next;
			}
			if(current.next!=null) {
				current.next=current.next.next;
			}
			//current.next.prev=current;
		}
	}
	public void showLinkedList() {
		if(head==null) {
			return;
		}
		Node current = head;
		while(current.next!=null) {
			System.out.println(current.data);
			current=current.next;
		}
		System.out.println(current.data);
	}

	// print link list in reverse using recursion
	public void printReverseLinkedList() {
		System.out.println("Printing Reversed Link List Using Recursion:");
		printReverseLinkedList(head);
	}
	public void printReverseLinkedList(Node node) {
		if(node==null) {
			return;
		}
		printReverseLinkedList(node.next);
		System.out.println(node.data);
	}

	//reverse link list using recursion
	public Node reverseLinkedListWithRecursion() {
		Node head = reverseLinkedListWithRecursion(this.head);
		return head;
	}
	public Node reverseLinkedListWithRecursion(Node node) {
		if(node.next==null) {
			//head=node;
			return node;
		}
		Node head = reverseLinkedListWithRecursion(node.next);
		Node tmp = node.next;
		tmp.next=node;
		node.next=null;
		return head;
	}

	//Remove Nth Node from end
	public Node removeNthFromEnd(Node head, int n) {
		if(head == null){
			return head;
		}
		Node dummy = new Node(0);
		dummy.next=head;
		Node current = head;
		Node pointer = dummy;
		int size=1;
		while(current.next!=null){
			current=current.next;
			size++;
		}
		int length = 0;
		while(length<(size-n)){
			pointer=pointer.next;
			length++;
		}
		pointer.next=pointer.next.next;
		return dummy.next;
	}

	//Return Nth element from end
	public Node returnNthFromEnd(int n) {
		if(head==null) {
			return head;
		}
		Node dummy = new Node(0);
		dummy.next=head;
		Node current = head;
		Node pointer = dummy;
		int size=1;
		while(current.next!=null) {
			current=current.next;
			size++;
		}
		int length = 0;
		while(length<(size-n)) {
			pointer=pointer.next;
			length++;
		}
		return (pointer.next);
	}

	public Node appendAtTail (Node head, int data) {
		if(head==null) {
			//initializeLinkedList(data);
			head=new Node(data);
			return head;
		}
		Node current = head;
		while (current.next!=null) {
			current=current.next;
		}
		current.next=new Node(data);
		//current.next.prev=current;
		return head;
	}

	public void showLinkedList(Node head) {
		if(head==null) {
			return;
		}
		Node current = head;
		while(current.next!=null) {
			System.out.println(current.data);
			current=current.next;
		}
		System.out.println(current.data);
	}

	public Node mergeTwoSortedLists(Node l1, Node l2) {
		Node dummyHead = new Node(0);
		Node tail = dummyHead;
		Node current1=l1, current2=l2;
		while(true){
			if(current1==null){
				tail.next=current2;
				break;
			}
			if(current2==null){
				tail.next=current1;
				break;
			}
			if(current1.data<=current2.data){
				System.out.println("Inside first logic block");
				tail.next=current1;
				tail=current1;
				current1=current1.next;
			}
			else{
				System.out.println("Inside second logic block");
				tail.next=current2;
				tail=current2;
				current2=current2.next;
			}
		}
		return dummyHead.next;
	}

	public Node mergeSortedListsWithRecursion(Node head1, Node head2) {
		if(head1==null) {
			//			Node tail = new Node(0);
			//			tail.next=head2;
			//			return tail.next;
			return head2;	//this line equivalent to the first three lines
		}
		if(head2==null) {
			//			Node tail = new Node(0);
			//			tail.next=head1;
			//			return tail.next;
			return head1;	//this line equivalent to the first three lines
		}
		if(head1.data<=head2.data) {
			//			Node tail = mergeSortedListsWithRecursion(head1.next,head2);
			//			head1.next=tail;
			//			tail=head1;
			//			return tail;
			head1.next=mergeSortedListsWithRecursion(head1.next,head2);	//this line and the following line equivalent to the first four lines
			return head1;
		}
		else {
			//			Node tail = mergeSortedListsWithRecursion(head1,head2.next);
			//			head2.next=tail;
			//			tail=head2;
			//			return tail;
			head2.next=mergeSortedListsWithRecursion(head1,head2.next);	//this line and the following line equivalent to the first four lines
			return head2;
		}
	}

	// Check if the linked list is palindrome
	Node midNode;
	public boolean isPalindrome(Node head) {
		if(head==null) {
			return true;
		}
		int size=1;
		double mid=0;
		Node current = head;
		while(current.next!=null) {
			current=current.next;
			size++;
		}
		if(size%2==0) {
			mid=size/2;
		}
		else {
			mid=(size/2)+1;
		}
		//Node midNode = head;
		midNode = head;
		for(int i=0;i<size-mid;i++) {
			midNode=midNode.next;
		}
		Node reversedHead= reversedLinkList();
		current = head; 
		//Node dummyHead=reversedHead;
		while(current!=null && reversedHead!=null){
			if(current.data!=reversedHead.data){
				return false;
			}
			current=current.next;
			reversedHead=reversedHead.next;
		}
		reversedLinkList();
		return true;

	}
	public Node reversedLinkList() {
		Node current = midNode;
		Node prev=null, next;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		midNode=prev;
		return midNode;
	}
	
	public void removeDuplicates(Node head) {
		if(head==null) {
			return;
		}
		Node p1=head.next, p2=head;
		while(p1!=null && p2!=null) {
			if(p1.data==p2.data) {
				p2.next=p2.next.next;
				p2=p2.next;
				if(p1.next!=null) {
					p1=p1.next.next;
					continue;
				}
				else {
					return;
				}
			}
			p1=p1.next;
			p2=p2.next;
		}
		return;
	}
	
	public boolean checkLinkedListCycle(Node head) {
		if(head==null){
			return false;
		}
		Node p1=head.next, p2=head;
		while(p1!=null && p1.next!=null) {
			if(p2.data==p1.data) {
				return true;
			}
			p1=p1.next.next;
			p2=p2.next;
		}
		return false;
	}
	public void createCyclicList(Node head, int index) {
		if(head==null) {
			return;
		}
		Node current=head;
		while(current.next!=null) {
			current=current.next;
		}
		for(int i=1;i<index;i++) {
			head=head.next;
		}
		current.next=head;
		
	}
	int length =1;Node right;
	public boolean isPalindromeWithRecursion (Node head) {
		if(head==null) {
			return false;
		}
		Node current=head;
		while(current.next!=null) {
			current=current.next;
			length++;
		}
		Node dummyHead = new Node(0);
		dummyHead.next=head;
		return (isPalindromeWithRecursion(dummyHead, 0));
	}
	private boolean isPalindromeWithRecursion(Node node, int size) {
		if(node!=null && size==(length/2)) {
			right=node.next;
			if(length%2!=0) {
				right=right.next;
			}
			return false;
		}
		isPalindromeWithRecursion(node.next,size+1);
		if(right!=null && node.next!=null) {
			if(right.data!=node.next.data) {
				return false;
			}
			right=right.next;
			return true;
		}
		return false;
	}
}

