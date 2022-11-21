package com.StackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class StackAndQueue {

//Proper nesting of parentheses, braces	, and brackets
	public int solution(String S) {
		if(S.length()==0) {
			return 1;
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)=='(' || S.charAt(i)=='{' || S.charAt(i)=='[') {
				stack.push(S.charAt(i));
			}
			if(S.charAt(i)==')' || S.charAt(i)=='}' || S.charAt(i)==']') {
				if(stack.isEmpty() || !isBalancedPair(stack.peek(),S.charAt(i))) {
					return 0;
				}
				else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty()? 1: 0;
	}

	private boolean isBalancedPair(char openingBrac, char closingBrac) {
		if(openingBrac=='(' && closingBrac==')') {
			return true;
		}
		if(openingBrac=='{' && closingBrac=='}') {
			return true;
		}
		if(openingBrac=='[' && closingBrac==']') {
			return true;
		}
		return false;
	}
	
//Fish
	public int fish (int[]A,int[]B) {
		if(A.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>(); 
		int downStreamFish=0;
		int upStreamFish=0;
		for(int i=0; i<A.length; i++){
			if(B[i] ==1){
				stack.push(A[i]);
				upStreamFish++;
			}
			else{
				downStreamFish++;
				while(!stack.isEmpty()){
					if(stack.peek()>A[i]){
						downStreamFish--;
						break;
					}
					else{
						stack.pop();
						upStreamFish--;
					}
				}
			}  
		}    

		return (downStreamFish+upStreamFish);
	}
	
//StoneWall	
	public int stoneWall(int[] H) {
		Stack<Integer> stack = new Stack<>();
		int blockCount =0;
		for(int i=0;i<H.length;i++){
			while(!stack.isEmpty() && stack.peek()>H[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				stack.push(H[i]);
				blockCount++;
			}
			else {
				if(stack.peek()<H[i]){
					stack.push(H[i]);
					blockCount++;
				}
			}
		}
		return blockCount;
	}
	
//Infix to postfix
	Stack<Character> st = new Stack<Character>();
	public String infixToPrefix(String s) {
		if(s.length()==0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(Character.isLetter(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
			else if(isOpeningBrac(s.charAt(i))) {
				st.push(s.charAt(i));
			}
			else {
				if(isOperator(s.charAt(i))) {
//					while(!st.isEmpty() && !isOpeningBrac(st.peek()) && isOperatorLowPrec(s.charAt(i))) {
//						sb.append(st.pop());
//					}
//					if(isOpeningBrac(st.peek())) {
//						st.pop();
//					}
					if(isOperatorLowPrec(s.charAt(i))) {
						sb=appendExpression(sb);
					}
					st.push(s.charAt(i));
				}
				else{
					sb=appendExpression(sb);
				}
			}
		}
		sb=appendExpression(sb);
		return sb.toString();
	}

	private boolean isOpeningBrac(char c) {
		if(c=='[' || c=='{' || c=='(') {
			return true;
		}
		return false;
	}
	private boolean isOperator(char c) {
		if(c=='*' || c=='/' || c=='-' || c=='+') {
			return true;
		}
		return false;
	}
	private boolean isOperatorLowPrec(char currOp) {
		if(st.isEmpty()) {
			return false;
		}
		else {
			if(isOpeningBrac(st.peek())) {
				return false;
			}
			else if((currOp=='+' || currOp=='-') && (st.peek()=='*' || st.peek()=='/')) {
				return true;
			}
		}
		return false;
	}
	private StringBuilder appendExpression(StringBuilder sb) {
		while(!st.isEmpty() && !isOpeningBrac(st.peek())) {
			sb.append(st.pop());
		}
		if(!st.isEmpty() && isOpeningBrac(st.peek())) {
			st.pop();
		}
		return sb;
	}
	
//Sort Stack
	public void sortStack(Stack<Integer> st) {
		Stack<Integer> st2 = new Stack<Integer>();
		st2.push(st.pop());
		while(!st.isEmpty()) {
			if(st.peek()>st2.peek()) {
				st2.push(st.pop());
			}
			else {
				int tmp=st.pop();
				while(!st2.isEmpty() && tmp<st2.peek()) {
					st.push(st2.pop());
				}
				st2.push(tmp);
			}
		}
		while(!st2.isEmpty()) {
			st.push(st2.pop());
		}
		System.out.println(st.peek());
	}
	
//Equal Stacks
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    	int sumh1 = sum(h1);
    	int sumh2=sum(h2);
    	int sumh3=sum(h3);
    	while(sumh1!=sumh2 || sumh1!=sumh3 || sumh2!=sumh3) {
    		int minSum = Math.min(sumh1, sumh2);
    		minSum = Math.min(minSum, sumh3);
    		while(!h1.isEmpty() && sumh1>minSum) {
    			sumh1-=h1.remove(0);
    		}
    		while(!h2.isEmpty() && sumh2>minSum) {
    			sumh2-=h2.remove(0);
    		}
    		while(!h3.isEmpty() && sumh3>minSum) {
    			sumh3-=h3.remove(0);
    		}
    	}
    	return sumh1;
    }

    private static Integer sum(List<Integer> h) {
    	Integer sum=0;
    	for(int i=0;i<h.size();i++) {
    		sum+=h.get(i);
    	}
    	return sum;
    }
	
//Towers of Hanoi
    public void moveStacks (int n, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination) {
    	if(n<=0) {
    		return;
    	}
    	moveStacks(n-1,source,destination,buffer);
    	moveTop(source,destination);
    	moveStacks(n-1,buffer,source,destination);
    	return;
    }
    private void moveTop(Stack<Integer> source, Stack<Integer> destination) {
    	destination.push(source.pop());
    	return;
    }
}
