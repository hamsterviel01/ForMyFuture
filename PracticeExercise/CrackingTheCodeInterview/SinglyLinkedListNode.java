public class SinglyLinkedListNode extends LinkedListNode{
	private SinglyLinkedListNode next = null;

	public SinglyLinkedListNode(int data){
		setData(data);
	}

	public void appendToTail(int data){
		SinglyLinkedListNode end = new SinglyLinkedListNode(data);
		SinglyLinkedListNode node = this;
		while (node.next != null){
			node = node.next;	
		}
		node.next = end;
		end.setKey(node.getKey()+1);
	}

	
	
	public LinkedListNode deleteCurrentNode(LinkedListNode head){
		SinglyLinkedListNode node = (SinglyLinkedListNode)head;
		//if remove head??
		if (node.getKey() == getKey()){
			return (LinkedListNode)node.next;
		}
		//if remove non-head node
		while (node.next != null){
			if (node.next.getKey() == getKey()){
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}

	public SinglyLinkedListNode getNext(){
		return next;
	}

	public void setNext(SinglyLinkedListNode next){
		this.next = next;
	}
}