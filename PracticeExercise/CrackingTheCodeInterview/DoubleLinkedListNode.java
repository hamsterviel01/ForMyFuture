public class DoubleLinkedListNode extends LinkedListNode {
	private DoubleLinkedListNode prev = null;
	private DoubleLinkedListNode next = null;

	public DoubleLinkedListNode(int data){
		setData(data);
	}

	public void appendToTail(int data){
		DoubleLinkedListNode end = new DoubleLinkedListNode(data);
		DoubleLinkedListNode node = this;
		while (node.next != null){
			node = node.next;	
		}
		node.next = end;
		end.prev = node;
		end.setKey(node.getKey()+1);
	}

	public LinkedListNode deleteCurrentNode(LinkedListNode head){
		DoubleLinkedListNode node = (DoubleLinkedListNode)head;
		//if remove head??
		if (node.getKey() == getKey()){
			return (LinkedListNode)node.next;
		}
		//if remove non-head node, use node.next --> node = node.next.prev
		while (node != null){
			//if node is lost node --> node.next.prev won't exist
			if (node.next == null){
				node.prev.next = null;
				return head;
			} else {
				if (node.getKey() == getKey()){
					node.prev.next = node.next;
					node.next.prev = node.prev;
					return head;
				}
			}
			node = node.next;
		}
		return head;
	}

	public DoubleLinkedListNode getNext(){
		return next;
	}

	public void setNext(DoubleLinkedListNode next){
		this.next = next;
	}
	public DoubleLinkedListNode getPrev(){
		return prev;
	}

	public void setPrev(DoubleLinkedListNode prev){
		this.prev = prev;
	}
}