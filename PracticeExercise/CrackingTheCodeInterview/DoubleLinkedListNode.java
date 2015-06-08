import java.util.*;

public class DoubleLinkedListNode extends LinkedListNode {
	private DoubleLinkedListNode prev = null;
	private DoubleLinkedListNode next = null;

	public DoubleLinkedListNode(){

	}

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

<<<<<<< HEAD
	public void insertAfter(LinkedListNode node){
		DoubleLinkedListNode newNode = (DoubleLinkedListNode)node;
		newNode.setNext(this.next);
		newNode.setPrev(this);
		this.next.setPrev(newNode); 
		this.next = newNode;
	}


=======
>>>>>>> df636323fdb37852dba1b85e0c95ffb89f05f62b
	public static DoubleLinkedListNode createRandomLinkedList(int length, int randomSize){
		if (length==0){
			return null;
		}
		Random random = new Random();
		DoubleLinkedListNode head = new DoubleLinkedListNode(random.nextInt(randomSize));
		DoubleLinkedListNode pointer = head;
		//default value of int is 0 --> key of head is already 0
		while (pointer.getKey() < length-1){
			pointer.appendToTail(random.nextInt(randomSize));
			System.out.print(pointer.getData() + " --> ");
			pointer = pointer.getNext();
		} 
		System.out.println(pointer.getData() + "\n");
		return head;
	}

	public DoubleLinkedListNode getNext(){
		return next;
	}

	public void setNext(LinkedListNode next){
		this.next = (DoubleLinkedListNode)next;
	}
	public DoubleLinkedListNode getPrev(){
		return prev;
	}

	public void setPrev(DoubleLinkedListNode prev){
		this.prev = prev;
	}
}