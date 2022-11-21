package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	Queue<Node> queue = new LinkedList<Node>();

//Find height of binary tree
	public int findHeight(Node root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		int treeHeight = Math.max(leftHeight, rightHeight) + 1;
		return treeHeight;
	}

//Traverse Tree: Breadth First
	Queue<Node> visitedNodes = new LinkedList<Node>();

	public void breadthFirst(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		if (root.left != null) {
			visitedNodes.add(root.left);
		}
		if (root.right != null) {
			visitedNodes.add(root.right);
		}
		if (!visitedNodes.isEmpty()) {
			breadthFirst(visitedNodes.poll());
		}
		return;
	}

//Traverse Tree: Depth First
//Preosrder: <root><left><right>
	public void preorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

//Inorder: <left><root><right>
	public void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}

//Postorder: <left><right><root>
	public void postorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.data);
	}

//Levelorder traversal	
	List<List<Integer>> traversalList = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return traversalList;
		}
		Queue<Node> currentLayerNodes = new LinkedList<Node>();
		currentLayerNodes.add(root);
		collectNextLayerNodes(currentLayerNodes);
		return traversalList;
	}

	private void collectNextLayerNodes(Queue<Node> currentLayerNodes) {
		if (currentLayerNodes.isEmpty()) {
			return;
		}
		Queue<Node> nextLayerNodes = new LinkedList<Node>();
		List<Integer> layerNodesData = new ArrayList<Integer>();
		while (!currentLayerNodes.isEmpty()) {
			Node root = currentLayerNodes.poll();
			layerNodesData.add(root.data);
			if (root.left != null) {
				nextLayerNodes.add(root.left);
			}
			if (root.right != null) {
				nextLayerNodes.add(root.right);
			}
		}
		traversalList.add(layerNodesData);
		collectNextLayerNodes(nextLayerNodes);
	}

//Is Binary Tree Symmetric			
//		    public boolean isSymmetricTree (Node root) {
//	    	if(root==null) {
//	    		return true;
//	    	}
//	    	Queue<Node> currentLevelNodes = new LinkedList<Node>();
//	    	if(root.left!=null && root.right!=null) {
//	    		currentLevelNodes.add(root.left);
//	    		currentLevelNodes.add(root.right);
//	    	}
//	    	else if((root.left==null && root.right!=null) || (root.left!=null && root.right==null)){
//	    		return false;
//	    	}
//	    	else if(root.left==null && root.right==null) {
//	    		return true;
//	    	}
//	    	return isSymmetricTreeUtil(root,root);
//	    }
//	    
//	    private boolean isSymmetricTreeUtil (Queue<Node>currentLevelNodes) {
//	    	if(currentLevelNodes.isEmpty()) {
//	    		return true;
//	    	}
//	    	Queue<Node> nextLevelNodes = new LinkedList<Node>();
//	    	Node root1=null,root2=null;
//	    	while(!currentLevelNodes.isEmpty()) {
//	    		if(!currentLevelNodes.isEmpty()) {
//	    			root1=currentLevelNodes.poll();
//	    		}
//	    		if(!currentLevelNodes.isEmpty()) {
//	    			root2=currentLevelNodes.poll();
//	    		}
//	    		if(root1!=null && root2!=null) {
//	    			if(root1.data!=root2.data) {
//	    				return false;
//	    			}
//	    			if(root1.left!=null && root2.right!=null) {
//	    				nextLevelNodes.add(root1.left);
//	    				nextLevelNodes.add(root2.right);
//	    			}
//	    			else if((root1.left!=null && root2.right==null) || (root1.left==null && root2.right!=null)) {
//		    			return false;
//		    		}
//	    			if(root1.right!=null && root2.left!=null) {
//	    				nextLevelNodes.add(root1.right);
//	    				nextLevelNodes.add(root2.left);
//	    			}
//	    			else if((root1.right!=null && root2.left==null) || (root1.right==null && root2.left!=null)) {
//		    			return false;
//		    		}
//	    		}
//	    	}
//	    	return isSymmetricTreeUtil(nextLevelNodes);
//	    }

	// another approach
	public boolean isSymmetricTree(Node root) {
		if (root == null) {
			return true;
		}
		return isSymmetricTreeUtil(root.left, root.right);
	}

	private boolean isSymmetricTreeUtil(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		} else if (root1 != null && root2 != null && root1.data != root2.data) {
			return false;
		}
		if (!isSymmetricTreeUtil(root1.right, root2.left)) {
			return false;
		}
		if (!isSymmetricTreeUtil(root1.left, root2.right)) {
			return false;
		}
		return true;
	}

