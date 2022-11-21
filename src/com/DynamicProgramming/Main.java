package com.DynamicProgramming;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProgramming dp = new DynamicProgramming();
//		int[] A = {1,-2,0,9,-1,-2};
//		System.out.println("Maximum result achieved on board "+dp.numberSolitaire(A));
		
//Fibonacci Number - Recursion and memoization		
//		System.out.println(dp.fibonacci(5));
		
//Climb stairs
//		System.out.println("Number of ways to climb stairs: "+dp.climbStairs(44));
		
//Best time to buy and sell stock
//		int[] prices= {7,1,5,3,6,4};
//		System.out.println(dp.maxProfitFromDP(prices));
		
//Maximum subarray
//		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		System.out.println("Maximum sum of subarray: "+dp.maxSubArray(nums));
		
//House robber
//		int[] nums = {2,7,9,3,1};
//		System.out.println("Maximum money: "+dp.houseRobber(nums));
		
//Robot in a grid		
//		boolean[][]board = {{true,false},{true,true},{true,true}};
//		System.out.println("Path Count: "+dp.countPaths(board));
		
//Recursive multiplication
//		System.out.println("Multiplication: "+dp.multiply(1, 5));
		
//Generate Parenthesis
//		List<String> parenList = dp.generateParenthesis(4);
//		for(String s : parenList) {
//			System.out.println(s);
//		}
		
//Coin Change
		int[] coins= {2};
//		System.out.println("Number of combinations to represent amount: "+dp.coinChange(coins, 5));
		dp.minCoinChange(coins,3); 
		
//Longest Increasing Subsequence		
//		int[] A = {11,12,13,14,15,6,7,8,101,18};
//		System.out.println("Longest Increasing Subsequence: "+dp.lengthOfLIS(A));
		
//		Jump Game
//		int[] nums= {3,2,1,0,4};
//		dp.canJump(nums);
		return;
	}
}
