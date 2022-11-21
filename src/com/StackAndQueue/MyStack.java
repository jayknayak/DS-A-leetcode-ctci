package com.StackAndQueue;

import java.util.EmptyStackException;

//Array implementation
public class MyStack {
	int top=-1;
	int[] stackElements = new int[10];
	
	public void push(int value) throws StackOutOfBoundException {
		if(isFull()) {
			throw new StackOutOfBoundException();
		}
		stackElements[++top]=value;
	}
	public int pop() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int value = stackElements[top];
		stackElements[top]=0;
		top--;
		return value;
	}
	public int peek() {
		return stackElements[top];
	}
	public boolean isFull() {
		if(top==stackElements.length-1) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
}
