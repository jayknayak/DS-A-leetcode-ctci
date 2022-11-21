package com.DynamicProgramming;

import java.util.*;

public class DynamicProgramming {
//Number Solitaire	
	public int numberSolitaire(int[] A) {

        // main idea:
        // using "dynamic programming" to build up the solution
        // (bottom up)
        
        int[] dp = new int[A.length];
        dp[0] = A[0];

        // build up from "dp[1], dp[2], ..., dp[A.length-1]"
        for(int i=1; i<A.length; i++){
            
            // keep the biggest one 
            // be very careful: could be negtive (so use Integer.MIN_VALUE)
            int max = Integer.MIN_VALUE;
            
            // a die could be "1 to 6" 
            for(int die=1; die<=6; die++){
                if( i-die >= 0){
                    // very important: not "A[i-die]+A[i]"
                    // instead, have to use "dp[i-die]+A[i]"
                    max = Math.max( dp[i-die]+A[i], max );
                    // dynamic programming:
                    // take the best:
                    // takeBest( dp[i-j] + value[j], curBest )
                }
            }    
            dp[i] = max; // keep the best one as the dp value    
        }
        
        return dp[A.length-1];
    }
	
//Fibonacci Number
//	public int fibonacci(int i) {
//		if(i==0 || i==1) {
//			return i;
//		}
//		return fibonacci(i-1)+fibonacci(i-2);
//	}
	public double fibonacci(double i) {
		return fibonacci(i,new double[(int) (i+1)]);
	}
	private double fibonacci(double i, double[] nums) {
		if(i==0) {
			return (double) 0;
		}
		if(i==1) {
			return (double) 1;
		}
		if(nums[(int) i]>0) {
			return nums[(int) i];
		}
		nums[(int) i]= fibonacci(i-1,nums) + fibonacci(i-2,nums);
		return nums[(int) i];
	}
	
//Climbing Stairs
	public int climbStairs (int n) {
		return climbStairs (0,n, new int[n]);
	}
	private int climbStairs (int i, int n, int[] waysArray) {
		if(i>n) {
			return 0;
		}
		if(i==n) {
			return 1;
		}
		if(waysArray[i]>0) {
			return waysArray[i];
		}
		waysArray[i]=climbStairs(i+1,n,waysArray) + climbStairs(i+2,n,waysArray);
		return waysArray[i];
	}
	
//Best Time to Buy and Sell Stock
	public int maxProfitFromDP(int[] prices) {
		int maxProfit=0;
		int minBuy=0;
		for (int i=1;i<prices.length;i++){
			if(prices[i]<prices[minBuy]) {
				minBuy=i;
				continue;
			}
			else if(prices[i]>prices[minBuy] && maxProfit<(prices[i]-prices[minBuy])) {
				maxProfit=prices[i]-prices[minBuy];
			}
		}
		return maxProfit;
	}
		 
//Maximum subarray
	public int maxSubArray(int[] nums) {
		int maxSum=nums[0];
		int currSum=0;
		for(int i=0;i<nums.length;i++) {
			if(currSum<0) {
				currSum=0;
			}
			currSum+=nums[i];
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}
	
//	public int maxSubArray(int[] nums) {
//		int start=1, end=nums.length-1;
//		return maxSubArray(nums,start,end,nums[0]);
//	}
//	private int maxSubArray(int[] nums, int start, int end, int maxSum) {
//		if(start>=end) {
////			int currSum = maxSum+nums[end];
////			if(currSum<0) {
////				currSum=0;
////			}
//			return maxSum+nums[end];
//		}
//		int mid = (start+end)/2;
//		int localSum = maxSubArray(nums,start,mid,maxSum);
//		if(localSum<0) {
//			return 0;
//		}
//		localSum = maxSubArray(nums,mid+1,end,localSum);
//		maxSum = Math.max(maxSum, localSum);
//		return maxSum;
//	}
	
	public int houseRobber (int[] nums) {
		if(nums.length==0) {
			return 0;
		}
//		if(nums.length==1) {
//			return nums[0];
//		}
//		else if(nums.length==2) {
//			return Math.max(nums[0], nums[1]);
//		}
//		int[] money = new int[nums.length];
//		money[0]=nums[0];
//		money[1]=Math.max(nums[0], nums[1]);
		int a =0,b=0;
//		int a=nums[0];
//		int b= Math.max(nums[0],nums[1]);
		for(int i=0;i<nums.length;i++) {
//			money[i]=Math.max(nums[i]+money[i-2], money[i-1]);
			int c=Math.max(nums[i]+a, b);
			a=b;
			b=c;
		}
//		return money[nums.length-1];
		return b;
	}
	
//Robot in a grid - count paths
	public int countPaths (boolean[][] board) {
		if(board.length==0 || board[0].length==0) {
			return 0;
		}
		return countPaths(board, 0,0, new int[board.length][board[0].length]);
	}
	private int countPaths(boolean[][]board, int row, int column, int[][]visitedBlocks) {
		if(!validBlock(board,row,column)) {
			return 0;
		}
		if(row==board.length-1 && column==board[0].length-1) {
			return 1;
		}
		if(visitedBlocks[row][column]>0) {
			return visitedBlocks[row][column];
		}
		visitedBlocks[row][column] = countPaths(board,row+1,column,visitedBlocks)+countPaths(board,row,column+1,visitedBlocks);
		return visitedBlocks[row][column];
	}
	private boolean validBlock(boolean[][]board, int row, int column) {
		if(row>board.length-1) {
			return false;
		}
		else if(column>board[0].length-1) {
			return false;
		}
		else if(!board[row][column]) {
			return false;
		}
		return true;
	}
	
//Recursive Multiply - multiply two positive integers w/o * operator
//	public int multiply (int a,int b) {
//		int smaller = Math.min(a, b);
//		return multiply(smaller, Math.max(a, b), new int[smaller+1]);
//	}
//	private int multiply (int smaller, int bigger, int[] memo) {
//		if(smaller==0) {
//			return 0;		//0*bigger = 0
//		}
//		if(smaller==1) {
//			return bigger;	//1*bigger = bigger
//		}
//		if(memo[smaller]>0) {
//			return memo[smaller];
//		}
//		/* Compute half. If uneven, compute other half. If even, double it. */
//		int smallerHalf = smaller>>1;
//		int product1 = multiply(smallerHalf,bigger,memo);
//		int product2=product1;
//		if(smallerHalf%2==1) {
//			product2=multiply(smaller-smallerHalf,bigger,memo);
//		}
//		memo[smaller]=product1+product2;
//		return memo[smaller];
//	}
	
	//another approach - add bigger to the sum of two products if uneven - 31*33 = 2*(15*33) + 33
	public int multiply (int a,int b) {
		return multiplyUtil(Math.min(a, b), Math.max(a, b));
	}
	private int multiplyUtil (int smaller, int bigger) {
		if(smaller==0) {
			return 0;
		}
		if(smaller==1) {
			return bigger;
		}
		int smallerHalf = smaller>>1;
		int product = multiplyUtil(smallerHalf,bigger);
		if(smallerHalf%2==0) {
			return product+product;
		}
		else {
			return product+product+bigger;
		}
	}
	
//Generate parenthesis: n=1 -> (), n=2 -> (()), ()(), n=3 -> ((())), (()()), (())(), ()(()), ()()()
	public List<String> generateParenthesis(int n){
		List<String> parenthesisList = new ArrayList<String>();
		if(n==0) {
			parenthesisList.add("");
			return parenthesisList;
		}
		List<String> previousParenthesisList = generateParenthesis(n-1);
		for(String s: previousParenthesisList) {
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') {
					String leftSubstring = s.substring(0,i+1);
					String rightSubstring = s.substring(i+1,s.length());
					String str = leftSubstring + "()" + rightSubstring;
					if(!parenthesisList.contains(str)) {
						parenthesisList.add(str);
					}
				}
			}
			parenthesisList.add(s + "()");
		}
		return parenthesisList;
	}
	
