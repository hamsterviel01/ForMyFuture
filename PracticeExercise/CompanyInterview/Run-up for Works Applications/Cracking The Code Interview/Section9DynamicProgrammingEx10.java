import java.util.*;

public class Section9DynamicProgrammingEx10 {
	public static ArrayList<Integer> buildHighestStack(int[] w, int[] d, int[] h, int bottomIndex, HashMap<Integer, ArrayList<Integer>> cache){
		ArrayList<Integer> maxStack = new ArrayList<Integer>();
		for (int i=0; i<w.length; i++){
			if (w[i] < w[bottomIndex] && h[i] < h[bottomIndex] && d[i] < d[bottomIndex]){
				if (!cache.containsKey(i)){	
					cache.put(i, buildHighestStack(w, d, h, i, cache));
				}
				ArrayList<Integer> highestStack = cache.get(i);
				if (highestStack.size() > maxStack.size()){
					maxStack = highestStack;
				}
			}
		}

		ArrayList<Integer> currentMaxStack = (ArrayList<Integer>)maxStack.clone();
		currentMaxStack.add(bottomIndex);
		return currentMaxStack;
	}

	public static ArrayList<Integer> buildHighestStack(int[] w, int[] d, int[] h){
		ArrayList<Integer> maxStack = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> cache = new HashMap<Integer, ArrayList<Integer>>();
		for (int i=0; i<w.length; i++){
			if (!cache.containsKey(i)){	
				cache.put(i, buildHighestStack(w, d, h, i, cache));
			}
			ArrayList<Integer> highestStack = cache.get(i);
			if (highestStack.size() > maxStack.size()){
				maxStack = highestStack;
			}
		}
		return maxStack;
	}

	public static void main(String[] args){
		int[] w = new int[]{6, 2, 3, 4, 5, 1};
		int[] d = new int[]{6, 2, 3, 2, 5, 1};
		int[] h = new int[]{6, 2, 3, 4, 5, 1};

		System.out.println(buildHighestStack(w, d, h));
	}
}