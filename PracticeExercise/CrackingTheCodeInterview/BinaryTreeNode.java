public class BinaryTreeNode extends TreeNode{
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;

	public BinaryTreeNode(){

	}

	public BinaryTreeNode(int value){
		super(value);
	}

	BinaryTreeNode getLeftChild(){
		return leftChild;
	}

	BinaryTreeNode getRightChild(){
		return rightChild;
	}

	void setLeftChild(BinaryTreeNode leftChild){
		this.leftChild = leftChild;
	}

	void setRightChild(BinaryTreeNode rightChild){
		this.rightChild = rightChild;
	}

	boolean hasLeftChild(){
		return leftChild != null;
	}

	boolean hasRightChild(){
		return rightChild != null;
	}

	boolean isLeave(){
		return leftChild == null && rightChild == null;
	}
}