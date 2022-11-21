package com.Graphs;

import java.util.*;
import java.util.Map.Entry;

public class Graph {
	HashMap<Integer,Node> nodeMap = new HashMap<Integer,Node>();
//	HashMap<String,Node> nodeMap = new HashMap<String,Node>();
	int totalVertices;
	//To use Array instead of HashMap
//	Graph(int totalVertices){
//		this.totalVertices=totalVertices;
//	}
	
//Create Graph- Bidirectional/undirectional or Directional
	public void addEdge(int startIndex, int endIndex, boolean isBidirectional) {
		Node startVertex = nodeMap.get(startIndex);
		if(startVertex==null) {
			startVertex = new Node(startIndex);
		}
		Node endVertex = nodeMap.get(endIndex);
		if(endVertex==null) {
			endVertex = new Node(endIndex);
		}
//		endVertex.inbound++;
		startVertex.adjacent.add(endVertex);
		nodeMap.put(startIndex, startVertex);
		if(isBidirectional) {
			endVertex.adjacent.add(startVertex);
		}
		nodeMap.put(endIndex, endVertex);
		return;
	}
	//Storing names
//	public void addEdge(String startName, String endName) {
//		Node startVertex = nodeMap.get(startName);
//		Node endVertex = nodeMap.get(endName);
//		if(startVertex==null) {
//			startVertex = new Node(startName);
//		}
//		if(endVertex==null) {
//			endVertex = new Node(endName);
//		}
//		startVertex.adjacent.add(endVertex);
//		nodeMap.put(startName, startVertex);
//		return;
//	}

//Remove edges	
	public void removeEdge(int startIndex, int endIndex) {
		Node startNode = nodeMap.get(startIndex);
//		Node adjacentNode = nodeMap.get(endIndex);
		if(startNode==null || startNode.adjacent.size()==0) {
			return;
		}
		for(Node adjacent:startNode.adjacent) {
			if(adjacent.index==endIndex) {
				startNode.adjacent.remove(adjacent);
				break;
			}
		}
		return;
	}
	
//Check connectivity between nodes	
	public boolean edgeExists (int startIndex, int endIndex) {
		Node startNode = nodeMap.get(startIndex);
		if(startNode!=null && startNode.adjacent.size()!=0) {
			for(Node adjacentNode:startNode.adjacent) {
				if(adjacentNode.index==endIndex) {
					return true;
				}
			}
		}
		return false;
	}
	
//Find adjacent nodes	
	public List<Node> findAdjacentNode (int index) {
		Node current = nodeMap.get(index);
		if(current==null) {
			return Collections.emptyList();
		}
		return current.adjacent;
	}
	
//Check Path - DFS
	public boolean hasPathDFS (int startIndex, int endIndex) {
		Node source = nodeMap.get(startIndex);
		Node dest = nodeMap.get(endIndex);
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		return hasPathDFSUtil(source,dest,visitedNodes);
	}
	private boolean hasPathDFSUtil (Node source, Node dest, HashSet<Integer> visitedNodes) {
		if(source==null || dest==null) {
			return false;
		}
		if(source.index==dest.index) {
			return true;
		}
		visitedNodes.add(source.index);
		for(Node adjacent: source.adjacent) {
			if(visitedNodes.contains(adjacent.index)) {
				continue;
			}
			if(hasPathDFSUtil(adjacent, dest, visitedNodes)) {
				return true;
			}
		}
		return false;
	}
	
//Check Path - BFS
	public boolean hasPathBFS (int startIndex, int endIndex) {
		Node source = nodeMap.get(startIndex);
		Queue<Node> layerNodes = new LinkedList<Node>();
		layerNodes.add(source);
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		while(!layerNodes.isEmpty()) {
			Node current = layerNodes.poll();
			if(current==null) {
				continue;
			}
			if(current.index==endIndex) {
				return true;
			}
			visitedNodes.add(current.index);
			for(Node adjacentNode : current.adjacent) {
				if(!visitedNodes.contains(adjacentNode.index)) {
					visitedNodes.add(adjacentNode.index);
					layerNodes.add(adjacentNode);
				}
			}
		}
		return false;
	}
	
//Contains cycle - DFS
	public boolean hasCycleDirectionalDFS() {
		Node source = nodeMap.get(0);
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		boolean[]recStack = new boolean[nodeMap.size()];
		return hasCycleDirectionalDFSUtil(source,visitedNodes,recStack);
	}
	private boolean hasCycleDirectionalDFSUtil(Node source, HashSet<Integer> visitedNodes, boolean[]recStack) {
		if(source==null) {
			return false;
		}
		if(recStack[source.index]) {
			return true;
		}
		if(visitedNodes.contains(source.index)) {
			return false;
		}
		visitedNodes.add(source.index);
		recStack[source.index]=true;
		for(Node adjacent: source.adjacent) {
			if(hasCycleDirectionalDFSUtil(adjacent,visitedNodes,recStack)) {
				return true;
			}
		}
		recStack[source.index]=false;
		return false;
	}
	
//Count cycle	
	int cycleCount=0;
	List<HashSet<Integer>> cycleList = new ArrayList<HashSet<Integer>>();
	public int countCycleDirectionalDFS() {
		Node source = nodeMap.get(0);
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		return countCycleDirectionalDFSUtil(source,visitedNodes,-1);
	}
	private int countCycleDirectionalDFSUtil(Node source, HashSet<Integer> visitedNodes, int parentIndex) {
		if(source==null) {
			return 0;
		}
		if(visitedNodes.contains(source.index)) {
			if(!cycleList.contains(visitedNodes)) {
				cycleList.add((HashSet<Integer>) visitedNodes.clone());
				cycleCount++;
			}
			return cycleCount;
		}
		visitedNodes.add(source.index);
		for(Node adjacent: source.adjacent) {
			if(parentIndex!=adjacent.index) {
				countCycleDirectionalDFSUtil(adjacent,visitedNodes,source.index);
			}
		}
		visitedNodes.remove(source.index);
		return cycleCount;
	}
	
