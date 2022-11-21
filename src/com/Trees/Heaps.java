package com.Trees;

import java.util.Arrays;

public class Heaps {
//Min Heap
	public int[] insertMinHeap(int[] nums, int size, int data) {
		nums=ensureExtraSize(nums,size);
		nums[size]=data;
		nums=heapifyUp(nums,size);
		return nums;
	}
	private int[] ensureExtraSize(int[] nums, int size) {
		if(size==nums.length) {
			nums = Arrays.copyOf(nums, nums.length*2);
		}
		return nums;
	}
	private int[] heapifyUp(int[] nums, int nodeIndex) {
		while(nodeIndex>0) {
			int parentIndex = (int) Math.floor((nodeIndex-1)/2);
			if(nums[nodeIndex]<nums[parentIndex]) {
				nums=swapElements(nums,nodeIndex,parentIndex);
				nodeIndex=parentIndex;
			}
			else {
				break;
			}
		}
		return nums;
	}
	private int[] swapElements(int[]nums, int firstIndex, int secondIndex) {
		if(firstIndex<nums.length && secondIndex<nums.length) {
			int temp = nums[firstIndex];
			nums[firstIndex]=nums[secondIndex];
			nums[secondIndex]=temp;
		}
		return nums;
	}
	
	public int[] deleteMinHeap (int[]nums, int size) {
		nums[0]=nums[size-1];
		nums[size-1]=0;
		size--;
		nums=heapifyDown(nums, size);
		return nums;
	}
	private int[] heapifyDown(int[]nums, int size) {
		int i=0;
		while(i<size) {
			if(!hasLeftChild(i,size)) {
				break;
			}
			int leftChildIndex = i*2+1;
			int rightChildIndex = i*2+2;
			int smallerChildIndex = leftChildIndex;
			if(hasRightChild(i,size) && nums[leftChildIndex]>nums[rightChildIndex]) {
				smallerChildIndex=rightChildIndex;
			}
			if(nums[smallerChildIndex]<nums[i]) {
				nums=swapElements(nums, i, smallerChildIndex);
				i=smallerChildIndex;
			}
			else {
				break;
			}
		}
		return nums;
	}
	private boolean hasLeftChild(int i, int size) {
		if((i*2+1)>size-1) {
			return false;
		}
		return true;
	}
	private boolean hasRightChild(int i, int size) {
		if((i*2+2)>size-1) {
			return false;
		}
		return true;
	}
	
//Max Heap
	int[] nums = new int[10];
	int size = 0;
	public void insertMaxHeap(int data) {
		ensureExtraSize();
		nums[size]=data;
		size++;
		heapifyUp();
		return;
	}
	private void ensureExtraSize() {
		if(size==nums.length) {
			nums = Arrays.copyOf(nums, nums.length*2);
		}
		return;
	}
	private void heapifyUp() {
		int targetIndex = size-1;
		while(targetIndex>0) {
			int parentIndex = (int)Math.floor((targetIndex-1)/2);
			if(nums[parentIndex]<nums[targetIndex]) {
				swapElements(nums, targetIndex, parentIndex);
				targetIndex=parentIndex;
			}
			else {
				break;
			}
		}
		return;
	}
	public void deleteMaxHeap() {
		nums[0]=nums[size-1];
		nums[size-1]=0;
		size--;
		maxHeapifyDown(nums, size,0);
		return;
	}
	private void maxHeapifyDown(int[]nums, int size, int targetIndex) {
		//int targetIndex=0;
		while(hasLeftChild(targetIndex,size)) {
			int biggerChildIndex = targetIndex*2+1;
			int rightChildIndex = targetIndex*2+2;
			if(hasRightChild(targetIndex,size) && nums[rightChildIndex]>nums[biggerChildIndex]) {
				biggerChildIndex=rightChildIndex;
			}
			if(nums[targetIndex]<nums[biggerChildIndex]) {
				swapElements(nums, targetIndex, biggerChildIndex);
				targetIndex=biggerChildIndex;
			}
			else {
				break;
			}
		}
		return;
	}
	
//Sorting array in ascending order	
	int[] A = {15,5,20,1,17,10,30};
	int heapSize=A.length;
	public void heapSort() {
		//Create maxHeap
		for(int i=(heapSize/2)-1; i>=0; i--) {
			maxHeapifyDown(A, heapSize,i);
		}
		//Delete maxHeap
		while(heapSize>1) {
			swapElements(A, 0, heapSize-1);
			heapSize--;
			maxHeapifyDown(A, heapSize, 0);
		}
	}
}