//Coin change - all possible combinations
	public int coinChange (int[] coins, int amount) {
		return coinChange(coins,amount,0, new int[amount+1][coins.length]);
	}
	private int coinChange(int[]coins,int amount, int i, int[][]memo) {
		if(i==coins.length) {
			return 0;
		}
		if(amount<0) {
			return 0;
		}
		if(amount==0) {
			return 1;
		}
		if(memo[amount][i]>0) {
			return memo[amount][i];
		}
//		int combCount = 0;
//		for(int i=0;i<coins.length;i++) {
		memo[amount][i]= coinChange(coins,amount-coins[i],i,memo) + coinChange(coins,amount,i+1,memo);
//		}
//		memo[amount]=combCount;
		return memo[amount][i];
	}
	
//Coin Change - minimum coins
	public int minCoinChange(int[]coins,int amount) {
		return minCoinChange(coins,  amount, new int[amount+1]);
	}
	private int minCoinChange(int[] coins, int amount, int[]dp) {
		Arrays.fill(dp, amount+1);
		dp[0]=0;
		for(int i=1;i<=amount;i++) {
			for(int coin:coins) {
				if(coin<=i) {
					dp[i]=Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		return dp[amount]>amount?-1:dp[amount];
	}
	
//	Longest Increasing subsequence
	public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> s=new ArrayList<Integer>();
        s.add(nums[0]);
        for(int i=1;i<nums.length;i++){
        	if(s.size()==0 || nums[i]>s.get(s.size()-1)) {
        		s.add(nums[i]);
        	}
        	else {
        		int start=0;
        		int end=s.size()-1;
        		while(start<=end) {
        			int mid = (start+end)/2;
        			if(s.get(mid)<nums[i]) {
        				start=mid+1;
        			}
        			else {
        				end=mid-1;
        			}
        		}
        		s.set(start, nums[i]);
        	}
        }
        return s.size();
    }
	
//Longest Common Subsequence
	public int longestCommonSubsequence(String a, String b) {
		int m=a.length(), n=b.length();
		int[][]dp=new int[m+1][n+1];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}
				else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[m][n];
	}
	
//LeetCode: Medium
//Jump game : Greedy Approach
	public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (lastPos<=i + nums[i]) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
