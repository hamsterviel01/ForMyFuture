import java.util.*;

public class Section9DynamicProgrammingEx10 {
	public static ArrayList<Integer> buildHighestStack(int[] w, int[] h, int[] d){
		Hashtable<Integer, ArrayList<Integer>> cache = new Hashtable<Integer, ArrayList<Integer>>();
		ArrayList<Integer> maxStack = new ArrayList<Integer>();
		for (int i=0; i<w.length; i++){
			ArrayList<Integer> temp = buildHighestStack(w, h, d, i, cache);
			if (temp.size() > maxStack.size()){
				maxStack = temp;
			}
		}
		
		return maxStack;
	}
	
	public static ArrayList<Integer> buildHighestStack(int[] w, int[] h, int[] d, int top, Hashtable<Integer, ArrayList<Integer>> cache){
		if (cache.containsKey(top)) return cache.get(top);
		
		ArrayList<Integer> maxStack = new ArrayList<Integer>();
		for (int i=0; i<w.length; i++){
			if (w[i] < w[top] && h[i] < h[top] && d[i] < d[top]){
				ArrayList<Integer> temp = buildHighestStack(w, h, d, i, cache);
				if (temp.size() > maxStack.size()){
					maxStack = temp;
				}
			}
		}
		ArrayList<Integer> temp = (ArrayList<Integer>)maxStack.clone();
		temp.add(0, top);
		cache.put(top, temp);
		return temp;
	}
	
	public static void main(String[] args){
		int[] w = new int[]{1, 2, 2, 3, 3, 4};
		int[] h = new int[]{18, 9, 9, 3, 8, 7};
		int[] d = new int[]{1, 2, 2, 7, 3, 4};
		
		System.out.println(buildHighestStack(w, h, d));
	}
}