	public boolean hasCycleUnDirectionalDFS() {
		Node source = nodeMap.get(0);
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		return hasCycleUnDirectionalDFSUtil(source,visitedNodes,-1);
	}
	private boolean hasCycleUnDirectionalDFSUtil(Node source, HashSet<Integer> visitedNodes,int parentIndex) {
		if(source==null) {
			return false;
		}
		if(visitedNodes.contains(source.index)) {
			return true;
		}
		visitedNodes.add(source.index);
		for(Node adjacent: source.adjacent) {
			if(adjacent.index==parentIndex) {
				continue;
			}
			if(hasCycleUnDirectionalDFSUtil(adjacent,visitedNodes,source.index)) {
				return true;
			}
		}
		return false;
	}
	
//Contains cycle - BFS
	public boolean hasCycleUnDirectionalBFS() {
		Node source = nodeMap.get(0);
		int[] parentNodes = new int[nodeMap.size()];
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		Arrays.fill(parentNodes,-1);
		Queue<Node>levelList = new LinkedList<Node>();
		levelList.add(source);
		while(!levelList.isEmpty()) {
			Node current = levelList.poll();
			if(current==null) {
				continue;
			}
			parentNodes[current.index]=1;
			visitedNodes.add(current.index);
			for(Node adjacent:current.adjacent) {
				if(adjacent==null) {
					continue;
				}
				if(visitedNodes.contains(adjacent.index)) {
					continue;
				}
				if(parentNodes[adjacent.index]==0) {
					return true;
				}
				parentNodes[adjacent.index]=0;
				levelList.add(adjacent);
			}
		}
		return false;
	}
	
//Topological Sorting
	public Queue<Node> topologicalSort () {
		Queue<Node> topologicalOrder = new LinkedList<Node>();
		Queue<Node> processQueue = new LinkedList<Node>();
		countInbounds();
		processQueue = getFirstOrderNodes(processQueue);
		return topologicalSortUtil(topologicalOrder,processQueue)?topologicalOrder:new LinkedList<Node>();
	}
	private void countInbounds() {
		Iterator<Entry<Integer,Node>> itr = nodeMap.entrySet().iterator();
		while(itr.hasNext()) {
			Node current = itr.next().getValue();
			for(Node adjacent: current.adjacent) {
				adjacent.inbound++;
			}
		}
		return;
	}
	private Queue<Node> getFirstOrderNodes(Queue<Node> processQueue) {
		Iterator<Entry<Integer, Node>> itr = nodeMap.entrySet().iterator();
		while (itr.hasNext()) {
			Node source=itr.next().getValue();
			if(source.inbound==0) {
				processQueue.add(source);
			}
		}
		return processQueue;
	}
	private boolean topologicalSortUtil(Queue<Node> topologicalOrder,Queue<Node> processQueue) {
		while(!processQueue.isEmpty()) {
			Node source = processQueue.poll();
			for(Node adjacent:source.adjacent) {
				adjacent.inbound--;
				if(adjacent.inbound==0) {
					processQueue.add(adjacent);
				}
			}
			topologicalOrder.add(source);
		}
		return topologicalOrder.size()==nodeMap.size();
	}
	public void printTopolgicallySortedGraph(Queue<Node>orderQueue) {
		while(!orderQueue.isEmpty()) {
			System.out.println(orderQueue.poll().index);
		}
	}
	
//	Dijkstra's Algorithm
	public void addWeightedEdge(int startIndex, int endIndex, int weight, boolean isBidirectional) {
		Node startVertex = nodeMap.get(startIndex);
		if(startVertex==null) {
			startVertex = new Node(startIndex);
		}
		Node endVertex = new Node(endIndex);
		endVertex.weight=weight;
		startVertex.adjacent.add(endVertex);
		nodeMap.put(startIndex, startVertex);
		if(!nodeMap.containsKey(endIndex)) {
			nodeMap.put(endIndex,endVertex);
		}
		if(isBidirectional) {
			endVertex = nodeMap.get(endIndex);
			if(endVertex==null) {
				endVertex = new Node(endIndex);
			}
			startVertex = new Node(startIndex);
			startVertex.weight=weight;
			endVertex.adjacent.add(startVertex);
			nodeMap.put(endIndex, endVertex);
		}
		return;
	}
	
