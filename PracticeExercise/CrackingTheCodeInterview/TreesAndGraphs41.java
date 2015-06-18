import java.util.*;

/**
Lesson learned:
- Analyze the problem more carefully
- Be smarter, I guess?
*/
public class TreesAndGraphs41 {
	public static boolean isBalance(BinaryTreeNode root){
		if (checkHeight(root) == -1){
			return false;
		} else {
			return true;
		}
		
	}

	public static int checkHeight(BinaryTreeNode node){
		if (node == null){
			return 0;
		}
		int leftHeight = checkHeight(node.getLeftChild());
		if (leftHeight == -1){
			return -1;
		}
		int rightHeight = checkHeight(node.getRightChild());
		if (rightHeight == -1){
			return -1;
		}
		System.out.println(node.getValue() + ": " + leftHeight + " " + rightHeight);
		if (Math.abs(leftHeight - rightHeight) > 1){
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode(7);
		
		root.setLeftChild(new BinaryTreeNode(9));
		root.getLeftChild().setRightChild(new BinaryTreeNode(12));
		root.getLeftChild().setLeftChild(new BinaryTreeNode(10));
		root.getLeftChild().getLeftChild().setLeftChild(new BinaryTreeNode(13));

		root.setRightChild(new BinaryTreeNode(3));
		root.getRightChild().setRightChild(new BinaryTreeNode(2));

		System.out.println(isBalance(root));
	}
}