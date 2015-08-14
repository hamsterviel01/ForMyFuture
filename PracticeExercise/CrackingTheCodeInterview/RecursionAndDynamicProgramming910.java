import java.util.*;

public class RecursionAndDynamicProgramming910 {
	static int[] w = new int[]{2, 1, 3, 4, 5};
	static int[] h = new int[]{2, 1, 5, 4, 4};
	static int[] d = new int[]{2, 1, 3, 4, 4};

	//return max height of stack
	public static ArrayList<Integer> buildStack(int currentIndex, ArrayList<Integer> currentStack, Hashtable<Integer, ArrayList<Integer>> storeMax){
		ArrayList<Integer> maxStack = (ArrayList<Integer>)currentStack.clone();
		for (int i=0; i<w.length; i++){
			if (isSmaller(i, currentIndex)){
				//Continue to build stack, thus we need a variable height for this
				ArrayList<Integer> temp = (ArrayList<Integer>)currentStack.clone();
				if (storeMax.containsKey(i)){
					temp.addAll(storeMax.get(i));
				} else {
					ArrayList<Integer> temp2 = (ArrayList<Integer>)currentStack.clone();
					temp2.add(i);
					temp = buildStack(i, temp2, storeMax);
				}
				if (maxStack.size() < temp.size()){
					maxStack = (ArrayList<Integer>)temp.clone();
				}
			}
		}
		storeMax.put(currentIndex, maxStack);
		return maxStack;
	}

	public static ArrayList<Integer> returnMaxHeight(){
		Hashtable<Integer, ArrayList<Integer>> storeMax = new Hashtable<Integer, ArrayList<Integer>>();
		ArrayList<Integer> maxStack = new ArrayList<Integer>();
		for (int i=0; i<w.length; i++){
			ArrayList<Integer> temp = buildStack(i, new ArrayList<Integer>(Arrays.asList(i)), storeMax);
			if (maxStack.size() < temp.size()){
				maxStack = (ArrayList<Integer>)temp.clone();
			}
		}
		return maxStack;
	}

	public static boolean isSmaller(int index1, int index2){
		return w[index1] < w[index2] && h[index1] < h[index2] && d[index1] < d[index2];
	}

	public static void main(String[] args){
		System.out.println("Max  stack is " + returnMaxHeight());
	}
}