	public void dijkstraShortestPath(int startIndex, int destinationIndex) {
		int[] pathCost = new int[nodeMap.size()];
		Arrays.fill(pathCost,Integer.MAX_VALUE);
		pathCost[startIndex]=0;
		int[] previousNode = new int[nodeMap.size()];
		Arrays.fill(previousNode, -1);
		boolean[] visitedNodes = new boolean[nodeMap.size()];
		PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
		Node start = nodeMap.get(startIndex);
		nodeQueue.add(start);
		while(!nodeQueue.isEmpty()) {
			Node current = nodeQueue.poll();
			current=nodeMap.get(current.index);
			visitedNodes[current.index]=true;
			for(Node adjacent:current.adjacent) {
				if(!visitedNodes[adjacent.index]) {
					if(pathCost[adjacent.index]>pathCost[current.index]+adjacent.weight) {
						pathCost[adjacent.index]=pathCost[current.index]+adjacent.weight;
						previousNode[adjacent.index]=current.index;
						nodeQueue.add(adjacent);
					}
				}
			}
		}
		printShortestPath(previousNode,destinationIndex,startIndex);
		return;
	}
	private void printShortestPath(int[]previousNode, int destinationIndex,int startIndex) {
		if(destinationIndex==startIndex) {
			System.out.println(destinationIndex);
			return;
		}
		printShortestPath(previousNode,previousNode[destinationIndex],startIndex);
		System.out.println(destinationIndex);
		return;
	}
	
//LeetCode: medium	
//Graph problem - number of islands
	public int islands(char[][]grid) {
		int islandCount=0;
		for(int c=0;c<grid[0].length;c++) {
			for(int r=0;r<grid.length;r++) {
				if(grid[r][c]=='1') {
					islandCount++;
					mergeIslands(grid,r,c);
				}
			}
		}
		return islandCount;
	}
	private void mergeIslands(char[][]grid,int r, int c) {
		if(r<0 || r==grid.length || c<0 || c==grid[0].length || grid[r][c]!='1') {
			return;
		}
		//Mark the visited cell;
		grid[r][c]='x';
		mergeIslands(grid,r-1,c);
		mergeIslands(grid,r+1,c);
		mergeIslands(grid,r,c-1);
		mergeIslands(grid,r,c+1);
		return;
	}
	
