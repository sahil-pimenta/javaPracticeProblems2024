package practisesessionnov2024.leetcode;

import java.util.Stack;

class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;
	
    public MinStack() {
    	stack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
    	stack.push(val);
    	if(minStack.isEmpty() || val <= minStack.peek())
    	{
    		minStack.push(val);
    	}
    }
    
    public void pop() {
    	if(stack.isEmpty()) return;
    	
    	int top = stack.pop();
    	if(top == minStack.peek())
    	{
    		minStack.pop();
    	}
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}

public class LeetCode11MinimumStack {
	
	public static void main(String args[])
	{
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.push(2);
		minStack.push(0);
		System.out.println("Min>>"+minStack.getMin()); // return 0
		minStack.pop();
		System.out.println("Top>>"+minStack.top());    // return 2
		System.out.println("Min>>"+minStack.getMin()); // return 1
	}
}
