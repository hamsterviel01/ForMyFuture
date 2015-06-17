import java.util.*;

//This solution has complexity of 0(3^N)
public class StacksAndQueues34 {
	//stack1 = from
	//stack3 = to
	//stack2 = middle
	public static void movingDish(Stack from, Stack to, Stack middle, int n){
		if (n == 1){
			to.push(from.pop());
		} else {
			movingDish(from, to, middle, n-1);
			middle.push(from.pop());
			movingDish(to, from, middle, n-1);
			to.push(middle.pop());
			movingDish(from, to, middle, n-1);
		}
	}

	public static void main(String[] args){
		int stackSize = 20;
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();

		for (int i = stackSize; i >= 1; i--){
			stack1.push(i);
		}
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
		movingDish(stack1, stack3, stack2, stackSize);
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
	}

}