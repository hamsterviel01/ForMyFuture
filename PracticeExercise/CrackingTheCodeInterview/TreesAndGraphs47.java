/**
Lesson learnt:
- My solution will probably run faster, but is too bulky and not as beautiful as in textbook.
*/

public class TreesAndGraphs47 {
	public static BinaryTreeNode searchFirstValue(BinaryTreeNode node, int val1, int val2){
		while (node != null){
			if (node.getValue() == val1 || node.getValue() == val2){
				return node;
			}
			searchFirstValue(node.getLeftChild(), val1, val2);
			searchFirstValue(node.getRightChild(), val1, val2);
		}
		return null;
	}

	public static BinaryTreeNode findAllChild(BinaryTreeNode node, BinaryTreeNode pointer, int val){
		if (pointer == null){
			return null;
		}
		if (pointer.getValue() != val){
			findAllChild(node, pointer.getRightChild(), val);
			findAllChild(node, pointer.getLeftChild(), val);
		}
		return node.getParent();
	}

	public static BinaryTreeNode findAllInAncestors(BinaryTreeNode node, BinaryTreeNode pointer, int val){
		BinaryTreeNode parent = (BinaryTreeNode)node.getParent();
		if (parent.getLeftChild() != null && parent.getLeftChild() != node){

		}
	}

	public BinaryTreeNode findCommonAncestor(BinaryTreeNode root, int val1, int val2){
		BinaryTreeNode firstMatch = searchFirstValue(root, val1, val2);
		if (firstMatch == null) return null;
		if (val1 == val2) return (BinaryTreeNode)firstMatch.getParent();

		int matchedVal = (firstMatch.getValue() == val1)?val1:val2;
		int findingVal = (firstMatch.getValue() == val1)?val2:val1;
		BinaryTreeNode commonAncestor = findAllChild(firstMatch, firstMatch, findingVal);
		if (commonAncestor == null){
			return findAllInAncestors(firstMatch, findingVal);
		}
		return commonAncestor;
	}

	public BinaryTreeNode searchFromNode(BinaryTreeNode node, BinaryTreeNode commonAncestor, int val){

	}
}