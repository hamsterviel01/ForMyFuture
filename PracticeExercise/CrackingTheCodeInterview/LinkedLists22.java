import java.util.*;

public class LinkedLists22{
	public static SinglyLinkedListNode returnNthToLastElement(SinglyLinkedListNode head, int n){
		//if linked list is empty?? or n == 0
		if (head == null) return null;
		if (n == 0) return null;

		//if linked list only have 1 element??
		if (head.getNext() == null){
			if (n>1) return null;
		}

		//2 pointer
		SinglyLinkedListNode pointer1 = head;
		SinglyLinkedListNode pointer2 = head;

		//Move 2nd pointer to n element away from pointer1;
		//Check condition for n?? if n > linked list length, return null;
		for (int i=1; i<n; i++){
			if (pointer2.getNext()!=null){
				pointer2 = pointer2.getNext();
			} else {
				return null;
			}
		}

		//Move both pointer incrementally until pointer2 reach the end
		while (pointer2.getNext()!=null){
			pointer2 = pointer2.getNext();
			pointer1 = pointer1.getNext();
		}
		return pointer1;
	}

	public static void main(String[] args){
		SinglyLinkedListNode head = SinglyLinkedListNode.createRandomLinkedList(9, 100);
		DoubleLinkedListNode head1 = DoubleLinkedListNode.createRandomLinkedList(1, 100);
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(returnNthToLastElement(head, n).getData());
	}
}