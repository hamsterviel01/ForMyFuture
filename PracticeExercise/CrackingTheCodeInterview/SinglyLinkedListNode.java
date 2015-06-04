public class SinglyLinkedListNode {
	SinglyLinkedListNode next = null;
	int data;

	public SinglyLinkedListNode(int data){
		this.data = data;
	}

	public void appendToTail(int data){
		SinglyLinkedListNode end = new SinglyLinkedListNode(data);
		SinglyLinkedListNode node = this;
		while (node.next != null){
			node = node.next;	
		}
		node.next = end;
	}

	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int data){
		SinglyLinkedListNode node = head;
		//if remove head??
		if (head.data == data){
			return head.next;
		}
		//if remove non-head node
		while (node.next != null){
			if (node.next.data == data){
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}

}