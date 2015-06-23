public class TreesAndGraphs45 {
	public static boolean isBinarySearchTree(BinaryTreeNode node){
		if (node.getLeftChild() == null && node.getRightChild() == null){
			return true;
		} else if (node.getLeftChild() != null && node.getLeftChild().getValue() > node.getValue()){
			return false;
		} else if (node.getRightChild() != null && node.getRightChild().getValue() < node.getValue()){
			return false;
		} else {
			return isBinarySearchTree(node.getLeftChild()) && isBinarySearchTree(node.getRightChild());
		}

	}

	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode(4);		
		root.setLeftChild(new BinaryTreeNode(3));
		root.getLeftChild().setLeftChild(new BinaryTreeNode(2));
		root.getLeftChild().getLeftChild().setLeftChild(new BinaryTreeNode(1));

		root.setRightChild(new BinaryTreeNode(8));
		root.getRightChild().setLeftChild(new BinaryTreeNode(6));
		root.getRightChild().setRightChild(new BinaryTreeNode(10));
		root.getRightChild().getLeftChild().setLeftChild(new BinaryTreeNode(5));
		root.getRightChild().getLeftChild().setRightChild(new BinaryTreeNode(7));
		root.getRightChild().getRightChild().setLeftChild(new BinaryTreeNode(9));
		System.out.println(isBinarySearchTree(root));
	}
}