	public static void main (String[] args) {
		Graph graph = new Graph();
//Create Graph		
//		graph.addEdge(0, 1,true);
//		graph.addEdge(0, 2,true);
//		graph.addEdge(0, 3,true);
////		graph.addEdge(1, 4,true);
//		graph.addEdge(1, 5,true);
//		graph.addEdge(2, 6,true);
//		graph.addEdge(3, 7,true);
//		graph.addEdge(4, 7,true);
//		graph.addEdge(5, 7,true);
//		graph.addEdge(6, 7,true);
//Remove edge
//		graph.removeEdge(0,2);
//		graph.removeEdge(2,0);
//Check connectivity between nodes		
//		System.out.println("Does edge exist between 0 and 2? "+ (graph.edgeExists(7,6) ? "Yes":"No"));
//Find adjacent nodes		
//		graph.findAdjacentNode(0);
		
//Storing names		
//		graph.addEdge("A", "B");
//		graph.addEdge("A", "C");
//		graph.addEdge("A", "D");
		
//Check path - DFS
//		System.out.println("Does path exist between 0 and 6? "+(graph.hasPathDFS(0, 6)?"Yes":"No"));
		
//Check path - BFS
//		System.out.println("Does path exist between 0 and 6? "+(graph.hasPathBFS(0, 1)?"Yes":"No"));
		
//Check cycle - DFS
//		graph.addEdge(0, 1, true);
//		graph.addEdge(0, 2, true);
//		graph.addEdge(1, 3, true);
//		graph.addEdge(3, 4, true);
//		graph.addEdge(2, 1, true);
//		System.out.println("Does cycle exist? "+(graph.hasCycleDirectionalDFS()?"yes":"no"));
//		System.out.println("Does cycle exist? "+(graph.hasCycleUnDirectionalDFS()?"yes":"no"));
//		System.out.println("Number of cycles? "+graph.countCycleDirectionalDFS());
		
//Check cycle - BFS
//		System.out.println("Does cycle exist? "+(graph.hasCycleUnDirectionalBFS()?"yes":"no"));
		
//Topological sort
//		graph.addEdge(0, 1, false);
//		graph.addEdge(0, 2, false);
//		graph.addEdge(2, 1, false);
//		graph.addEdge(3, 2, false);
//		graph.addEdge(3, 1, false);
//		graph.addEdge(3, 1, false);
//		graph.addEdge(4, 5, false);
//		graph.printTopolgicallySortedGraph(graph.topologicalSort());
		
//Dijkstra's shortest path search from a single source
		graph.addWeightedEdge(0, 1, 5, false);
		graph.addWeightedEdge(0, 2, 3, false);
		graph.addWeightedEdge(0, 3, 2, false);
		graph.addWeightedEdge(1, 4, 2, false);
		graph.addWeightedEdge(2, 1, 1, false);
		graph.addWeightedEdge(2, 4, 1, false);
		graph.addWeightedEdge(3, 0, 1, false);
		graph.addWeightedEdge(3, 7, 4, false);
		graph.addWeightedEdge(3, 8, 7, false);
		graph.addWeightedEdge(4, 0, 1, false);
		graph.addWeightedEdge(4, 6, 2, false);
		graph.addWeightedEdge(4, 7, 1, false);
		graph.addWeightedEdge(5, 6, 1, false);
		graph.addWeightedEdge(6, 2, 3, false);
		graph.addWeightedEdge(6, 8, 2, false);
		graph.addWeightedEdge(7, 2, 2, false);
		graph.addWeightedEdge(7, 5, 2, false);
		graph.addWeightedEdge(7, 6, 2, false);
		graph.dijkstraShortestPath(0,8);
		return;
	}
}
