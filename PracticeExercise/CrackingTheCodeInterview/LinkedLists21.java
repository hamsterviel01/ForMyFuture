import java.util.*;

public class LinkedLists21 {
	public static void removeDuplicatedWithBuffer(LinkedListNode head){
		Hashtable table = new Hashtable();
		LinkedListNode node = head;

		//If node.data != exist --> add to hash table, 
		//if not then move to next node, delete old node.
		while (node!=null){
			if (!table.containsKey(node.getData())){
				table.put(node.getData(), true);
				node = node.getNext();
			} else {
				LinkedListNode tempNode = node;
				node = node.getNext();
				head = tempNode.deleteCurrentNode(head);
			}
		}
	}

	public static void removeDuplicatedWithoutBuffer(LinkedListNode head){
		//pointer 1 will run along the linked list
		//pointer 2 will run from head to pointer 1 to check for duplication
		LinkedListNode pointer1 = head.getNext();
		LinkedListNode pointer2 = head;

		while (pointer1!=null){
			while(pointer2!=pointer1){
				//if data at pointer1 is already exist -->
				// 1. Move pointer1 to next
				// 2. Reset pointer2 to head
				// 3. Delete node at pointer 1
				if (pointer2.getData()==pointer1.getData()){
					LinkedListNode temp = pointer1;
					pointer1 = pointer1.getNext();
					pointer2 = head;
					temp.deleteCurrentNode(head);
					break;
				} else {
					//pointer 2 stopping condition:
					// - If duplication found, reset its and break while loop;
					// - if duplication not found --> move it forward until it reach to pointer1
					pointer2 = pointer2.getNext();
				}
				// how about pointer1 stopping condition?? 
				// when pointer 2 reach pointer 1 posisition --> move pointer1 ahead and break the loop.
				// also need to reset pointer2
				if (pointer2 == pointer1){
					pointer1 = pointer1.getNext();
					pointer2 = head;
					break;
				}
			}
		}
	}

	public static void printLinkedList(LinkedListNode head){
		LinkedListNode temp2 = head;
		while (temp2!=null){
			if (temp2.getNext()!=null){
				System.out.print(temp2.getData() + " --> ");
			} else {
				System.out.print(temp2.getData() + "\n");
			}
			temp2 = temp2.getNext();
		}
	}

	public static void main(String[] args){
		//how to create a linked list with 6 nodes from SinglyLinkedListNode class??
		Random random = new Random();
		SinglyLinkedListNode head = new SinglyLinkedListNode(random.nextInt(6));
		SinglyLinkedListNode temp1 = head;
		while (temp1.getKey() < 10){	
			temp1.appendToTail(random.nextInt(6));
			System.out.print(temp1.getData() + " --> ");
			temp1 = temp1.getNext();
		}
		System.out.print(temp1.getData() + "\n");
		removeDuplicatedWithoutBuffer(head);
		printLinkedList(head);

		DoubleLinkedListNode head2 = new DoubleLinkedListNode(random.nextInt(6));
		DoubleLinkedListNode temp2 = head2;
		while (temp2.getKey() < 10){	
			temp2.appendToTail(random.nextInt(6));
			System.out.print(temp2.getData() + " --> ");
			temp2 = temp2.getNext();
		}
		System.out.print(temp2.getData() + "\n");

		removeDuplicatedWithBuffer(head2);
		printLinkedList(head2);
	}
}