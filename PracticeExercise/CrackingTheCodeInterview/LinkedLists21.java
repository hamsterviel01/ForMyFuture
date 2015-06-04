import java.util.*;

public class LinkedLists21 {
	public static void removeDuplicatedWithBuffer(SinglyLinkedListNode head){
		Hashtable table = new Hashtable();
		SinglyLinkedListNode node = head;

		//If node.data != exist --> add to hash table, 
		//if not then move to next node, delete old node.
		while (node!=null){
			if (!table.containsKey(node.data)){
				table.put(node.data, true);
				node = node.next;
			} else {
				SinglyLinkedListNode tempNode = node;
				node = node.next;
				SinglyLinkedListNode.deleteNode(head, tempNode.key);
			}
		}

		System.out.println(table);

	}

	public static void main(String[] args){
		//how to create a linked list with 6 nodes from SinglyLinkedListNode class??
		Random random = new Random();
		SinglyLinkedListNode[] singlyLinkedListNode = new SinglyLinkedListNode[10];
		for (int i=0; i<10; i++){
			singlyLinkedListNode[i] = new SinglyLinkedListNode(random.nextInt(6));
			System.out.print(singlyLinkedListNode[i].data + " --> ");
		}

		//initialize .next and .key attribute of node
		for (int i=0; i<10; i++){
			if (i == 9){
				singlyLinkedListNode[i].next = null;
			} else {
				singlyLinkedListNode[i].next = singlyLinkedListNode[i+1];
			}
			singlyLinkedListNode[i].key = i;
		}
		System.out.println();

		removeDuplicatedWithBuffer(singlyLinkedListNode[0]);
		SinglyLinkedListNode node = singlyLinkedListNode[0];
		while (node!=null){
			System.out.print(node.data + " --> ");
			node = node.next;
		}

	}
}