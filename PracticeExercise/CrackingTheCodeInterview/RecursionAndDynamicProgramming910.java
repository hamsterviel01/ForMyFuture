public class RecursionAndDynamicProgramming910 {
	static int[] w;
	static int[] h;
	static int[] d;
	static int maxN;

	//Even better, need to return all largest stacks from n boxes
	public static void buildStack(int n, ArrayList<LinkedList<Integer>> stacks, ArrayList<Integer> height){
		//stacks is for buildStack(n-1) produce;
		for (int i=0; i<stacks.size(); i++){
			LinkedList<Integer> componentList = stacks.get(i);
			int j=0;
			while (j<componentList.size()){
				if (isLarger(componentList.get(j), n)){
					if (isLarger(n, componentList.get(j+1))){
						componentList.insert(j+1, n);
					} else {
						createNewComponentList(stacks, i, j, n);
					}
				}

			}
		}

		if (n < w.length){
			buildStack(n+1, stacks, height);
		}
	}
	
	public boolean isLarger(int i, int j){
		if (w[i]>= w[j] && h[i]>=h[j] && d[i]>=d[j]){
			return true;
		}
		return false;
	}

	public void createNewComponentList(ArrayList<LinkedList<Integer>> stacks, int i, int j, int n){

	}

	public static LinkedList<Integer> getHightStack(int[] w, int[] h, int[] d){
		ArrayList<LinkedList<Integer>> stacks = new ArrayList<LinkedList<Integer>>(Arrays.asList(0));

		buildStack(0, stacks);
	}
}