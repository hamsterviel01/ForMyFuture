public class LinkedLists24 {
	public static void partitionLinkedList(LinkedListNode head, int x){
		//if linked list empty or has 1 element
		if (head == null || head.getNext() == null){
			return;
		}

		//if head.data is > x


		//Loop through linked list
		// - If data is smaller than x --> keep
		// - First element greater than x --> keep
		// - All element smaller than that --> insert after head
		LinkedListNode pointer = head;
		boolean reachPartitionPoint = false;
		while (pointer.getNext()!=null){
			if (pointer.getData() >= x && reachPartitionPoint == false){
				reachPartitionPoint = true;
			}
			if (pointer.getData() < x && reachPartitionPoint == true){
				LinkedListNode temp = pointer;
				head = temp.deleteCurrentNode(head);
				head.insertAfter(temp);
			}
			pointer = pointer.getNext();
			System.out.println(pointer.getData());
		}
	}

	public static void main(String[] args){
		SinglyLinkedListNode head1 = SinglyLinkedListNode.createRandomLinkedList(10, 100);
		partitionLinkedList(head1, 50);

		LinkedLists21.printLinkedList(head1);
	}
}