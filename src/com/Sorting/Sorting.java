package com.Sorting;
import java.util.*;
public class Sorting {
//Quick Sort
	public int[] quickSort(int[]A) {
		return quickSortUtil(A,0,A.length-1);
	}
	private int[] quickSortUtil(int[] A, int left, int right) {
		if(left>=right) {
			return A;
		}
		int pivot = A[(left+right)/2];
		int partitionIndex = makePartition (A,left,right,pivot);
		A = quickSortUtil(A,left,partitionIndex-1);
		A = quickSortUtil(A,partitionIndex,right);
		return A;
	}
	private int makePartition (int[]A, int left, int right, int pivot) {
		while(left<=right) {
			while(left<A.length && A[left]<pivot) {
				left++;
			}
			while(right>=0 && A[right]>pivot) {
				right--;
			}
			if(left<=right) {
				A = swapElements(A,left,right);
				left++;
				right--;
			}
		}
		return left;
	}
	private int[] swapElements (int[] A, int left, int right) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
		return A;
	}
	
//Merge Sort
	public int[] mergeSort (int[] A) {
		return mergeSort(A,new int[A.length], 0 ,A.length-1);
	}
	private int[] mergeSort(int[] A, int[] temp, int left, int right) {
		if(left>=right) {
			return A;
		}
		int mid = (left+right)/2;
		A = mergeSort(A, temp, left, mid);
		A = mergeSort(A, temp, mid+1, right);
		return mergeSort(A, temp, left, mid, right);
	}
	private int[] mergeSort(int[] A, int[] temp, int left, int mid, int rightEnd) {
		int leftStart = left;
		int rightStart = mid+1;
		int tempIndex = leftStart;
		while(leftStart<=mid && rightStart <= rightEnd) {
			if(A[leftStart]<A[rightStart]) {
				temp[tempIndex] = A [leftStart];
				leftStart++;
			}
			else {
				temp[tempIndex] = A[rightStart];
				rightStart++;
			}
			tempIndex++;
		}
		while(leftStart<=mid) {
			temp[tempIndex]=A[leftStart];
			tempIndex++;
			leftStart++;
		}
		while(rightStart<=rightEnd) {
			temp[tempIndex]=A[rightStart];
			tempIndex++;
			rightStart++;
		}
		for(int i=left;i<=rightEnd;i++) {
			A[i]=temp[i];
		}
		return A;
	}
	
//Selection Sort
	public int[] selectionSort(int[] A) {
		for(int i=0;i<A.length;i++) {
			int minIndex = findMinIndex(A,i);
			A = swapElements(A, i, minIndex);
		}
		return A;
	}
	private int findMinIndex(int[]A, int minIndex) {
		for(int j=minIndex+1;j<A.length;j++) {
			if(A[j]<A[minIndex]) {
				minIndex=j;
			}
		}
		return minIndex;
	}
	
//Bubble Sort
	public int[] bubbleSort(int[] A) {
		for(int i=0; i<A.length-1; i++) {
			boolean sortNeeded = false;
			for(int j=1; j<=A.length-i-1; j++) {
				if(A[j]<A[j-1]) {
					sortNeeded=true;
					swapElements(A, j, j-1);
				}
			}
			if(!sortNeeded) {
				break;
			}
		}
		return A;
	}
	
//Insertion sort
	public int[] insertionSort(int[]A) {
		for(int i=1;i<A.length;i++) {
			int unsortedIndex = i;
			while(unsortedIndex>0 && A[unsortedIndex]<A[unsortedIndex-1]) {
				swapElements(A, unsortedIndex, unsortedIndex-1);
				unsortedIndex=unsortedIndex-1;
			}
		}
		return A;
	}
	
//Merge two sorted arrays	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int left=m-1,right=n-1,sortedIndex=m+n-1;
		while(right>=0){
			if(left>=0 && nums1[left]>nums2[right]) {
				nums1[sortedIndex]=nums1[left];
				left--;
			}
			else {
				nums1[sortedIndex]=nums2[right];
				right--;
			}
			sortedIndex--;
		}
	}
	
//First bad version
	public int firstBadVersion (int n) {
		int start = 1;
		int end = n;
		while(start<end) {
			int mid = start+((end-start)/2);
			if(isBadVersion(mid)) {
				end=mid;
			}
			else {
				start = mid+1;
			}
		}
		return start;
	}
	private boolean isBadVersion(int i) {
		if(i>=9) {
			return true;
		}
		return false;
	}
	
//Magic index - i=A[i]
	public int findMagicIndex(int[] A) {
		return findMagicIndex(A, 0, A.length-1);
	}
	private int findMagicIndex(int[] A, int left, int right) {
		if(left>right) {
			return -1;
		}
		int mid = (left+right)/2;
		if(A[mid]==mid) {
			return mid;
		}
		int leftIndex = findMagicIndex(A,left,mid-1);
		if(leftIndex>=0) {
			return leftIndex;
		}
		int rightIndex = findMagicIndex(A,mid+1,right);
		return rightIndex;
	}

////LeetCode - Medium	
//Top K Frequent Elements
	public int[] topKFrequentElems(int[] nums, int k) {
		//Map total counts with each element
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		//Build Priority Queue - lowest count on top
		Queue<Integer> queue = new PriorityQueue<Integer>((num1,num2)->map.get(num1).compareTo(map.get(num2)));
		for(int num: map.keySet()) {
			queue.add(num);
			//maintain queue size to k
			if(queue.size()>k) {
				queue.poll();
			}
		}
		int[] result = new int[k];
		for(int i=k-1;i>=0;i--) {
			result[i]=queue.poll();
		}
		return result;
	}
		
