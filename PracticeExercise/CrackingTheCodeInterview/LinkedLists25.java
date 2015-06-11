import java.util.*;

public class LinkedLists25 {
	//My first solution
	public static int sumOfLinkedList(LinkedListNode head1, LinkedListNode head2){
		int count = 0;
		int sum = 0;
		int decimalBase = 1;
		LinkedListNode pointer1 = head1;
		LinkedListNode pointer2 = head2;

		while (pointer1!=null || pointer2!=null){
			if (pointer1!=null){
				sum = sum + pointer1.getData()*decimalBase;
				pointer1 = pointer1.getNext();
			}
			if (pointer2!=null){
				sum = sum + pointer2.getData()*decimalBase;
				pointer2 = pointer2.getNext();
			}
			count++;
			decimalBase = decimalBase*10;
		}

		return sum;
	}

	// public static SinglyLinkedListNode convertSumToLinkedList(int sum){
	// 	//Convert sum value to LinkedList
	// 	SinglyLinkedListNode headSum = new SinglyLinkedListNode(sum%10);
	// 	sum = sum/10;
	// 	SinglyLinkedListNode pointerSum = headSum;
	// 	while(sum>0){
	// 		pointerSum.appendToTail(sum%10);
	// 		sum = sum/10;
	// 		pointerSum = pointerSum.getNext();
	// 	}
	// 	return headSum;
	// }

	public static void convertSumToLinkedList(LinkedListNode head, int sum){
		//Convert sum value to LinkedList;
		head.setData(sum%10);
		sum = sum/10;
		LinkedListNode pointerSum = head;
		while(sum>0){
			pointerSum.appendToTail(sum%10);
			sum = sum/10;
			pointerSum = pointerSum.getNext();
		}
	}

	//Implement solution in textbook, which was way better
	public static LinkedListNode addListsA(LinkedListNode pointer1, LinkedListNode pointer2, int carry){
		return null;
	}

	//Need to write exactly the same 

	public static void main(String[] args){
		LinkedListNode head1 = SinglyLinkedListNode.createRandomLinkedList(3, 10);
		LinkedListNode head2 = SinglyLinkedListNode.createRandomLinkedList(7, 10);

		LinkedListNode headSum = new SinglyLinkedListNode();
		convertSumToLinkedList(headSum, sumOfLinkedList(head1, head2));
		headSum.printLinkedList();
	}
}