//Is Balanced Binary Tree
	boolean isBalanced = true;

	public boolean isBalancedBT(Node root) {
		if (root == null) {
			return true;
		}
		findHeightUtil(root);
		return isBalanced;
	}

	private int findHeightUtil(Node root) {
		if (root == null) {
			return -1;
		}
		int leftSubTreeHeight = findHeightUtil(root.left);
		int rightSubTreeHeight = findHeightUtil(root.right);
		if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
			isBalanced = false;
		}
		return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	}

//Create Balanced BT
	public Node createBalancedBT(Integer[] data) {
		if (data.length == 0) {
			return null;
		}
		return createBalancedBTUtil(new Node(0), data, 0);
	}

	private Node createBalancedBTUtil(Node root, Integer[] data, int i) {
		if (i < data.length) {
			if (data[i] != null) {
				Node tmp = new Node(data[i]);
				root = tmp;
			}
			if (root != null) {
				root.left = createBalancedBTUtil(root.left, data, i * 2 + 1);
				root.right = createBalancedBTUtil(root.right, data, i * 2 + 2);
			}
		}
		return root;
	}

//Check Completeness of BT
	public boolean isCompleteBT(Node root) {
		if (root == null) {
			return true;
		}
		Queue<Node> levelNodes = new LinkedList<Node>();
		levelNodes.add(root.left);
		levelNodes.add(root.right);
		while (!levelNodes.isEmpty()) {
			Node root1 = levelNodes.poll();
			Node root2 = levelNodes.poll();
			if (root1 == null) {
				if (root2 != null) {
					return false;
				}
				if (root2 == null && !levelNodes.isEmpty() && levelNodes.peek() != null) {
					return false;
				}
			}
			if (root1 != null && root2 == null) {
				if (root1.left != null) {
					return false;
				}
				if (!levelNodes.isEmpty() && levelNodes.peek() != null) {
					return false;
				}
			}
			if (root1 != null && root2 != null) {
				levelNodes.add(root1.left);
				levelNodes.add(root1.right);
				levelNodes.add(root2.left);
				levelNodes.add(root2.right);
			}
		}
		return true;
	}

//Find first common ancestor
	public Node findFirstCommonAncestor(Node root, int data1, int data2) {
		if (root == null) {
			return root;
		}
		Node node1 = findNode(root, data1);
		if(node1==null) {
			return root;
		}
		Node node2 = findNode(root, data2);
		if(node2==null) {
			return root;
		}
		boolean isNode1Left = searchDirection(root.left,node1);
		boolean isNode2Left = searchDirection(root.left,node2);
		if(isNode1Left!=isNode2Left) {
			return root;
		}
		Node child = isNode1Left?root.left:root.right;
		return findFirstCommonAncestor(child, data1, data2);
	}
	private Node findNode(Node root, int data) {
		if(root==null) {
			return root;
		}
		if(root.data==data) {
			return root;
		}
		Node node = findNode(root.left,data);
		if(node!=null) {
			return node;
		}
		node = findNode(root.right,data);
		if(node!=null) {
			return node;
		}
		return node;
	}
	private boolean searchDirection(Node root, Node node) {
		if(root==null) {
			return false;
		}
		if(root==node) {
			return true;
		}
		return searchDirection(root.left, node) || searchDirection(root.right,node);
	}
	
//Check Subtree
	public boolean checkSubtree (Node root1, Node root2) {
		if(root1==null || root2==null) {
			return false;
		}
		return checkSubtreeUtil(root1,root2);
	}
	private boolean checkSubtreeUtil(Node root1, Node root2) {
		if(root1==null) {
			return false;
		}
		if(root1.data==root2.data) {
			return matchSubtrees(root1,root2);
		}
		return checkSubtreeUtil(root1.left,root2) || checkSubtreeUtil(root1.right,root2);
	}
	private boolean matchSubtrees(Node root1, Node root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		if(root1.data!=root2.data) {
			return false;
		}
		return matchSubtrees(root1.left,root2.left) && matchSubtrees(root1.right,root2.right);
	}
	
