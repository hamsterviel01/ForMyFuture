public abstract class LinkedListNode {
	private int data;
	private int key;
	private LinkedListNode next;
	abstract void appendToTail(int data);
	abstract LinkedListNode deleteCurrentNode(LinkedListNode head);
	abstract public LinkedListNode getNext();
	abstract public void setNext(LinkedListNode next);
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
}