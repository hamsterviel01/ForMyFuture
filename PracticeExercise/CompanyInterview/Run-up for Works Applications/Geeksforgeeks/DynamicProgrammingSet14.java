import java.util.*;

public class DynamicProgrammingSet14 {
	public static int maxIncreasingSubsequence(int[] arr, int n, ArrayList<Stack<Integer>> cache){
		Stack<Integer> maxSeq = new Stack<Integer>();
		int i = n-1;
		while (i >=0 && cache.get(i).peek() >= arr[n]){
			i--;
		}
		if (i!=-1){
			maxSeq = (Stack<Integer>)cache.get(i).clone();
 		}
		maxSeq.push(arr[n]);
		cache.add(maxSeq);
		int sum = 0;
		for (int j: maxSeq){
			sum = sum + j;
		}
		return sum;
	}

	public static int maxIncreasingSubsequence(int[] arr){
		ArrayList<Stack<Integer>> cache = new ArrayList<Stack<Integer>>();
		int max = 0;
		for (int i=0; i<arr.length; i++){
			int temp = maxIncreasingSubsequence(arr, i, cache);
			if (temp > max){
				max = temp;
			}
		}
		return max;
	}

	public static void main(String[] args){
		int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
		System.out.println(maxIncreasingSubsequence(arr));
	}
}