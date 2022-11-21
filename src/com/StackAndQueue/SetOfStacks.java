package com.StackAndQueue;

import java.util.ArrayList;

public class SetOfStacks {
	ArrayList<MyStack> stackList = new ArrayList<MyStack>();
	MyStack currStack = new MyStack();
	public SetOfStacks() {
		stackList.add(currStack);
	}
	
	public void push(int value) throws StackOutOfBoundException {
		if(currStack.isFull()) {
			currStack= new MyStack();
			stackList.add(currStack);
		}
		currStack.push(value);
	}
	public int pop(){
		int value= currStack.pop();
		if(currStack.isEmpty()) {
			stackList.remove(stackList.size()-1);
			currStack=stackList.get(stackList.size()-1);
		}
		return value;
	}
	
	public int popAt(int index) throws StackOutOfBoundException {
		currStack=stackList.get(index);
		int value = pop();
		for(int i=index+1;i<stackList.size();i++) {
			MyStack prevStack = stackList.get(i-1);
			currStack = stackList.get(i);
			int topValue = popFromTop();
			currStack.top--;
			if(currStack.isEmpty()) {
				stackList.remove(currStack);
			}
			prevStack.push(topValue);
		}
		return value;
	}
	
	private int popFromTop() {
		int topValue=currStack.stackElements[0];
		for(int i=1;i<currStack.stackElements.length;i++) {
			if(currStack.stackElements[i]==0) {
				currStack.stackElements[i-1]=0;
				break;
			}
			currStack.stackElements[i-1]=currStack.stackElements[i];
		}
		return topValue;
	}

	public void printStackList() {
		for(int i=0;i<stackList.size();i++) {
			currStack=stackList.get(i);
			for(int j=0;j<10;j++) {
				System.out.println(currStack.stackElements[j]);
			}
		}
	}
	
}
