package com.HashTables;
import java.util.ArrayList;
public class HashTable<K,V> {
	private class HashNode<K,V>{
		K key;
		V value;
		HashNode<K,V> next;
		HashNode(K key, V value){
			this.key = key;
			this.value=value;
		}
	}
	ArrayList<HashNode<K,V>>hashTable;
	HashTable (int tableSize){
		this.hashTable = new ArrayList<HashNode<K,V>>();
		hashTable.ensureCapacity(tableSize);
		for(int i=0;i<tableSize;i++) {
			hashTable.add(null);
		}
	}
	public void put(K key, V value) {
		int index = getIndex(key,hashTable.size());
		HashNode<K,V> hashNode = hashTable.get(index);
		//new entry
		if(hashNode==null) {
			hashNode = new HashNode<K,V>(key,value);
			hashTable.set(index, hashNode);
			return;
		}
		//handling duplicate keys
		if(keyPresent(hashNode,key)) {
			hashNode.value=value;
			return;
		}
		//adding new node as head of the LinkedList at the same index
		hashNode = hashTable.get(index);
		HashNode<K,V> newHashNode = new HashNode<K,V>(key,value);
		newHashNode.next = hashNode;
		hashNode = newHashNode;
		hashTable.set(index, hashNode);
		return;
	}
	private int getIndex(K key, int tableSize) {
		int hashCode = getHashCode(key);
		return Math.abs(hashCode%tableSize);
	}
	private int getHashCode(K key) {
		return key.hashCode();
	}
	private boolean keyPresent(HashNode<K,V> hashNode, K key) {
		while(hashNode!=null) {
			if(hashNode.key.equals(key)) {
				return true;
			}
			hashNode=hashNode.next;
		}
		return false;
	}

	public V get(K key) {
		HashNode<K,V> hashNode = hashTable.get(getIndex(key, hashTable.size()));
		while(hashNode!=null) {
			if(hashNode.key.equals(key)) {
				return hashNode.value;
			}
			hashNode=hashNode.next;
		}
		return null;
	}

	public void remove(K key) {
		int index = getIndex(key, hashTable.size());
		HashNode<K,V> hashNode = hashTable.get(index);
		//Deleting head node of LinkedList
		if(hashNode.key.equals(key)) {
			hashNode=hashNode.next;
			hashTable.set(index, hashNode);
		}
		//Deleting child node in LinkedList
		else{
			while(hashNode.next!=null) {
				if(hashNode.next.key.equals(key)) {
					hashNode.next=hashNode.next.next;
					return;
				}
				hashNode=hashNode.next;
			}
		}
		return;
	}

	public Integer size() {
		Integer size=0;
		for(HashNode<K,V> hashNode : hashTable) {
			while(hashNode!=null) {
				size++;
				hashNode=hashNode.next;
			}
		}
		return size;
	}

	public void printHashTable() {
		for(HashNode<K,V> hashNode : hashTable) {
			while(hashNode!=null) {
				System.out.println(hashNode.key + " -> " + hashNode.value);
				hashNode=hashNode.next;
			}
		}
	}

	public static void main(String[]args) {
		HashTable<Integer, Integer> hashTable = new HashTable<>(5);
		hashTable.put(7, 5);
		hashTable.put(4, 35);
		hashTable.put(8, 35);
		hashTable.put(18, 65);
		hashTable.put(2, 25);
		hashTable.put(15, 45);
		hashTable.put(15, 75);
		hashTable.put(1, 85);
		hashTable.put(0, 95);
		hashTable.printHashTable();
		System.out.println("HashTable size:"+hashTable.size());
		hashTable.remove(18);
		System.out.println("HashTable size:"+hashTable.size());
		System.out.println("Value of 15: "+hashTable.get(15));
		System.out.println("Value of 8: "+hashTable.get(8));
		return;
	}
}
