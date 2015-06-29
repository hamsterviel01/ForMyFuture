/**
Lessons learnt:
- Start Cons -> Next Cons -> Stop Cons in recursion can be very helpful.
*/

public class TreesAndGraphs46 {
	public static TreeNode getNextInOrderNode(int value, BinaryTreeNode currentNode, TreeNode nextNode){
		//Next Cons
		if (currentNode == null){
			return null;
		}
		if (value > currentNode.getValue()){
			return getNextInOrderNode(value, currentNode.getRightChild(), nextNode);
		} else if (value < currentNode.getValue()) {
			return getNextInOrderNode(value, currentNode.getLeftChild(), currentNode);
		} else {
			//Finish Cons
			if (currentNode.getRightChild() != null){
				BinaryTreeNode pointer = currentNode.getRightChild();
				while (pointer.getLeftChild() != null){
					pointer = pointer.getLeftChild();
				}
				return pointer;
			} else {
				return nextNode;
			}
		}
	}
	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode(4);		
		root.setLeftChild(new BinaryTreeNode(3));
		root.getLeftChild().setLeftChild(new BinaryTreeNode(3));
		root.getLeftChild().getLeftChild().setLeftChild(new BinaryTreeNode(1));

		root.setRightChild(new BinaryTreeNode(8));
		root.getRightChild().setLeftChild(new BinaryTreeNode(6));
		root.getRightChild().setRightChild(new BinaryTreeNode(10));
		root.getRightChild().getLeftChild().setLeftChild(new BinaryTreeNode(5));
		root.getRightChild().getLeftChild().setRightChild(new BinaryTreeNode(7));
		root.getRightChild().getRightChild().setLeftChild(new BinaryTreeNode(9));

		//Start cons
		int value = 12;
		TreeNode nextNode = getNextInOrderNode(value, root, null);
		if (nextNode == null){
			System.out.println("This node don't have next node of value provided cannot be found");
		} else {
			System.out.println(nextNode.getValue());
		}
	}
}