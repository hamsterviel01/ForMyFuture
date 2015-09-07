import java.util.*;

public class WorksApplicationsExcercise6 {
	public static ArrayList<Integer> longestMonotonicallyIncreasingSequence(int[] input){
		ArrayList<ArrayList<Integer>> cache = new ArrayList<ArrayList<Integer>>();
		cache.add(new ArrayList<Integer>(Arrays.asList(input[0])));

		int maxIndex = 0;
		for (int i=1; i<input.length; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j=0; j<i; j++){
				if (input[i] > input[j] && temp.size() < cache.get(j).size()){
					temp = cache.get(j);
				}
			}
			ArrayList<Integer> local = (ArrayList<Integer>)temp.clone();
			local.add(input[i]);
			cache.add(local);
			if (local.size() > cache.get(maxIndex).size()){
				maxIndex = i;
			}
		}

		return cache.get(maxIndex);
	}

	public static void main(String[] args){
		int[] input = new int[]{8, 10, 6, 7, 8, 13, 9, 17, 14};
		System.out.println(longestMonotonicallyIncreasingSequence(input));
	}
}