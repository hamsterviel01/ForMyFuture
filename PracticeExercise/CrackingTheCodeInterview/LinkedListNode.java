public abstract class LinkedListNode {
	private int data;
	private int key;
	private LinkedListNode next;
	public abstract void appendToTail(int data);
	public abstract LinkedListNode deleteCurrentNode(LinkedListNode head);
	public int getData(){
		return data;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getKey(){
		return key;
	}
	public void setKey(int key){
		this.key = key;
	}
	public LinkedListNode getNext(){
		return next;
	}
	public void setNext(LinkedListNode next){
		this.next = next;
	}
}