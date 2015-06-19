/**
Lesson Learned:
- Check if there is any need for parent attribute
- Recursive function should return value --> shorted solution
*/

public class TreesAndGraphs43 {
	// public static void buildBinarySubtree(BinaryTreeNode parent, int parentIndex, int nodeIndex, int[] array){
	// 	if(parent.getValue() != array[nodeIndex]){
	// 		BinaryTreeNode node = new BinaryTreeNode(array[nodeIndex]);
	// 		node.setParent(parent);
	// 		array[nodeIndex] = -1;
	// 		if (parent.getValue() > node.getValue()){
	// 			parent.setLeftChild(node);
	// 			System.out.println("parent: " + parent.getValue() + " left child: " + node.getValue());
	// 			if (array[(parentIndex + nodeIndex)/2] != -1){
	// 				buildBinarySubtree(node, nodeIndex, (parentIndex + nodeIndex)/2, array);
	// 			}
	// 			if (array[(nodeIndex)/2] != -1){
	// 				buildBinarySubtree(node, nodeIndex, (nodeIndex)/2, array);
	// 			}
	// 		} else {
	// 			parent.setRightChild(node);
	// 			System.out.println("parent: " + parent.getValue() + " right child: " + node.getValue());
	// 			if (array[(parentIndex + nodeIndex)/2] != -1){
	// 				buildBinarySubtree(node, nodeIndex, (parentIndex + nodeIndex)/2, array);
	// 			}
	// 			if (array[(array.length + nodeIndex)/2] != -1){
	// 				buildBinarySubtree(node, nodeIndex, (array.length + nodeIndex)/2, array);
	// 			}
	// 		}
	// 	}
	// }

	// public static void buildBinaryTree(int[] sortedArray){
	// 	BinaryTreeNode root = new BinaryTreeNode(sortedArray[sortedArray.length/2]);
	// 	sortedArray[sortedArray.length/2] = -1;
	// 	buildBinarySubtree(root, sortedArray.length/2, sortedArray.length/4, sortedArray);
	// 	buildBinarySubtree(root, sortedArray.length/2, 3*sortedArray.length/4, sortedArray);

	// 	//how to insert last element??
	// }

	//Sorten my solution
	public static BinaryTreeNode buildBinarySubtree(BinaryTreeNode parent, int start, int end, int[] array){
		if(start > end){
			return null;
		}
		int mid = (start+end)/2;
		BinaryTreeNode node = new BinaryTreeNode(array[mid]);
		node.printBinaryTree();
		node.setParent(parent);
		node.setLeftChild(buildBinarySubtree(node, start, mid-1, array));
		node.setRightChild(buildBinarySubtree(node, mid+1, end, array));
		return node;
	}

	public static void buildBinaryTree(int[] array){
		BinaryTreeNode root = new BinaryTreeNode(array[array.length/2]);
		buildBinarySubtree(root, 0, array.length-1, array);
		root.printBinaryTree();
	}

	public static void main(String[] args){
		int[] sortedArray = {1,2,3};
		buildBinaryTree(sortedArray);
		for (int i=0; i<sortedArray.length; i++){
			System.out.print(sortedArray[i] + " ");
		}
		
	}
}