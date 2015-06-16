import java.util.*;

/**
Lesson learned in this exercise
1. Think more before writing code, and think modularly, think solution I wrote is quite ok actually.
2. The solution of follow-up part is fine, probably not as efficient as solution in textbook but the code are short and cleaner.
*/

public class StacksAndQueues33 {
	int maxSize;
	ArrayList<Stack<Integer>> stack;
	int count;
	int stackCount;

	public StacksAndQueues33(){
		maxSize = 4;
		count = 0;
		stackCount = 0;
		stack = new ArrayList<Stack<Integer>>();
	}

	public void push(int val){
		//This case hasn't been taken care of: Max size must difference from count
		if (count == maxSize || isEmpty()){
			count = 0;
			stackCount++;
			stack.add(new Stack<Integer>());
		}
		stack.get(stackCount-1).push(val);
		count++;
	}

	public Integer pop(){
		if (isEmpty()) return -1;
		int val = stack.get(stackCount-1).peek();
		stack.get(stackCount-1).pop();
		if (stack.get(stackCount-1).isEmpty()){
			stack.remove(stackCount-1);
			stackCount--;
			count = maxSize;
		}
		return val;
	}

	//Case 1: it is ok for some stack to not operate at its full size
	public Integer popAt(int stackNo){
		int val = stack.get(stackNo-1).pop();
		count--;
		if (stack.get(stackNo-1).isEmpty()){
			stack.remove(stackNo-1);
			stackCount--;
		}
		return val;
	}

	//Case 2: if it is vital for all stack to be operated at its full size
	//Time complexity: O(2n)
	public Integer popAtCaseTwo(int stackNo){
		int val = stack.get(stackNo-1).pop();
		if (stack.get(stackNo-1).isEmpty()){
			stack.remove(stackNo-1);
			stackCount--;
		} else if (stackNo < stackCount){
			Stack<Integer> buffer = new Stack<Integer>();
			int temp = stackCount;
			while (stackCount > stackNo){
				buffer.push(pop());
			}
			System.out.println("buffer: " + buffer);
			//reset value of count to 3, and start pushing values back to stack
			count = 3;
			while (!buffer.isEmpty()){
				push(buffer.pop());
			}
			System.out.println("buffer: " + buffer);
		}
		return val;
	}

	public boolean isEmpty(){
		return stackCount == 0;
	}

	public void printStack(){
		if(isEmpty()){
			System.out.println("Stack is empty");
		} else {
			for (int i=0; i<stackCount; i++){
				System.out.println(stack.indexOf(stack.get(i)) + ": " + stack.get(i));
			}
		}
	}

	public static void main(String[] args){
		StacksAndQueues33 stackBig = new StacksAndQueues33();
		try {
			stackBig.push(4);
			stackBig.printStack();
			stackBig.push(3);
			stackBig.push(2);
			stackBig.push(5);
			stackBig.push(1);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.push(8);
			stackBig.push(7);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.popAtCaseTwo(1);
			stackBig.printStack();
			stackBig.popAtCaseTwo(1);
			stackBig.printStack();
			stackBig.popAtCaseTwo(1);
			stackBig.printStack();
			stackBig.popAtCaseTwo(1);
			stackBig.printStack();
			stackBig.pop();
			stackBig.printStack();
			stackBig.pop();
			stackBig.printStack();
			stackBig.pop();
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.pop();
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.push(9);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.push(10);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.push(11);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.push(12);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
			stackBig.push(13);
			stackBig.printStack();
			System.out.println("Stack count: " + stackBig.stackCount);
		} catch (Exception e){
			e.printStackTrace();
		}

	}
}