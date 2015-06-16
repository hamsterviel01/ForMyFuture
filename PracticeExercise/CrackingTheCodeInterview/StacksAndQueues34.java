import java.util.*;

public class StacksAndQueues34 {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	static Stack<Integer> stack3 = new Stack<Integer>();

	public static void movingDish(Stack from, Stack to, int n){
		if (n == 1){
			stack3.push(stack1.pop());
		}
		movingDish(stack1, stack3, n-1);
		stack2.push(stack1.pop());
		movingDish(stack3, stack1, n-1);
		stack3.push(stack2.pop());
		movingDish(stack1, stack3, n-1);
	}

	public static void main(String[] args){
		for (int i = 5; i >= 0; i--){
			stack1.push(i);
		}
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
		movingDish(stack1, stack3, 5);
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
	}

}