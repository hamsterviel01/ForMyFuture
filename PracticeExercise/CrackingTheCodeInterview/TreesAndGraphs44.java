import java.util.*;

public class TreesAndGraphs44 {
	public static LinkedList<BinaryTreeNode> printLinkedList(LinkedList<BinaryTreeNode> nodesAtDepth){
		ListIterator<BinaryTreeNode> iterator = nodesAtDepth.listIterator();
		LinkedList<BinaryTreeNode> allChilds = new LinkedList<BinaryTreeNode>();
		while (iterator.hasNext()){
			BinaryTreeNode node = iterator.next();
			System.out.print("-->" + node.getValue());
			if (node.getLeftChild()!=null){
				allChilds.add(node.getLeftChild());
			}
			if (node.getRightChild()!=null){
				allChilds.add(node.getRightChild());
			}
		}
		System.out.print("\n");
		if (allChilds.isEmpty()){
			return null;
		} else {
			return printLinkedList(allChilds);
		} 
	}

	public static void startBuildLinkedList(BinaryTreeNode root){
		LinkedList<BinaryTreeNode> rootList = new LinkedList<BinaryTreeNode>();
		rootList.add(root);
		printLinkedList(rootList);
	}

	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode(1);		
		root.setLeftChild(new BinaryTreeNode(2));
		root.getLeftChild().setLeftChild(new BinaryTreeNode(4));
		root.getLeftChild().getLeftChild().setLeftChild(new BinaryTreeNode(5));
		root.setRightChild(new BinaryTreeNode(3));
		root.getRightChild().setLeftChild(new BinaryTreeNode(5));
		root.getRightChild().setRightChild(new BinaryTreeNode(6));
		root.getRightChild().getLeftChild().setLeftChild(new BinaryTreeNode(6));
		root.getRightChild().getLeftChild().setRightChild(new BinaryTreeNode(7));
		root.getRightChild().getRightChild().setLeftChild(new BinaryTreeNode(8));
		startBuildLinkedList(root);
	}
}