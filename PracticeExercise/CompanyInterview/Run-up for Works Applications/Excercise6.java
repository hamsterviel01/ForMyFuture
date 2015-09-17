import java.util.ArrayList;
import java.util.Arrays;

public class Excercise6 {	
	public static ArrayList<Integer> longestIncreasingSubsequence(int[] arr){
		if (arr.length == 0 || arr == null) return null;
		
		ArrayList<ArrayList<Integer>> cache = new ArrayList<ArrayList<Integer>>();
		cache.add(new ArrayList<Integer>(Arrays.asList(arr[0])));
		
		int maxIndex = 0;
		for (int i=1; i<arr.length; i++){
			ArrayList<Integer> tempMax = new ArrayList<Integer>();
			for (int j=0; j<i; j++){
				if (arr[i] > arr[j]){
					ArrayList<Integer> temp = cache.get(j);
					if (temp.size() > tempMax.size()){
						tempMax=temp;
					}
				}	
			}
			ArrayList<Integer> temp = (ArrayList<Integer>)tempMax.clone();
			temp.add(arr[i]);
			cache.add(temp);
			if (cache.get(maxIndex).size() < temp.size()){
				maxIndex = i;
			}
		}
		
		return cache.get(maxIndex);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[]{8, 4, 9, 12, 13, 14, 15, 16, 17, 5, 6, 7, 8};
		int[] arr2 = new int[]{8, 4, 9, 12, 5, 6, 7, 8, 8, 4, 9, 12, 5, 6, 7, 8, 8, 4, 9, 12, 5, 6, 7, 8, 8, 4, 9, 12, 5, 6, 7, 16, 17, 8, 8, 4, 9, 12, 5, 6, 7, 8};
		int[] arr3 = new int[]{};
		int[] arr4 = new int[]{1};

		System.out.println(longestIncreasingSubsequence(arr1));
		System.out.println(longestIncreasingSubsequence(arr2));
		System.out.println(longestIncreasingSubsequence(arr3));
		System.out.println(longestIncreasingSubsequence(arr4));
	}

}
