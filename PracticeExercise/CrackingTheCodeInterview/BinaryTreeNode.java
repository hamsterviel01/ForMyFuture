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

	void printBinaryTree(){
		if (leftChild != null){
			System.out.println("current: " + super.getValue() + " leftChild: " + leftChild.getValue() + " parent: " + super.getParent().getValue());
			leftChild.printBinaryTree();
		}
		if (rightChild != null){
			System.out.println("current: " + super.getValue() + " rightChild: " + rightChild.getValue() + " parent: " + super.getParent().getValue());
			rightChild.printBinaryTree();
		}
		if (leftChild == null && rightChild == null) {
			if (super.getParent() != null){
				System.out.println("current: " + super.getValue() + " child: null" + " parent: " + super.getParent().getValue());
			} else {
				System.out.println("current: " + super.getValue() + " child: null" + " parent: null");
			}
		}
 	}
}