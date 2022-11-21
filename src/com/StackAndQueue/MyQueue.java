package com.StackAndQueue;

public class MyQueue {
	MyStack newStack = new MyStack();
	MyStack oldStack = new MyStack();
	
	public void add(int value) throws StackOutOfBoundException {
		newStack.push(value);
	}
	public int remove() throws StackOutOfBoundException {
		if(oldStack.isEmpty()) {
			shiftElements();
		}
		return oldStack.pop();
	}
	public int peek() throws StackOutOfBoundException {
		if(oldStack.isEmpty()) {
			shiftElements();
		}
		return oldStack.peek();
	}
	private void shiftElements() throws StackOutOfBoundException {
		while(!newStack.isEmpty()) {
			oldStack.push(newStack.pop());
		}
	}
}
