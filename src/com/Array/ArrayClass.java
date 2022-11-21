package com.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ArrayClass {

	private static final String List = null;

	//Remove duplicates in a sorted array
	//	public int removeDuplicates(int[] nums) {
	//		int k=0;
	//        for (int i =0; i<nums.length;i++){
	//            if(i!=0 && nums[i]==nums[i-1]){
	//                continue;
	//            }
	//            else{
	//            nums[k]=nums[i];
	//            k++;
	//            }
	//        }
	//		return k;
	//	}
	//More efficient method:
	public int removeDuplicates(int[] nums) {
		int j=0;
		for(int i=1;i<nums.length;i++){
			if(nums[i]!=nums[j]){
				j++;
				nums[j]=nums[i];
			}
		}
		return j+1;
	}

	//Best Time to Buy and Sell Stock II
	public int maxProfit(int[] prices) {
		int profit=0;
		for (int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1]){
				profit+=prices[i]-prices[i-1];
			}
		}
		return profit;
	}

	//Rotate Array
	//Brute-Force method: Rotating every element every time: O(k*n), O(1)
	//	 public void rotateArray(int[] nums, int k) {
	//		 if(nums.length==0) {
	//			 return;
	//		 }
	//		 k%=nums.length;
	//		 int l=nums.length, temp=0,i;
	//		 while(k>0) {
	//			 i=l-1;
	//			 temp=nums[i];
	//			 while(i>0) {
	//				 nums[i]=nums[i-1];
	//				 i--;
	//			 }
	//			 nums[i]=temp;
	//			 k--;
	//		 }
	//	 }
	//Reversing method: Reversing array in 3 stages: O(n), O(1)
	public void rotateArray(int[] nums, int k) {
		if(nums.length==0) {
			return;
		}
		k%=nums.length;
		//if rotation of last k elements is required.
		reverseArray(nums,0,nums.length);
		reverseArray(nums,0,k);
		reverseArray(nums,k,nums.length);

		//if rotation of first k elements is required.
		//		 reverseArray(nums,0,nums.length);
		//		 reverseArray(nums,0,nums.length-k);
		//		 reverseArray(nums,nums.length-k,nums.length);
	}

	private void reverseArray(int[] nums, int startPoint, int endPoint) {
		int temp=0;
		for(int i=startPoint;i<endPoint;i++) {
			temp=nums[i];
			nums[i]=nums[endPoint-1];
			nums[endPoint-1]=temp;
			endPoint--;
		}
	}

	//Check if array contains duplicates
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=1;i<nums.length;i++) {
			if(nums[i]==nums[i-1]) {
				return true;
			}
		}
		return false;
	}

	//Single number: Find the single number in an array
	public int singleNumber (int[] nums) {
		int a=0;
		for(int i=0;i<nums.length;i++) {
			a^=nums[i];
		}
		//		 for(int i:nums) {
		//			 a^=nums[i];
		//		 }
		return a;
	}

	//Find intersection between two arrays
	public int[] intersect(int[]nums1, int[]nums2) {
		HashMap<Integer,Integer> tempList = new HashMap<Integer,Integer>();
		for(int i=0;i<nums1.length;i++) {
			for(int j=0;j<nums2.length;j++) {
				if(nums2[j]==nums1[i] && !tempList.containsKey(j)){
					tempList.put(j,nums2[j]);
					break;
				}
			}
		}
		int[]result = new int[tempList.size()];
		Collection<Integer> collection =tempList.values();
		ArrayList<Integer> resultList = new ArrayList<Integer>(collection);
		for(int k=0;k<resultList.size();k++) {
			result[k]=resultList.get(k);
		}
		return result;
	}

	public int[] intersectSortedArrays(int[]nums1,int[]nums2) {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int j=0,i=0;
		while(j<nums2.length && i<nums1.length) {
			if(nums1[i]==nums2[j]) {
				resultList.add(nums2[j]);
				j++;
				i++;
				continue;
			}
			if(nums1[i]<nums2[j]) {
				i++;
				continue;
			}
			else {
				j++;
				continue;
			}
		}
		int[]result = new int[resultList.size()];
		for(int k=0;k<result.length;k++) {
			result[k]=resultList.get(k);
		}
		return result;
	}

	//Move zeroes to the end of the Array, maintaining the relative orders of non-zero elements
	public void moveZeroes(int[] nums) {
		if(nums==null) {
			return;
		}
		int j=0,zeroCount=0;
		for(int i =0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[j]=nums[i];
				j++;
			}
			else {
				zeroCount++;
			}
		}
		if(zeroCount>0) {
			for(int i =nums.length-zeroCount;i<nums.length;i++) {
				nums[i]=0;
			}
		}
	}

	//Two sums : given a target, find two indices in array sum of whom equals target
	public int[] twoSums(int[]nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		int diff=0;
		for(int i=0;i<nums.length;i++) {
			diff=target-nums[i];
			if(map.containsKey(diff)) {
				result[0]=map.get(diff);
				result[1]=i;
				break;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	//Valid Sudoku
	public boolean isValidSudoku (char[][]board) {
		if(board==null || board.length!=9 || board[0].length!=9) {
			return false;
		}
		if(verifyRowsAndColumns(board) && verifyBlocks(board)) {
			return true;
		}
		return false;
	}

	//	private boolean verifyColumns(char[][] board) {
	//		 for(int j=0;j<board.length;j++) {
	//			 ArrayList<Character> duplicateList = new ArrayList<Character>();
	//			 for(int i=0;i<board.length;i++) {
	//				 if(board[i][j]!='.') {
	//					 if(board[i][j]>'9' || board[i][j]<'1') {
	//						 return false;
	//					 }
	//					 if(duplicateList.contains(board[i][j])) {
	//						 return false;
	//					 }
	//					 duplicateList.add(board[i][j]);
	//				 }
	//			 }
	//		 }
	//		 return true;
	//	 }
	//	private boolean verifyRows(char[][] board) {
	//		boolean checkRow[] = new boolean[9];
	//		for(int i=0;i<board.length;i++) {
	//			ArrayList<Character> duplicateList = new ArrayList<Character>();
	//			for(int j=0;j<board.length;j++) {
	//				if(board[i][j]!='.') {
	//					if(board[i][j]>'9' || board[i][j]<'1') {
	//						return false;
	//					}
	//					if(duplicateList.contains(board[i][j])) {
	//						return false;
	//					}
	//					duplicateList.add(board[i][j]);
	//				}
	//			}
	//		}
	//		return true;
	//	}
	private boolean verifyBlocks(char[][] board) {
		for(int j=0;j<board.length;j+=3) {
			for(int i=0;i<board.length;i+=3) {
				//ArrayList<Character> duplicateList = new ArrayList<Character>();
				boolean [] verifyBlocks = new boolean[9];
				for(int k=j;k<j+3;k++) {
					for(int l=i;l<i+3;l++) {
						if(board[l][k]!='.') {
							//							if(board[l][k]>'9' || board[l][k]<'1') {
							//								return false;
							//							}
							//							if(duplicateList.contains(board[l][k])) {
							//								return false;
							//							}
							//							duplicateList.add(board[l][k]);

							if(board[l][k]<'1') {
								return false;
							}
							if(verifyBlocks[board[l][k]-'1']) {
								return false;
							}
							else {
								verifyBlocks[board[l][k]-'1']=true;
							}
						}
					}
				}
			}
		}
		return true;
	}


	private boolean verifyRowsAndColumns(char[][]board) {
		for(int j=0;j<board.length;j++) {
			boolean [] checkRows = new boolean[9];
			boolean [] checkColumns = new boolean[9];
			for(int i=0;i<board.length;i++) {
				// Rows verification block
				if(board[j][i]!='.') {
					if(board[j][i]<'1') {
						return false;
					}
					if (checkRows[board[j][i] - '1']) {
						return false;
					}
					else {
						checkRows[board[j][i] - '1'] = true;
					}
				}

				//Columns verification block
				if(board[i][j]!='.') {
					if(board[i][j]<'1') {
						return false;
					}
					if (checkColumns[board[i][j] - '1']) {
						return false;
					}
					else {
						checkColumns[board[i][j] - '1'] = true;
					}
				}
			}
		}
		return true;
	}

	//Rotate image/matrix
	public void rotateMatrix (int[][]matrix) {
		if(matrix==null || matrix[0].length!=matrix.length) {
			return;
		}
		int n=matrix.length,temp=0;
		for(int j=n-1;j>=n/2;j--) {
			for(int i=n-1-j;i<j;i++) {
				temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][i];
				matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
			}
		}
		return;
	}

	//Zero Matrix
	public void setZeroes (int[][]matrix) {
		if(matrix==null) {
			return;
		}
		//Store the status of first row and first column
		boolean isFirstRowZero=false, isFirstColumnZero=false;
		for (int[] ints : matrix) {
			if (ints[0] == 0) {
				isFirstColumnZero = true;
				break;
			}
		}
		for(int j=0;j<matrix[0].length;j++) {
			if(matrix[0][j]==0) {
				isFirstRowZero=true;
			}
		}
		//Search rest of the array and set zeroes in first row and column if required
		for(int i=1;i<matrix.length;i++) {
			for(int j =1;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
		//Iterate through each row and set each element zero if first column is zero
		for(int i=1;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				nullifyRow(matrix,i);
			}
		}
		//Iterate through each column and set each element zero if first row is zero
		for(int j=1;j<matrix[0].length;j++) {
			if(matrix[0][j]==0) {
				nullifyColumn(matrix,j);
			}
		}
		//Set First row and Column according to the initially stored status
		if(isFirstRowZero) {
			nullifyRow(matrix, 0);
		}
		if(isFirstColumnZero) {
			nullifyColumn(matrix,0);
		}
	}

	private void nullifyRow(int[][] matrix, int rowToZero) {
		if(matrix==null) {
			return;
		}
		for(int j =0;j<matrix[0].length;j++) {
			matrix[rowToZero][j]=0;
		}

	}

	private void nullifyColumn(int[][] matrix, int columnToZero) {
		if(matrix==null) {
			return;
		}
		for(int i=0;i<matrix.length;i++) {
			matrix[i][columnToZero]=0;
		}
	}

	//Count submatrices with all ones
	public int numSubMat (int[][] mat) {
		int row = mat.length;
		int column = mat[0].length;
		int[] rowVector = new int[column];
		int totalSum = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(mat[i][j] > 0){
					rowVector[j]++;
					totalSum += rowVector[j]; //Column based increasing
					int minUntilInRow = rowVector[j]; //Row based search
					int k = j-1;
					while(k >=0 && mat[i][k] > 0){
						minUntilInRow = Math.min(minUntilInRow, rowVector[k]);
						totalSum += minUntilInRow;
						k--;
					}
				}
				else{
					rowVector[j] = 0;
				}
			}
		}
		return totalSum;
	}

	//Dominator element & Equi leader counts in array
	public int 	dominator (int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Integer dominater=null;
		int equiLeaderCount=0;
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
				if(map.get(nums[i])>(nums.length/2)) {
					dominater= nums[i];
					//return nums[i];	//For finding Dominator only
				}
			}
			else {
				map.put(nums[i],1);
			}
		}
		if(dominater!=null) {
			int dominaterCount=map.get(dominater);
			int leftHandDominators=0, rightHandDominators=dominaterCount;
			int leftHandElements=0, rightHandElements=nums.length;
			for(int j=0;j<nums.length;j++) {
				leftHandElements++;
				rightHandElements--;
				if(nums[j]==dominater) {
					leftHandDominators++;
					rightHandDominators--;
				}
				if(leftHandDominators>(leftHandElements/2) && rightHandDominators>(rightHandElements/2)) {
					equiLeaderCount++;
				}
			}
		}
		return equiLeaderCount;
	}

	//Tape Equilibrium
	public int tapeEqulibrium(int[] A) {
		int totalSum=0;
		for(int i=0;i<A.length;i++) {
			totalSum+=A[i];
		}
		int leftSum=0,rightSum=totalSum;
		int minSum=Math.abs(totalSum);
		for(int j=0;j<A.length;j++) {
			leftSum+=A[j];
			rightSum-=A[j];
			if(Math.abs(leftSum-rightSum)<minSum) {
				minSum=  Math.abs(leftSum-rightSum);
			}
		}

		return minSum;
	}

	//FrogRiver
	public int frogRiver(int X, int[] A) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		if(A.length==1 && X<=1) {
			return X-1;
		}
		for(int i=0;i<A.length;i++) {
			map.put(A[i], i);
		}
		int remSteps = X;
		for(int j=0;j<A.length;j++) {
			if(!map.isEmpty() && map.containsKey(A[j])) {
				map.remove(A[j]);
				remSteps--;
				if(remSteps==0) {
					return j;
				}
			}
		}
		return -1;
	}

	//Valid permutation of Array
	public int isValidPerm(int[] A) {
		if(A.length==1 && A[0]==1) {
			return 1;
		}
		Arrays.sort(A);
		int nextCount=0;
		for(int i=0;i<A.length;i++) {
			if(nextCount==A[i]-1) {
				nextCount=A[i];
			}
			else {
				return 0;
			}
		}
		return 1;
	}

	//Pair of passing cars
	public int passingCars(int[] A) {
		int pair=0;
		int eastPass=0;
		for(int i=0;i<A.length;i++)
		{
			if(A[i]==0) {
				eastPass++;
			}
			else {
				if(eastPass>0) {
					pair+=+eastPass;
					if(pair>1000000000) {
						return -1;
					}
				}
			}
		}
		return pair;
	}

	//MaxProductOfThree
	public int maxProductOfThree(int[] A) {
		int maxProduct=1;
		int length=A.length;
		Arrays.sort(A);
		int tempProduct1=A[length-1]*A[length-2]*A[length-3];
		int tempProduct2=A[length-1]*A[0]*A[1];
		maxProduct=Math.max(tempProduct1, tempProduct2);
		return maxProduct;
	}

	//Triangle
	public int triangle(int[] A) {
		if(A.length<3) {
			return 0;
		}
		Arrays.sort(A);
		for(int i=A.length-1;i>=2;i--) {
			if((A[i]<(long)(A[i-1]+A[i-2]) && (A[i-1]<(long)A[i]+A[i-2]) && (A[i-2]<(long)A[i]+A[i-1])))
			{
				return 1;
			}
		}
		return 0;
	}

	//MaxProfit
	public int maxProfitUtil(int[] A) {
		if(A.length==0) {
			return 0;
		}
		int minBuyPrice=A[0];
		int maxProfit=0;
		for(int i=1;i<A.length;i++) {
			if(minBuyPrice>A[i]) {
				minBuyPrice=A[i];
			}
			if(A[i]-minBuyPrice>maxProfit) {
				maxProfit=A[i]-minBuyPrice;
			}
		}
		return maxProfit;
	}

	//MaxSlice
	public int maxSlice(int[] A) {
		if(A.length==1) {
			return A[0];
		}
		int currMax=A[0];
		int maxSum=A[0];
		for(int i=1;i<A.length;i++) {
			currMax=Math.max(A[i], currMax+A[i]);
			maxSum=Math.max(maxSum, currMax);
		}
		return maxSum;
	}

	//Missing Integer
	public int missingElement(int[] A) {
		if(A.length==0) {
			return 1;
		}
		ArrayList<Integer> list= new ArrayList<Integer>();
		//USe HashSet instead of ArrayList for faster operations
		for(int i=0;i<A.length;i++) {
			list.add(A[i]);
		}
		for(int i=1;i<=A.length;i++) {
			if(!list.contains(i)) {
				return i;
			}
		}
		return A.length+1;
	}

	//triangle count
	public int triangleCount(int[] A) {

		Arrays.sort(A);
		int tail=0,head=0,mid=0;
		int triangleCount=0;
		for(tail=0;tail<A.length-2;tail++) {
			mid=tail+1;
			head=tail+2;
			while(mid<A.length-1){
				while(head<A.length && A[tail]+A[mid]>A[head]) {
					head++;
				}
				triangleCount+=head-mid-1;
				mid++;
			}
		}
		return triangleCount;
	}

	//Minimum Distances
	public int minimumDistances(int[]a) {
		if(a.length==1) {
			return -1;
		}
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		int minDist=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(map.containsKey(a[i])) {
				if(minDist>i-map.get(a[i])) {
					minDist=i-map.get(a[i]);
				}
			}
			map.put(a[i], i);
		}
		if(minDist==Integer.MAX_VALUE) {
			return -1;
		}
		return minDist;
	}

	//3 Sum
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length;i++) {
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			int j=i+1, k=nums.length-1;
			while(j<=k) {
				if(k<nums.length-1 && nums[k]==nums[k+1]) {
					k--;
					continue;
				}
				if(nums[i]+nums[j]+nums[k]>0) {
					k--;
				}
				else if(nums[i]+nums[j]+nums[k]<0) {
					j++;
				}
				else {
					List<Integer> s = new ArrayList<Integer>();
					s.add(i);
					s.add(j);
					s.add(k);
					result.add(s);
					j++;
					k--;
				}
			}
		}
		return result;
	}

	//Increasing Triplets
	public boolean increasingTriplets(int[] nums) {
		int small=Integer.MAX_VALUE;
		int big=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<=small) {
				small=nums[i];
			}
			else if(nums[i]<=big) {
				big=nums[i];
			}
			else {
				return true;
			}
		}
		return false;
	}

	/*
	 * Find Missing Ranges Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
	 * Output: ["2", "4->49", "51->74", "76->99"]
	 */
	public List<String> missingRanges(int[]nums, int lower, int upper){
		List<String> result = new ArrayList<String>();
		if(lower==Integer.MAX_VALUE) {
			return result;
		}
		int start=lower;
		for(int i=0;i<nums.length;i++) {
			//handle duplicates
			if(i<nums.length-1 && nums[i]==nums[i+1]) {
				continue;
			}
			if(nums[i]==start) {
				start++;
			}
			else {
				String range = getMissingRange(start, nums[i]-1);
				result.add(range);
				if(nums[i]==Integer.MAX_VALUE) {
					return result;
				}
				start=nums[i]+1;
			}
		}
		if(start<=upper) {
			result.add(getMissingRange(start, upper));
		}
		return result;
	}
	private String getMissingRange(int start, int end) {
		if(start==end) {
			return String.valueOf(start);
		}
		String range = String.valueOf(start)+"->"+String.valueOf(end);
		return range;
	}

	/*
	 * Each group should contain a set of indices (i, j, etc), such that the corresponding arrays (a[i], a[j], etc) all have the same mean.
	 * Return the set of groups as an array of arrays, where the indices within each group are sorted in ascending order, and the groups are sorted in
	 * ascending order of their minimum element.
	 * a = [[3, 3, 4, 2], [4, 4], [4, 0, 3, 3], [2, 3], [3, 3, 3]]
	 * the output should be
	 *
	 * meanGroups(a) = [[0, 4], [1], [2, 3]]
	 */
	public int[][] meanValuesGroup (int[][] a){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++) {
			int mean = findMean(a[i]);
			map.put(i,mean);
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[a.length];
		for(int i=0;i<map.size();i++) {
			if(!visited[i]) {
				int value = map.get(i);
				List<Integer> keys = findKey(map, value,visited);
				//Using Streams
				//					List<Integer> keys = map.entrySet().stream()
				//							.filter(e->e.getValue().equals(value))
				//							.map(Map.Entry::getKey)
				//							.sorted()
				//							.collect(Collectors.toList());
				//					if(!list.contains(keys)) {
				list.add(new ArrayList<Integer>(keys));
				//					}
			}
		}
		int[][]result = new int[list.size()][];
		for(int i=0; i<list.size();i++) {
			result[i]=new int[list.get(i).size()];
		}
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				result[i][j]=list.get(i).get(j);
			}
		}
		return result;
	}
	private int findMean(int[] b) {
		int sum=0;
		for(int i=0;i<b.length;i++) {
			sum+=b[i];
		}
		return sum/b.length;
	}
	private List<Integer> findKey(HashMap<Integer,Integer> map, int value,boolean[] visited) {
		List<Integer> keys = new ArrayList<Integer>();
		Iterator<Integer> keyItr = map.keySet().iterator();
		while(keyItr.hasNext()) {
			Integer key = keyItr.next();
			if(map.get(key).equals(value)) {
				keys.add(key);
				visited[key]=true;
			}
		}
		return keys;
	}

	public int fountainActivation(List<Integer> locations) {
		int result=1;
		int n=locations.size();
		int[] range=new int[n];
		//traversing through all the fountain locations and build an array of their max range to their right with their left boundary at index i.
		for(int i=0;i<n;i++) {
			int left=Math.max(i-locations.get(i), 0);
			int right=Math.min(i+locations.get(i)+1, n);
			range[left]=Math.max(range[left], right);
		}
		int right=range[0], next=0;
		//traverse through array and jump to the next range.
		for(int i=0;i<n;i++) {
			next=Math.max(next, range[i]);
			if(i==right) {
				result++;
				right=next;
			}
		}
		return result;
	}

}
