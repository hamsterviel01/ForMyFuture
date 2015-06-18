
public class TreeNode{
	private TreeNode parent;
	private int value;
	boolean isVisited = false;

	public TreeNode(){
	}

	public TreeNode(int value){
		this.value = value;
	}
	
	public TreeNode(int value, TreeNode parent){
		this.value = value;
		this.parent = parent;
	}

	boolean isRoot(){
		return parent == null;
	}

	TreeNode getParent(){
		return parent;
	}

	void setParent(TreeNode parent){
		this.parent = parent;
	}

	int getValue(){
		return value;
	}

	void setValue(int value){
		this.value = value;
	}

	boolean isVisited(){
		return isVisited;
	}

	void setVisited(){
		isVisited = true;
	}
}