public class TreesAndGraphs47 {
	public BinaryTreeNode searchFirstValue(BinaryTreeNode node, int val1, int val2){
		while (node != null){
			if (node.getValue() == val1 || node.getValue() == val2){
				return node;
			} else {
				searchFirstValue(node.getLeftChild(), val1, val2);
				searchFirstValue(node.getRightChild(), val1, val2);
			}
		}
		return null;
	}

	public BinaryTreeNode findAllChild(BinaryTreeNode node, int val){

	}

	public BinaryTreeNode findAllInAncestors(BinaryTreeNode node, int val){

	}

	public BinaryTreeNode findCommonAncestor(BinaryTreeNode root, int val1, int val2){
		BinaryTreeNode firstMatch = searchFirstValue(root, val1, val2);
		if (firstMatch == null) return null;
		if (val1 == val2) return (BinaryTreeNode)firstMatch;.getParent();

		int matchedVal = (firstMatch.getValue() == val1)?val1:val2;
		int findingVal = (firstMatch.getValue() == val1)?val2:val1;



	}

	public BinaryTreeNode searchFromNode(BinaryTreeNode node, BinaryTreeNode commonAncestor, int val){

	}
}