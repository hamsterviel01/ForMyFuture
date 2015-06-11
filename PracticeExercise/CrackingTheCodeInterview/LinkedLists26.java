import java.util.*;

public class LinkedLists26 {
	public static SinglyLinkedListNode returnCircularStartingPoint (SinglyLinkedListNode head){
		//Check for intitial condition
		if (head == null || head.getNext() == null){
			return null;
		}

		//circular point is next of another node || circular point point to itself
		Hashtable table = new Hashtable();
		SinglyLinkedListNode pointer = head;
		while (!table.containsKey(pointer.getNext().getKey()) || !table.containsKey(pointer.getKey())){
			table.put(pointer.getKey(), pointer);
			pointer = pointer.getNext();
		}

		return pointer.getNext();
	}

	//O(n) = 2n;
	public static SinglyLinkedListNode createCircularLinkedList(int circularPointKey, int length, int randomSize){
		//check condition
		if (circularPointKey > length-1){
			System.out.println("Circular point is outside linked-list");
			return null;
		}

		if (length == 0){
			System.out.println("Cannot create circular linked-list with length 0");
			return null;
		}

		SinglyLinkedListNode head = SinglyLinkedListNode.createRandomLinkedList(length, randomSize);
		SinglyLinkedListNode pointer = head;
		while (pointer.getKey()!=circularPointKey){
			pointer = pointer.getNext();
		}
		SinglyLinkedListNode circularNode = pointer;
		while (pointer.getNext()!=null){
			pointer = pointer.getNext();
		}
		pointer.setNext(circularNode);

		return head;
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int circularPoint = scan.nextInt();
		int length = scan.nextInt();
		int randomSize = scan.nextInt();
		SinglyLinkedListNode head = createCircularLinkedList(circularPoint, length, randomSize);
		SinglyLinkedListNode circularNode = returnCircularStartingPoint(head);
		if (circularNode!=null){
			System.out.println("circularNode: " + circularNode.getData());
		}
	}
}