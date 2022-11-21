package com.Array;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayClass arrayClass = new ArrayClass(); 
//Remove duplicates in a sorted array		
//		int[] nums= {2,2,3,4,4,4,5};
//		System.out.println(arrayClass.removeDuplicates(nums));

//Best Time to Buy and Sell Stock II
//		int[] prices= {7,1,5,3,6,4};
//		System.out.println(arrayClass.maxProfit(prices));

//Rotate Array
//		int[] nums= {1,2,3,4,5,6,7};
//		arrayClass.rotateArray(nums,2);
		
//Contains duplicates
//		int[] nums= {1,2,3,4,1};
//		System.out.println("Does the array contain duplicates?");
//		System.out.println(arrayClass.containsDuplicate(nums));
		
//Single Number
//		int[]nums= {4,1,2,1,2};
//		System.out.println("Single number in the array:");
//		System.out.println(arrayClass.singleNumber(nums));
		
//Intersection
//		int[]nums1= {54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41};
//		int[]nums2= {17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
//		//arrayClass.intersect(nums1, nums2);
//		arrayClass.intersectSortedArrays(nums1,nums2);
		
//Move zeroes
//		int[]nums= {0,1,0,2};
//		arrayClass.moveZeroes(nums);
		
//Move zeroes
//		int[]nums= {0,4,3,0};
//		arrayClass.twoSums(nums,0);
		
//Valid Sudoku
//		char [][] board =
//				   {{'5','3','.','.','7','.','.','.','.'},
//					{'6','.','.','1','9','5','.','.','.'},
//					{'.','9','8','.','.','.','.','6','.'},
//					{'8','.','.','.','6','.','.','.','3'},
//					{'4','.','.','8','.','3','.','.','1'},
//					{'7','.','.','.','2','.','.','.','6'},
//					{'.','6','.','.','.','.','2','8','.'},
//					{'.','.','.','4','1','9','.','.','5'},
//					{'.','.','.','.','8','.','.','7','9'}};
//		System.out.println("Is the Sudoku Valid?: "+arrayClass.isValidSudoku(board));
		
//Rotate Matrix/Image
//		int[][]matrix = {{1,2,4,7},
//						 {3,6,9,13},
//						 {8,11,5,16},
//						 {14,12,15,10}};
//		arrayClass.rotateMatrix(matrix);
		
//Set Matrix Zeroes
//		int[][]matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
//		arrayClass.setZeroes(matrix);
		
//Count submatrices with all ones
//		int[][]matrix = {{1,0,1},{1,1,0},{1,1,0}};
//		arrayClass.numSubMat(matrix);
		
//Dominating element in array & Equi leader counts
//		int[] nums = {4, 4, 2, 5, 3, 4, 4, 4};
//		System.out.println("Equi leader counts in the array is: "+arrayClass.dominator(nums));
		
//Frog River		
//		int[] nums = {1,3,1,5,2,3,4,4};
//		System.out.println(arrayClass.frogRiver(5,nums));
		
//Valid Permutation
//		int[]nums= {1,3,2};
//		System.out.println("Is valid permutation? "+arrayClass.isValidPerm(nums));
		
//pair of cars
//		int[]A= {0,0,1};
//		System.out.println("Number of pairs: "+arrayClass.passingCars(A));
		
//MaxProductOfThree
//		int[]A= {-3,-1,-2,2,-5,6};
//		System.out.println("Maximum product of triplets: "+arrayClass.maxProductOfThree(A));
		
//Triangle
//		int[]A= {10,5,8};
//		System.out.println("Is Triangle? "+arrayClass.triangle(A));
		
//Max Profit
//		int[]A= {23171,21011,21123,21366,21013,21367};
//		System.out.println("Max profit: "+arrayClass.maxProfitUtil(A));
		
//Max Slice
//		int[]A= {3,-2,6,4,0};
//		System.out.println("Sum of max Slice: "+arrayClass.maxSlice(A));
		
//Missing Integer
//		int[]A= {1};
//		System.out.println("Missing Integer: "+arrayClass.missingElement(A));
		
//TriangleCount
//		int[]A= {10,2,5,1,8,12};
//		System.out.println("No of triangles: "+arrayClass.triangleCount(A));
		
//Minimum Distances
		int[]A= {1,2,3,1,7,8,9,1,20,1};
//		System.out.println("Minimum Distance: "+arrayClass.minimumDistances(A));
		
// Increasing Triplet subsequence
//		int[]nums= {2,4,-2,-3};
//		arrayClass.increasingTriplets(nums);
		
//Missing Ranges
		int[]nums= {0,1,3,50,75};
		List<String> result = arrayClass.missingRanges(nums, 0, 99);
		for(String s:result) {
			System.out.println(s);
		}
	}
}