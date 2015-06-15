//Case 1: fixed size stack - size provided.
public class StacksAndQueues31 {
	int stackSize = 100;
	int[] array = new int[stackSize*3];
	int[] stackHead = {-1, -1, -1};

	//stackNo is 0, 1 or 2
	boolean isEmpty(int stackNo){
		return stackHead[stackNo] == -1;
	}

	boolean isFull(int stackNo){
		return stackHead[stackNo] == stackSize - 1;
	}

	void push(int val, int stackNo) throws Exception {
		if (isFull(stackNo)){
			throw new Exception();
		}
		stackHead[stackNo]++;
		array[absTopOfStack(stackNo)] = val;
	}

	int pop(int stackNo) throws Exception {
		if (isEmpty(stackNo)){
			throw new Exception();
		}
		int returnVal = array[absTopOfStack(stackNo)];
		stackHead[stackNo]--;
		return returnVal;
	}

	int peek(int stackNo) throws Exception {
		if (isEmpty(stackNo)){
			throw new Exception();
		}
		return array[absTopOfStack(stackNo)];
	}

	//return index of top of stack
	int absTopOfStack(int stackNo){
		return stackHead[stackNo] + stackSize*stackNo;
	}

	void printStack(int stackNo){
		if (isEmpty(stackNo)){
			System.out.println("Stack is empty");
			return;
		}
		for (int i = 0; i <= stackHead[stackNo]; i++){
			System.out.print(array[stackSize*stackNo + i] + " --> ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		//testing case 1
		StacksAndQueues31 stacksAndQueues31 = new StacksAndQueues31();
		try {
			stacksAndQueues31.push(1, 0);
			stacksAndQueues31.push(2, 0);
			stacksAndQueues31.push(3, 0);
			stacksAndQueues31.printStack(0);
			stacksAndQueues31.push(2, 1);
			stacksAndQueues31.pop(1);
			stacksAndQueues31.printStack(1);
		} catch (Exception e){
			System.out.println("Stack was full or empty");
		}

		//testing case 2
		StackAndQueue31Case2 stackAndQueue31Case2 = new StackAndQueue31Case2();
	}
}

//Case 2: Provide flexibility to stacks
//Basically, move the stack forward if the previous stack was fulled
//Design array to be circular. --> O(n)
//Too troublesome for an interview
class StackAndQueue31Case2 {
	int arraySize = 10;
	int[] array = new int[arraySize];
	int[] stackHead = {0, 3, 6};

}