import java.util.*;

public class SinglyLinkedListNode extends LinkedListNode{
	private SinglyLinkedListNode next = null;

	public SinglyLinkedListNode(){

	}

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

	public void insertAfter(LinkedListNode node){
		node.setNext(this.next);
		this.next = (SinglyLinkedListNode)node;
	}

	public SinglyLinkedListNode getNext(){
		return next;
	}

	public void setNext(LinkedListNode next){
		this.next = (SinglyLinkedListNode)next;
	}

	public static SinglyLinkedListNode createRandomLinkedList(int length, int randomSize){
		if (length==0){
			return null;
		}
		Random random = new Random();
		SinglyLinkedListNode head = new SinglyLinkedListNode(random.nextInt(randomSize));
		SinglyLinkedListNode pointer = head;
		//default value of int is 0 --> key of head is already 0
		while (pointer.getKey() < length-1){
			pointer.appendToTail(random.nextInt(randomSize));
			System.out.print(pointer.getData() + " --> ");
			pointer = pointer.getNext();
		} 
		System.out.println(pointer.getData() + "\n");
		return head;
	}
}