//Paths with Sum	
	public int pathsWithSum(Node root, int sum) {
		if(root==null) {
			return 0;
		}
		int rootPathsWithSum = countSubtreePaths(root, 0, sum);
		int leftPathsWithSum = pathsWithSum(root.left,sum);
		int rightPathsWithSum = pathsWithSum(root.right,sum);
		return rootPathsWithSum + leftPathsWithSum + rightPathsWithSum;
	}
	private int countSubtreePaths(Node root, int pathSum, int sum) {
		if(root==null) {
			return 0;
		}
		int totalPaths=0;
		pathSum+=root.data;
		if(pathSum>sum) {
			return totalPaths;
		}
		if(pathSum==sum) {
			totalPaths++;
		}
		totalPaths+=countSubtreePaths(root.left,pathSum,sum);
		totalPaths+=countSubtreePaths(root.right,pathSum,sum);
		return totalPaths;
	}
	
//LeetCode: Medium	
//Zigzag level order traversal
	public List<List<Integer>> zigZagTraversal (Node root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Node> currentLayer = new Stack<Node>();
		currentLayer.add(root);
		return zigZagTraversal(currentLayer,result,false);
	}
	private List<List<Integer>> zigZagTraversal (Stack<Node> currentLayer,List<List<Integer>> result, boolean flip){
		if(currentLayer.isEmpty()) {
			return result;
		}
		Stack<Node> nextLayer = new Stack<Node>();
		List<Integer> layerValues = new ArrayList<Integer>();
		while(!currentLayer.isEmpty()) {
			Node node = currentLayer.pop();
			layerValues.add(node.data);
			if(!flip) {
				if(node.left!=null) {
					nextLayer.add(node.left);
				}
				if(node.right!=null) {
					nextLayer.add(node.right);
				}
			}
			else {
				if(node.right!=null) {
					nextLayer.add(node.right);
				}
				if(node.left!=null) {
					nextLayer.add(node.left);
				}
			}
		}
		result.add(layerValues);
		return zigZagTraversal(nextLayer,result,flip=!flip);
	}
	
//Create BT from preorder and inorder
	public Node buildTree(int[]preorder, int[] inorder) {
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	private Node buildTree(int[]preorder, int preStart, int preEnd,int[]inorder, int inStart, int inEnd) {
		if(preStart>preEnd || inStart>inEnd) {
			return null;
		}
		Node node = new Node(preorder[preStart]);
		int k=0;
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i]==preorder[preStart]) {
				k=i;
				break;
			}
		}
		node.left=buildTree(preorder,preStart+1,preStart+(k-inStart),inorder,inStart,k-1);
		node.right=buildTree(preorder,preStart+(k-inStart)+1,preEnd,inorder,k+1,inEnd);
		return node;
	}
	
//Create BT from postorder and inorder
		public Node buildPostInTree(int[]postorder, int[] inorder) {
			return buildPostInTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
		}
		private Node buildPostInTree(int[]postorder, int postStart, int postEnd,int[]inorder, int inStart, int inEnd) {
			if(postStart>postEnd || inStart>inEnd) {
				return null;
			}
			Node node = new Node(postorder[postEnd]);
			int k=0;
			for(int i=0;i<inorder.length;i++) {
				if(inorder[i]==postorder[postEnd]) {
					k=i;
					break;
				}
			}
			node.left=buildTree(postorder,postStart,postStart+k-(inStart+1),inorder,inStart,k-1);
			node.right=buildTree(postorder,postStart+(k-inStart),postEnd-1,inorder,k+1,inEnd);
			return node;
		}
		
// Populating next right pointers in each node
		public Node connect (Node root) {
			if(root==null) {
				return root;
			}
			Queue<Node> levelQueue = new LinkedList<Node>();
			Queue<Integer> depthQueue = new LinkedList<Integer>();
			levelQueue.add(root);
			depthQueue.add(1);
			while(!levelQueue.isEmpty()) {
				Node node = levelQueue.poll();
				int depth = depthQueue.poll();
				if(depthQueue.isEmpty()) {
					node.next=null;
				}
				else if(depth<depthQueue.peek()) {
					node.next=null;
				}
				else {
					node.next=levelQueue.peek();
				}
				if(node.left!=null) {
					levelQueue.add(node.left);
					depthQueue.add(depth+1);
				}
				if(node.right!=null) {
					levelQueue.add(node.right);
					depthQueue.add(depth+1);
				}
			}
			return root;
		}
}