//Kth largest element
	public int kthLargestElement(int[]A, int k) {
		A=quickSort(A);
		return A[A.length-k];
	}
	
//Peak Element
	public int findPeakElement(int[]nums) {
		return findPeakElement(nums,0,nums.length-1);
	}
	private int findPeakElement(int[] nums, int start, int end) {
		if(start==end) {
			return start;
		}
		int mid = (start+end)/2;
		if(mid<nums.length && nums[mid]>nums[mid+1]) {
			return findPeakElement(nums,start,mid);
		}
		else {
			return findPeakElement(nums,mid+1,end);
		}
	}
	
//	Search for a Range
	public int[] searchRange(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;
		while(left<right) {
			int mid = (left+right)/2;
			if(nums[mid]<target) {
				left=mid+1;
			}
			else {
				right=mid;
			}
		}
		if(left<nums.length && nums[left]==target) {
			int first = left;
			left=0;
			right=nums.length-1;
			while(left<right) {
				int mid=((left+right)/2)+1;
				if(nums[mid]>target) {
					right=mid-1;
				}
				else {
					left=mid;
				}
			}
			return new int[]{first,right};
		}
		return new int[] {-1,-1};
	}
	
//	Merge Intervals
	public int[][] mergeIntervals(int[][]nums){
		Arrays.sort(nums, (num1,num2)->Integer.compare(num1[0], num2[0]));
		LinkedList<int[]>merged=new LinkedList<int[]>();
		for(int[]num:nums) {
			//if merged is empty or no overlap - append interval
			if(merged.isEmpty() || merged.getLast()[1]<num[0]) {
				merged.add(num);
			}
			//overlapping interval - modify last merge
			else {
				merged.getLast()[1]=Math.max(merged.getLast()[1], num[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
	
//Search in Rotated Sorted Array
	public int searchRotatedSortedArray(int[] nums, int target) {
		return searchRotatedSortedArray(nums,target,0,nums.length-1);
	}
	private int searchRotatedSortedArray(int[] nums, int target, int left, int right) {
		if(left>right) {
			return -1;
		}
		int mid = left+((right-left)/2);	//better practice
		if(nums[mid]==target) {
			return mid;
		}
		if(nums[left]<=nums[mid]) {
			if(nums[left]<=target && nums[mid]>target) {
				return searchRotatedSortedArray(nums,target,left,mid-1);
			}
			else {
				return searchRotatedSortedArray(nums,target,mid+1,right);
			}
		}
		else {
			if(nums[right]>=target && nums[mid]<target) {
				return searchRotatedSortedArray(nums,target,mid+1,right);
			}
			else {
				return searchRotatedSortedArray(nums,target,left,mid-1);
			}
		}
	}
	
/*
* Meeting RoomsII - Given an array of meeting time intervals consisting of
* start and end times [[s1,e1],[s2,e2],...] find the minimum number of
* conference rooms required.
*/
	
/*
 * Solution :When a room is taken, the room can not be used for anther meeting
 * until the current meeting is over. As soon as the current meeting is
 * finished, the room can be used for another meeting. We can sort the meetings
 * by start timestamps and sequentially assign each meeting to a room. Each time
 * when we assign a room for a meeting, we check if any meeting is finished so
 * that the room can be reused. In order to efficiently track the earliest
 * ending meeting, we can use a min heap. Whenever an old meeting ends before a
 * new meeting starts, we reuse the room (i.e., do not add more room).
 * Otherwise, we need an extra room (i.e., add a room).
 */	
	public int minMeetingRooms(int[][]intervals) {
		Arrays.sort(intervals, (interval1,interval2)->Integer.compare(interval1[0], interval2[0]));
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int count=0;
		for(int[]interval:intervals) {
			if(queue.isEmpty()) {
				queue.add(interval[1]);
				count++;
			}
			else {
				//Reusing room
				if(queue.peek()<=interval[0]) {
					queue.poll();
				}
				else {
					count++;
				}
				queue.add(interval[1]);
			}
		}
		return count;
	}
	
//	Search 2D matrix II
	public boolean searchMatrix(int[][]matrix, int target) {
		int i=0,j=matrix[0].length-1;
		while(i<matrix.length && j>=0) {
			if(matrix[i][j]<target) {
				i++;
			}
			else if(matrix[i][j]>target) {
				j--;
			}
			else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Sorting sort = new Sorting();
		int[] A = {3,2,1,5,6,4};
		
//Quick Sort		
//		A = sort.quickSort(A);
		
//Merge Sort
//		A = sort.mergeSort(A);
		
//Selection sort
//		A = sort.selectionSort(A);
		
//Bubble Sort
//		A = sort.bubbleSort(A);
		
//Insertion Sort
//		A=sort.insertionSort(A);
		
//Merge Two Sorted arrays
//		int[]nums1= {1};
//		int[]nums2= {};
//		sort.merge(nums1, 1, nums2, 0);
		
//First Bad Version
//		System.out.println("First bad version: "+sort.firstBadVersion(16));
		
//Find Magic Index
//		int[] A = {-10,-5,2,2,2,3,4,5,7,8,10};
//		System.out.println("Magic Index: "+sort.findMagicIndex(A));
		
//Kth Largest Element
		int k = sort.kthLargestElement(A,4);
		return;
	}
}
