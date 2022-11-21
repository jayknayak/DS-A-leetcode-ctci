package com.Trees;
import java.util.*;
public class BinarySearchTree {

	public Node insert(Node root, int data) {
		if (root == null) {
			return root = new Node(data);
		} else if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		root.size++;
		return root;
	}

//Find a node	
	public boolean contains(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		} else if (data < root.data) {
			return contains(root.left, data);
		} else {
			return contains(root.right, data);
		}
	}

//Find minimum node	
	public int findMin(Node root) {
		if (root == null) {
			return -1;
		}
		if (root.left == null) {
			return root.data;
		}
		return findMin(root.left);
	}

//Find maximum node	
	public int findMax(Node root) {
		if (root == null) {
			return -1;
		}
		if (root.right == null) {
			return root.data;
		}
		return findMax(root.right);
	}

//Check BT is BST
//		public boolean isBST(Node root) {
//			if(root==null) {
//				return true;
//			}
//			if(root.left!=null) {
//				if(root.left.data>root.data) {
//					return false;
//				}
//				if(!isBST(root.left)) {
//					return false;
//				}
//			}
//			if(root.right!=null) {
//				if(root.right.data<=root.data) {
//					return false;
//				}
//				if(!isBST(root.right)) {
//					return false;
//				}
//			}
//			return true;
//		}
	// another approach
	public boolean isBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBSTUtil(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.data > minValue && root.data < maxValue && isBSTUtil(root.left, minValue, root.data)
				&& isBSTUtil(root.right, root.data, maxValue)) {
			return true;
		}
		return false;
	}

