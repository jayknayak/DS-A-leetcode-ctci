package com.Trees;
import java.util.*;

public class Main {
	public static void main(String[]args) {
		BinarySearchTree bst = new BinarySearchTree();
		BinaryTree bt = new BinaryTree();
		Heaps heap = new Heaps();
//		Node root=null;
//		root=bst.insert(root, 15);
//		root=bst.insert(root, 10);
//		root=bst.insert(root, 20);
//		root=bst.insert(root, 8);
//		root=bst.insert(root, 12);
//		root=bst.insert(root, 11);
//		root=bst.insert(root, 14);
//		root=bst.insert(root, 18);
//		root=bst.insert(root, 19);
//		root=bst.insert(root, 22);
//		root=bst.insert(root, 21);
//		root=bst.insert(root, 23);
//		root=bst.insert(root, 25);
//		root=bst.insert(root, 24);
		
//Find an element		
//		System.out.println(bst.contains(root, 22));
		
//Find Minimum		
//		System.out.println("Minimum Value in BST: "+bst.findMin(root));
		
//Find Maximum		
//		System.out.println("Maximum Value in BST: "+bst.findMax(root));
		
//Find Height
//		System.out.println("Height of Binary Tree: "+bst.findHeight(root));
		
//Traverse Tree - Breadth First
//		bst.breadthFirst(root);
//		bst.levelOrder(root);
		
//Traverse Tree: Depth First
//		bst.preorderTraversal(root);
//		bst.inorderTraversal(root);
//		bst.postorderTraversal(root);
		
//Check if Binary Tree is a BST
//		root = new Node(15);
//		root.left=new Node(10);
//		root.right=new Node(20);
//		root.left.left=new Node(8);
//		root.left.right=new Node(12);
//		root.right.left=new Node(18);
//		root.right.right=new Node(22);
//		root.right.right.right=new Node(25);
//		root.left.left.left=new Node(9);
//		root = new Node(2147483647);
//		root.left=new Node(2147483647);
//		System.out.println("Is BT BST? "+bst.isBST(root));
		
//Delete a node in a BST
//		root=bst.deleteNode(root, 15);
//		bst.inorderTraversal(root);
		
//Inorder successor in BST
//		System.out.println("Inorder successor of BST: "+bst.inorderSuccessor(root,14).data);
//Inorder ancestor in BST		
//		System.out.println("Inorder ancestor of BST: "+bst.inorderAncestor(root,10).data);
		
//Symmetric Binary Tree
//		Node root= new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(2);
//		root.left.left = new Node(3);
//		root.left.right = new Node(4);
//		root.right.left = new Node(4);
//		root.right.right = new Node(3);
//		root.left.left.left = new Node(5);
//		root.left.left.right = new Node(6);
//		root.left.right.left = new Node(7);
//		root.left.right.right = new Node(8);
//		root.right.left.left = new Node(8);
//		root.right.left.right = new Node(7);
//		root.right.right.left = new Node(6);
//		root.right.right.right = new Node(5);
//		System.out.println("Is BT symmetric? "+bst.isSymmetricTree(root));
		
//Is Balanced BT		
//		System.out.println("Is balances BT? "+bst.isBalancedBT(root));
		//int[] data = {0,1,2,3,4,5,6};
//		int[] data = {0,1,2,3,4,5};
//		System.out.println("Balanced BST: ");
		
//Create Balanced BT		
//		bst.preorderTraversal(bst.createBalancedBT(data));
		
//Create Balanced BST		
//		bst.inorderTraversal(bst.createBalancedBST(data));
		
//Is Complete BT
//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.left.left = new Node(4);
//		root.left.left = new Node(5);
//		root.right.left = new Node(7);
//		System.out.println("Is Complete BT? "+ bt.isCompleteBT(root));
		
//First common ancestor		
//		Node root = new Node(1);
//		root.left= new Node(2);
//		root.right= new Node(3);
//		root.left.left= new Node(4);
//		root.left.right= new Node(5);
//		root.right.left= new Node(6);
//		root.right.right= new Node(7);
//		root.right.left.right= new Node(8);
//		root.right.right.right= new Node(9);
//		root.right.right.right.left= new Node(10);
//		System.out.println("First Common Ancestor: "+bt.findFirstCommonAncestor(root, 8, 10).data);
		
// BST Sequences	
//		Node root=null;
//		root=bst.insert(root, 3);
//		root=bst.insert(root, 1);
//		root=bst.insert(root, 0);
//		root=bst.insert(root, 2);
//		root=bst.insert(root, 5);
//		root=bst.insert(root, 4);
//		root=bst.insert(root, 6);
//		ArrayList<LinkedList<Integer>> sequences= bst.BSTSequence(root);
//		for(LinkedList<Integer> sequence:sequences) {
//			System.out.println(sequence);
//		}
//		System.out.println(sequences.size());
		
//	Check Subtree
//		Node root1 = new Node(1);
//		root1.left= new Node(2);
//		root1.right= new Node(4);
//		root1.left.left= new Node(4);
//		root1.left.right= new Node(5);
//		root1.right.left= new Node(8);
//		root1.right.right= new Node(7);
//		root1.left.left.left= new Node(8);
//		root1.left.left.right= new Node(9);
//		Node root2=new Node(4);
//		root2.left=new Node(8);
//		root2.right=new Node(7);
//		System.out.println("Is T2 subtree of T1?: "+(bt.checkSubtree(root1, root2)?"Yes":"No"));
		
//Get Random Node
//		System.out.println("Randomly picked Node: "+bst.getRandomNode(root).data);
		
//Find Paths with sum
		Node root = new Node(10);
		root.left= new Node(5);
		root.right= new Node(-3);
		root.left.left= new Node(3);
		root.left.right= new Node(2);
		root.right.right= new Node(11);
		root.left.left.left= new Node(3);
		root.left.left.right= new Node(-2);
		root.left.right.right= new Node(1);
		System.out.println("Total paths with given sum: "+bt.pathsWithSum(root, 8));
		
//Min heap		
//		int[] nums = {0,1,2,4};
//		int size = nums.length;
//		nums=heap.insertMinHeap(nums, size, 5);
//		nums=heap.insertMinHeap(nums, size+=1, 3);
//		nums=heap.insertMinHeap(nums, size+=1, 1);
//		size = size+=1;
//		nums=heap.deleteMinHeap(nums, size);
//		nums=heap.deleteMinHeap(nums, size-=1);
//		nums=heap.deleteMinHeap(nums, size-=1);
//		size-=1;
		
//Max heap	
//		heap.insertMaxHeap(0);
//		heap.insertMaxHeap(1);
//		heap.insertMaxHeap(2);
//		heap.insertMaxHeap(3);
//		heap.insertMaxHeap(4);
//		heap.insertMaxHeap(5);
//		heap.deleteMaxHeap();
//		heap.deleteMaxHeap();
//		heap.deleteMaxHeap();
		
//HeapSort
//		heap.heapSort();
		
//Tries
		Trie trie = new Trie();
		
//Create Trie		
//		trie.insertTrieNode("abcd");
//		trie.insertTrieNode("abc");
//		trie.insertTrieNode("abd");
//		trie.insertTrieNode("abde");
		
//Search Trie		
//		System.out.println("Is word present? "+trie.searchTrieNode("abcd"));
		//trie.delete("abc");
//		System.out.println("Is abc word present? "+trie.searchTrieNode("abc"));
//		System.out.println("Is abcd word present? "+trie.searchTrieNode("abcd"));
//		trie.delete("abcd");
//		trie.delete("abd");
//		System.out.println("Is abcd word present? "+trie.searchTrieNode("abcd"));
//		System.out.println("Is abde word present? "+trie.searchTrieNode("abde"));
//Delete word in Trie		
//		trie.delete("abde");
//		System.out.println("Is abc word present? "+trie.searchTrieNode("abde"));
//		trie.delete("ab");
//Search Prefix in Trie		
//		System.out.println("Is Prefix abc present? "+trie.searchPrefixTrieNode("abc"));
		
//Count number of contacts		
//		trie.insertTrieNode("Gayle");
//		trie.insertTrieNode("Gary");
//		trie.insertTrieNode("Geena");
//		trie.insertTrieNode("Alex");
//		trie.insertTrieNode("Alpesh");
//		trie.insertTrieNode("Andy");
//		System.out.println("Count number of contacts "+trie.countPrefixTrieNode(""));
	}
}
