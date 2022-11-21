package com.Trees;

import java.util.HashMap;

public class Trie {
	private class TrieNode{
		HashMap<Character,TrieNode> child;
		boolean isEnd;
		int size;
		TrieNode(){
			child = new HashMap<Character,TrieNode>();
			isEnd = false;
			size=0;
		}
	}
	TrieNode root;
	Trie(){
		root = new TrieNode();
	}
	public void insertTrieNode(String word) {
//		if(current==null) {
//			current = new Trie();
//		}
		insertTrieNodeUtil(root, word,0);
		return;
	}
	private void insertTrieNodeUtil(TrieNode current, String word,int i) {
		current.size++;
		if(i==word.length()) {
			current.isEnd=true;
			return;
		}
		char c = word.charAt(i);
		TrieNode trieNode = current.child.get(c);
		if(trieNode==null) {
			trieNode = new TrieNode();
			current.child.put(c,trieNode);
		}
		insertTrieNodeUtil(trieNode, word, i+1);
		return;
	}
	
	public boolean searchTrieNode(String word) {
		return searchTrieNodeUtil(root, word,0);
	}
	private boolean searchTrieNodeUtil(TrieNode current, String word,int i) {
		if(i==word.length()) {
			return current.isEnd;
		}
		char c = word.charAt(i);
		TrieNode trieNode = current.child.get(c);
		if(trieNode==null) {
			return false;
		}
		return searchTrieNodeUtil(trieNode, word,i+1);
	}
	
	public boolean searchPrefixTrieNode(String word) {
		return searchPrefixTrieNodeUtil(root, word,0);
	}
	private boolean searchPrefixTrieNodeUtil(TrieNode current, String word,int i) {
		if(i==word.length()) {
			return current.child.size()>=0;
		}
		char c = word.charAt(i);
		TrieNode trieNode = current.child.get(c);
		if(trieNode==null) {
			return false;
		}
		return searchPrefixTrieNodeUtil(trieNode, word,i+1);
	}
	
	public void delete(String word) {
		deleteUtil(root,word,0);
	}
	private boolean deleteUtil(TrieNode current, String word, int i) {
		if(i==word.length()) {
			if(!current.isEnd) {
				return false;
			}
			current.isEnd=false;
			return current.child.size()==0;
		}
		char c = word.charAt(i);
		TrieNode trieNode = current.child.get(c);
		if(trieNode==null) {
			return false;
		}
		boolean deleteCurrentNode = deleteUtil(trieNode, word, i+1);
		if(deleteCurrentNode) {
			current.child.remove(c);
			if(!current.isEnd) {
				return current.child.size()==0;
			}
		}
		return false;
	}
	
	public int countPrefixTrieNode(String word) {
		return countPrefixTrieNodeUtil(root, word,0);
	}
	private int countPrefixTrieNodeUtil(TrieNode current, String word,int i) {
		if(i==word.length()) {
			return current.size;
		}
		char c = word.charAt(i);
		TrieNode trieNode = current.child.get(c);
		if(trieNode==null) {
			return 0;
		}
		return countPrefixTrieNodeUtil(trieNode, word,i+1);
	}
}