//Delete node from BST
	public Node deleteNode(Node root, int data) {
		if (root == null) {
			return root;
		}
		if (root.data == data) {
			if (root.left == null && root.right == null) {
				root = deleteLeafNode(root);
				return root;
			} else if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
				root = deleteNodeWithOneChild(root);
				return root;
			} else {
				root = deleteNodeWithTwoChildren(root);
				return root;
			}
		}
		if (data < root.data) {
			root.left = deleteNode(root.left, data);
			return root;
		} else {
			root.right = deleteNode(root.right, data);
			return root;
		}
		// return root;
	}

	private Node deleteLeafNode(Node root) {
		return root = null;
	}

	private Node deleteNodeWithOneChild(Node root) {
		if (root == null) {
			return root;
		}
		if (root.left != null && root.right == null) {
			return root = root.left;
		} else {
			return root = root.right;
		}
	}

	private Node deleteNodeWithTwoChildren(Node root) {
		if (root.right != null) {
			int minValue = findMinValue(root.right, root.right.data);
			root.data = minValue;
//				if(root.right.left==null && root.right.right==null) {
//					root.right=deleteLeafNode(root.right);
//					return root;
//				}
//				if(root.right.left!=null) {
//					root.right.left=deleteLeafNode(root.right.left);
//					return root;
//				}
//				else {
//					root.right=deleteNodeWithOneChild(root.right);
//					return root;
//				}
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}

	private int findMinValue(Node root, int minValue) {
		if (root == null) {
			return -1;
		}
		if (root.left == null) {
			return root.data;
		}
		return Math.min(minValue, findMinValue(root.left, root.left.data));
	}

//Inorder successor in BT
	public Node inorderSuccessor(Node root, int data) {
		if (root == null) {
			return new Node(0);
		}
		Node targetNode = findTargetNode(root, data);
		if (targetNode.right != null) {
			return (findLeftMostNode(targetNode.right));
		} else {
			return (findParentNode(root, targetNode));
		}
	}

	private Node findTargetNode(Node root, int data) {
		if (root == null) {
			return new Node(0);
		}
		if (root.data == data) {
			return root;
		}
		if (data < root.data) {
			return (findTargetNode(root.left, data));
		} else {
			return (findTargetNode(root.right, data));
		}
	}

	private Node findLeftMostNode(Node root) {
		if (root == null) {
			return new Node(0);
		}
		if (root.left == null) {
			return root;
		}
		return findLeftMostNode(root.left);
	}

	private Node findParentNode(Node root, Node targetNode) {
		if (root == null || targetNode == null) {
			return new Node(0);
		}
		Node successor = new Node(0);
		while (root != targetNode) {
			if (root.data > targetNode.data) {
				successor = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return successor;
	}

//Inorder ancestor in BST
	public Node inorderAncestor(Node root, int data) {
		if (root == null) {
			return new Node(0);
		}
		Node targetNode = findTargetNode(root, data);
		if (targetNode.left != null) {
			return findRightMostNode(targetNode.left);
		} else {
			return findChildNode(root, targetNode);
		}
	}

	private Node findRightMostNode(Node root) {
		if (root == null) {
			return new Node(0);
		}
		if (root.right == null) {
			return root;
		}
		return findRightMostNode(root.right);
	}

	private Node findChildNode(Node root, Node targetNode) {
		if (root == null || targetNode == null) {
			return new Node(0);
		}
		Node ancestor = new Node(0);
		while (root != targetNode) {
			if (root.data > targetNode.data) {
				root = root.left;
			} else {
				ancestor = root;
				root = root.right;
			}
		}
		return ancestor;
	}

//Create balanced BST Or Convert sorted array to BST
	public Node createBalancedBST(int[] data) {
		if (data.length == 0) {
			return null;
		}
		return createBalancedBSTUtil(new Node(0), data, 0, data.length - 1);
	}

	private Node createBalancedBSTUtil(Node root, int[] data, int startPoint, int endPoint) {
		if (startPoint <= endPoint) {
			int midPoint = (startPoint + endPoint) / 2;
			root = new Node(data[midPoint]);
			root.left = createBalancedBSTUtil(root.left, data, startPoint, midPoint - 1);
			root.right = createBalancedBSTUtil(root.right, data, midPoint + 1, endPoint);
		}
		return root;
	}
	
//BST Sequences
	public ArrayList<LinkedList<Integer>> BSTSequence(Node root){
		ArrayList<LinkedList<Integer>> sequences = new ArrayList<LinkedList<Integer>>();
		if(root==null) {
			LinkedList<Integer> result = new LinkedList<Integer>();
			sequences.add(result);
			return sequences;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.data);
		ArrayList<LinkedList<Integer>> leftSeq = BSTSequence(root.left);
		ArrayList<LinkedList<Integer>> rightSeq = BSTSequence(root.right);
		for(LinkedList<Integer> left :leftSeq) {
			for(LinkedList<Integer> right: rightSeq) {
				mergeLists(left,right,sequences,prefix);
			}
		}
		return sequences;
	}
	private void mergeLists(LinkedList<Integer> firstList, LinkedList<Integer> secondList, ArrayList<LinkedList<Integer>> sequences, LinkedList<Integer> prefix) {
		if(firstList.size()==0 || secondList.size()==0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(firstList);
			result.addAll(secondList);
			sequences.add(result);
			return;
		}
		Integer firstElem = firstList.removeFirst();
		prefix.addLast(firstElem);
		mergeLists(firstList,secondList,sequences,prefix);
		firstList.addFirst(firstElem);
		prefix.removeLast();
		
		Integer secondElem = secondList.removeFirst();
		prefix.addLast(secondElem);
		mergeLists(firstList,secondList,sequences,prefix);
		secondList.addFirst(secondElem);
		prefix.removeLast();
		return;
	}
	
//Pick Random node
	public Node getRandomNode(Node root) {
		if(root==null) {
			return root;
		}
		int leftSize = root.left==null?0:root.left.size;
		Random random = new Random();
		int i=random.nextInt(root.size);
		if(i<leftSize) {
			return getRandomNode(root.left);
		}
		else if(i==leftSize) {
			return root;
		}
		else {
			return getRandomNode(root.right);
		}
	}
	
//LeetCode: Medium		
//kth smallest node in BST
	public int kthSmallest(Node root, int k) {
		List<Integer> values = new ArrayList<Integer>();
		values=kthSmallest(root,values);
		return values.get(k-1);
	}
	private List<Integer> kthSmallest(Node root, List<Integer> values){
		if(root==null) {
			return values;
		}
		//Simple inorder traversal which gives sorted list.
		values=kthSmallest(root.left,values);
		values.add(root.data);
		values=kthSmallest(root.right, values);
		return values;
	}
}
