import java.util.*;

public abstract class LinkedListNode {
	private int data;
	private int key;
	private LinkedListNode next;

	LinkedListNode(int data){
		this.data = data;
	}
	
	abstract void appendToTail(int data);
	abstract LinkedListNode deleteCurrentNode(LinkedListNode head);
	abstract void insertAfter(LinkedListNode node);
	abstract void setNext(LinkedListNode next);
	LinkedListNode getNext(){
		return next;
	}
	int getData(){
		return data;
	}
	void setData(int data){
		this.data = data;
	}
	int getKey(){
		return key;
	}
	void setKey(int key){
		this.key = key;
	}
	void printLinkedList(){
		LinkedListNode temp = this;
		while (temp!=null){
			if (temp.getNext()!=null){
				System.out.print(temp.getData() + " --> ");
			} else {
				System.out.print(temp.getData() + "\n");
			}
			temp = temp.getNext();
		}
	}
}