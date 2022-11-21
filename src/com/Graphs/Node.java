package com.Graphs;

import java.util.*;

public class Node implements Comparable<Node> {
	int index;
	String name;
	int weight;
	List<Node> adjacent = new ArrayList<Node>();
	int inbound;
	Node(int index){
		this.index=index;
	}
	//Storing Names
//	Node(String name){
//		this.name=name;
//	}
	Integer getWeight(){
		return this.weight;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.getWeight().compareTo(node.getWeight());
	}
}
