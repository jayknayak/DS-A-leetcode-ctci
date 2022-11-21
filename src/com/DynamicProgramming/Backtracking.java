package com.DynamicProgramming;

import java.util.*;

public class Backtracking {
//Find all possible subsets	- Cascading approach
//	public ArrayList<ArrayList<Integer>> findSubsets(int[] nums){
//		return findSubsets(nums,nums.length-1);
//	}
//	private ArrayList<ArrayList<Integer>> findSubsets(int[] nums, int i){
//		ArrayList<ArrayList<Integer>> sets;
//		if(i<0) {
//			sets = new ArrayList<ArrayList<Integer>>();
//			ArrayList<Integer> subset = new ArrayList<Integer>();
//			sets.add(subset);
//			return sets;
//		}
//		sets = findSubsets(nums,i-1);
//		int index = nums[i];
//		ArrayList<ArrayList<Integer>> newSet = new ArrayList<ArrayList<Integer>>();
//		for(ArrayList<Integer> prevSubset:sets) {
//			ArrayList<Integer> newSubset = new ArrayList<Integer>();
//			newSubset.addAll(prevSubset);
//			newSubset.add(index);
//			newSet.add(newSubset);
//		}
//		sets.addAll(newSet);
//		return sets;
//	}
	
	// Backtracking approach
	public List<List<Integer>> subsets(int[] nums) {
		return subsets(nums,0, new ArrayList<List<Integer>>());
	}
	private List<List<Integer>> subsets (int[] nums, int i, List<List<Integer>> output){
		if(i>nums.length) {
			return output;
		}
		backtrack(0, new ArrayList<Integer>(),i, nums, output);
		output=subsets(nums,i+1,output);
		return output;
	}
	private void backtrack(int first, List<Integer> curr, int index, int[] nums, List<List<Integer>> output) {
		// if the combination is done
		if (curr.size() == index) {
			output.add(new ArrayList<Integer>(curr));
			return;
		}
		for (int i = first; i < nums.length; i++) {
			// add i into the current combination
			curr.add(nums[i]);
			// use next integers to complete the combination
			backtrack(i + 1, curr,index, nums,output);
			// backtrack
			curr.remove(curr.size() - 1);
		}
		return;
	}
	
//Permutations w/o duplicates
	public List<List<Integer>> permute (int[] nums){
		return permute(nums,0,new ArrayList<List<Integer>>());
	}
	private List<List<Integer>> permute(int[] nums, int i, List<List<Integer>> permList) {
		List<Integer> subset = new ArrayList<Integer>();
		//		subset.add(nums[i]);
		backtrack(nums,subset,permList);
		//		return permute(nums,i+1,permList);
		return permList;
	}
	private void backtrack(int[]nums, List<Integer> subset, List<List<Integer>> permList) {
		if(subset.size()==nums.length) {
			permList.add(new ArrayList<Integer>(subset));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(!subset.contains(nums[i])) {
				subset.add(nums[i]);
				backtrack(nums,subset,permList);
				subset.remove(subset.size()-1);
//				if(subset.isEmpty()) {
//					break;
//				}
			}
		}
		return;
	}
	
//Generate parenthesis
	public List<String> generateParenthesis (int n){
		return backtrack(n,new ArrayList<String>(),0,0,"");
	}
	private List<String> backtrack (int n, List<String> output, int left, int right, String str){
		if(str.length()==n*2) {
			output.add(str);
			return output;
		}
		if(left<n) {
			backtrack(n,output,left+1,right,str+"(");
		}
		if(right<left) {
			backtrack(n,output,left,right+1,str+")");
		}
		return output;
	}
	
//Letter combinations of a phone number
	HashMap<String,String> phoneMap = new HashMap<String,String>();
	public List<String> letterCombinations (String digits){
		List<String> letterCombinationsList = new ArrayList<String>();
		if(digits.length()==0) {
			return letterCombinationsList;
		}
		phoneMap.put("2","abc");
		phoneMap.put("3","def");
		phoneMap.put("4","ghi");
		phoneMap.put("5","jkl");
		phoneMap.put("6","mno");
		phoneMap.put("7","pqrs");
		phoneMap.put("8","tuv");
		phoneMap.put("9","wxyz");
		return backtrack ("", digits, letterCombinationsList);
	}
	private List<String> backtrack (String combination, String digits, List<String> letterCombinationsList){
		if(digits.length()==0) {
			letterCombinationsList.add(combination);
			return letterCombinationsList;
		}
		String digit = digits.substring(0,1);
		String letters = phoneMap.get(digit);
		for(int i=0;i<letters.length();i++) {
			String letter = letters.substring(i,i+1);
			backtrack(combination+letter,digits.substring(1),letterCombinationsList);
		}
		return letterCombinationsList;
	}
	
//word search in a matrix
	public boolean wordExist (char[][] board, String word) {
		for(int row=0;row<board.length;row++) {
			for(int column=0;column<board[0].length;column++) {
				if(wordExist(board,row,column,word)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean wordExist(char[][]board, int row, int column, String word) {
		if(row<0 || row>=board.length || column<0 || column>=board[0].length) {
			return false;
		}
		if(board[row][column]==word.charAt(0)) {
			char temp = board[row][column];
			board[row][column] = '#';
			word=word.substring(1);
			if(word.length()==0) {
				return true;
			}
			if(wordExist(board, row-1, column, word) || wordExist(board, row+1, column, word) || wordExist(board, row, column-1, word) || wordExist(board, row, column+1, word)) {
				return true;
			}
			board[row][column]=temp;
		}
		return false;
	}
	
//n queens
	public List<Integer[]> nQueens (int gridSize){
		Integer[] columns = new Integer[gridSize];
		Arrays.fill(columns, -1);
		return nQueens (gridSize, 0, columns, new ArrayList<Integer[]>());
	}
	private List<Integer[]> nQueens (int gridSize, int row, Integer[] columns, List<Integer[]> placementList){
		if(row==gridSize) {
			placementList.add(columns.clone());
			return placementList;
		}
		for(int col=0;col<gridSize;col++) {
			if(validPlacement(row,col,columns)) {
				columns[row]=col;
				nQueens(gridSize,row+1,columns,placementList);
			}
		}
		return placementList;
	}
	private boolean validPlacement(int row1, int column1, Integer[] columns) {
		for(int row2=0;row2<row1;row2++) {
			int column2 = columns[row2];
			if(column2==column1) {
				return false;
			}
			int rowDifference = row1-row2;
			int colDifference = Math.abs(column2-column1);
			if(rowDifference==colDifference) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Backtracking bt = new Backtracking();
//		int[] nums = {1,2,3};
//find subsets		
//		List<List<Integer>> sets = bt.subsets(nums);
//		for(List<Integer> subsets: sets) {
//			System.out.println(subsets);
//		}
		
//permutation		
//		List<List<Integer>> sets = bt.permute(nums);
//		for(List<Integer> subsets: sets) {
//			System.out.println(subsets);
//		}
		
//generate parenthesis
//		List<String> output = bt.generateParenthesis(3);
//		for(String s: output) {
//			System.out.println(s);
//		}
		
//Letter Combinations of Phone Number
//		List<String> output = bt.letterCombinations("234");
//		for(String s : output) {
//			System.out.println(s);
//		}
		
//Word search
//		char[][]matrix = {{'A','B','C','E'},
//				 {'S','F','C','S'},
//				 {'A','D','E','E'}};
//		char[][]matrix = {{'C','A','A'},
//				 {'A','A','A'},
//				 {'B','C','D'}};
//		System.out.println("Does word exist? "+(bt.wordExist(matrix, "AAB")?"Yes":"No"));
		
//n queens
		List<Integer[]> result = bt.nQueens(4);
		for(Integer[] row: result) {
			System.out.println(row);
		}
		return;
	}
}
