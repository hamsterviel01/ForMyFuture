import java.util.*;

public class TreesAndGraphs49 {
	public static Stack<String> printAllPath(BinaryTreeNode node){
		BinaryTreeNode leftChild = node.getLeftChild();
		BinaryTreeNode rightChild = node.getRightChild();
		Stack<String> paths = new Stack<String>();
		Stack<String> subPath = new Stack<String>();

		if (leftChild == null & rightChild == null) return paths;

		if (leftChild != null){
			paths.push(node.getValue() + "-->" + leftChild.getValue());
			System.out.println(node.getValue() + "-->" + leftChild.getValue());
			subPath = printAllPath(leftChild);
			while (!subPath.isEmpty()){
				System.out.println(node.getValue() + "-->" + subPath.peek());
				paths.push(node.getValue() + "-->" + subPath.pop());
			}
		}

		if (rightChild != null){
			paths.push(node.getValue() + "-->" + rightChild.getValue());
			System.out.println(node.getValue() + "-->" + rightChild.getValue());
			subPath = printAllPath(rightChild);
			while (!subPath.isEmpty()){
				System.out.println(node.getValue() + "-->" + subPath.peek());
				paths.push(node.getValue() + "-->" + subPath.pop());
			}
		}

		return paths;
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

		printAllPath(root);
	}
}