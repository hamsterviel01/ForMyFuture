public class StacksAndQueues32 {
	int stackSize = 5;
	int[] stack = new int[stackSize];
	int head = -1;
	int min = 0;
	int[] minArray = new int[stackSize];
	
	boolean isEmpty(){
		return head == -1;
	}

	boolean isFull(){
		return head == stack.length - 1;
	}

	void setMin(int val){
		if (minArray[min] > val){
			min = val;
		}
		return;
	}

	void push(int val) throws Exception {
		if (isFull()){
			throw new Exception("Stack is full");
		}
		setMin(val);
		head++;
		stack[head] = val;
	}


	//how about calculate min in this situation??
	int pop() throws Exception {
		if (isEmpty()){
			throw new Exception("Stack is empty");
		}
		int temp = stack[head];
		head--;
		if (temp == min){
			if (head == -1) {
				min = -1;
			} else {
				//pop() need to operate at O(1)
				// min = stack[0];
				// for (int i = 0; i<=head; i++){
				// 	if (stack[i] < min) min = stack[i];
				// }

			}
		}
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
		StacksAndQueues32 stack = new StacksAndQueues32();
		try {
			stack.printStack();
			stack.push(5);
			stack.printStack();
			stack.push(1);
			stack.push(0);
			stack.push(1);
			stack.push(8);
			stack.printStack();
			System.out.println("Min: " + stack.min);
			stack.push(6);
			stack.printStack();
			System.out.println("Min: " + stack.min);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}