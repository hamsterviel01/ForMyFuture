import java.util.*;
/**
Lesson learned:
- There is a difference between 
	1. Stack<Integer> stack = new Stack<Integer>() --> stack will give you Integer object, which will automatically cast down to int
	2. Stack stack = new Stack<Integer> --> stack will give you Object object, which will not be able to compare under comparator.
- There is a difference between 
	- A && B, if A is false then it won't check B
	- B && A, if B is false then it won't check A
*/
public class StacksAndQueues36 {
	public static void pushValueInOrder(Stack<Integer> original, Stack<Integer> target, int smallValue){
		while(!target.isEmpty() && smallValue < target.peek()){
			original.push(target.pop());
		}
		target.push(smallValue);
		while (!original.isEmpty() && original.peek() > target.peek()){
			target.push(original.pop());
		}
	}

	public static Stack<Integer> sortStackAscending(Stack<Integer> original){
		Stack<Integer> target = new Stack<Integer>();
		if (original.isEmpty()) return null;
		target.push(original.pop());
		while (!original.isEmpty()){
			int smallValue = original.pop();
			if (smallValue < target.peek()){
				pushValueInOrder(original, target, smallValue);
			} else {
				target.push(smallValue);
			}
		}
		return target;
	}

	public static void main(String[] args){
		int[] array = {1, 3, 2, 7, 6, 9, 5};
		Stack original = new Stack<Integer>();
		for(int i=0; i<array.length; i++){
			original.push(array[i]);
		}
		System.out.println(original);
		System.out.println(sortStackAscending(original));
	}
}