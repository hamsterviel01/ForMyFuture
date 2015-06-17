import java.util.*;

/**
Lesson to note:
- You can start to trust your solution a bit more
*/

//My solution will take O(2n) for dequeue;
public class StacksAndQueues35 {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public StacksAndQueues35(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	boolean isEmpty(){
		return stack1.isEmpty();
	}

	//Depends on what will be the frequent used operation, enqueue or dequeue
	void enqueue(int val){
		stack1.push(val);
	}

	void dequeue() throws Exception {
		if (isEmpty()) throw new Exception("Queue is Empty");
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		stack2.pop();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}

	Stack returnQueue(){
		return stack1;
	}
	public static void main(String[] args){
		StacksAndQueues35 myQueue = new StacksAndQueues35();
		try {
			myQueue.enqueue(1);
			System.out.println(myQueue.returnQueue());
			myQueue.enqueue(2);
			System.out.println(myQueue.returnQueue());
			myQueue.enqueue(3);
			System.out.println(myQueue.returnQueue());
			myQueue.dequeue();
			System.out.println(myQueue.returnQueue());
			myQueue.dequeue();
			System.out.println(myQueue.returnQueue());
			myQueue.dequeue();
			System.out.println(myQueue.returnQueue());
			myQueue.dequeue();
			System.out.println(myQueue.returnQueue());
			myQueue.enqueue(4);
			System.out.println(myQueue.returnQueue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}