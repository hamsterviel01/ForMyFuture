/**
Lessons learned:
- With tree, be especially carefull, there can be many nuts and bolts with BST conditions.
- Alway check if node is null before get its value or do anything with it
*/

public class TreesAndGraphs45 {
	//The first solution I derived was wrong: because LHS Tree and RHS Tree is BST doesn't means the whole tree is BST:
	// - The rightmost child in LHS BST need to < root and 
	// - The leftmost child in RHS BST need to > root

	public static boolean isBinarySearchTree(BinaryTreeNode node, int min, int max){
		//Check if node is null first before checking its left child or right child, as isBinarySearchTree invokes call on parent node's right and left children
		if (node == null){
			return true;
		}

		int value = node.getValue();
		if (value < min || value > max) {
			return false;
		}

		return isBinarySearchTree(node.getLeftChild(), min, value) && isBinarySearchTree(node.getRightChild(), value+1, max);
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
		System.out.println(isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}