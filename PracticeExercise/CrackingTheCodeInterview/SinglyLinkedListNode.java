public class SinglyLinkedListNode {
	SinglyLinkedListNode next = null;
	int data;
	int key;

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

	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int key){
		SinglyLinkedListNode node = head;
		//if remove head??
		if (head.key == key){
			return head.next;
		}
		//if remove non-head node
		while (node.next != null){
			if (node.next.key == key){
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}

}