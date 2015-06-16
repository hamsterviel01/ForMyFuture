import java.util.*;

/**
Lesson learned in this exercise
1. Initialize variables in constructor;
2. Integer.MAX_VALUE
3. When possible, prefer List over Array, difference in performance is unnoticable, but huge improvement in maitainablity + flexibility
*/

//This is my implementation
public class StacksAndQueues32 {
	private int stackSize = 9;
	private int maxStates = 100;
	private int[] stack = new int[stackSize];
	private int head = -1;
	private int min;
	private int[] minArray = new int[maxStates];

	boolean isEmpty(){
		return head == -1;
	}

	boolean isFull(){
		return head == stack.length - 1;
	}

	void setMin(int val){
		if (head == 0){
			min = val;
		}
		if (min > val){
			min = val;
		}
		minArray[head] = min;
		return;
	}

	int returnMin(){
		return minArray[head];
	}
	
	void push(int val) throws Exception {
		if (isFull()){
			throw new Exception("Stack is full");
		}
		head++;
		stack[head] = val;
		setMin(val);
	}

	//how about calculate min in this situation??
	int pop() throws Exception {
		if (isEmpty()){
			throw new Exception("Stack is empty");
		}
		int temp = stack[head];
		head--;
		return temp;
	}

	int peek() throws Exception {
		if (isEmpty()){
			throw new Exception("Stack is empty");
		}
		return stack[head];
	}

	void printStack(){
		if (isEmpty()){
			System.out.println("Stack is empty");
		} else {
			for (int i = 0; i <= head; i++){
				System.out.print(stack[i] + " --> ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
	// StacksAndQueues32 stack = new StacksAndQueues32();
	// 	try {
	// 		stack.printStack();
	// 		stack.push(4);
	// 		stack.printStack();
	// 		stack.push(3);
	// 		stack.push(2);
	// 		stack.push(5);
	// 		stack.push(1);
	// 		stack.printStack();
	// 		System.out.println("Min: " + stack.returnMin());
	// 		stack.push(8);
	// 		stack.push(7);
	// 		stack.printStack();
	// 		System.out.println("Min: " + stack.returnMin());
	// 		stack.pop();
	// 		stack.printStack();
	// 		stack.pop();
	// 		stack.printStack();
	// 		stack.pop();
	// 		stack.printStack();
	// 		System.out.println("Min: " + stack.returnMin());
	// 	} catch (Exception e){
	// 		e.printStackTrace();
	// 	}
		TextBookImplementation stack = new TextBookImplementation();
		try {
			System.out.println(stack);
			stack.push(4);
			System.out.println(stack);
			stack.push(3);
			stack.push(2);
			stack.push(5);
			stack.push(1);
			System.out.println(stack);
			System.out.println("Min: " + stack.returnMin());
			stack.push(8);
			stack.push(7);
			System.out.println(stack);
			System.out.println("Min: " + stack.returnMin());
			stack.pop();
			System.out.println(stack);
			stack.pop();
			System.out.println(stack);
			stack.pop();
			System.out.println(stack);
			System.out.println("Min: " + stack.returnMin());
			stack.pop();
			System.out.println(stack);
			System.out.println("Min: " + stack.returnMin());
			stack.pop();
			System.out.println(stack);
			System.out.println("Min: " + stack.returnMin());
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

//This is textbook implementation.
class TextBookImplementation extends Stack<Integer>{
	Stack<Integer> minStack;

	public TextBookImplementation(){
		minStack = new Stack<Integer>();
	}

	public void push(int val){
		if (val < returnMin()) {
			minStack.push(val);
		}
		super.push(val);
	}

	public Integer pop(){
		if (minStack.peek() == peek()) minStack.pop();
		return super.pop();
	}

	public Integer peek(){
		return super.peek();
	}

	int returnMin(){
		if (minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}
}