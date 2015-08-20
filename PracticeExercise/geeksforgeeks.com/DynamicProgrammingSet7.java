/**
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/
public class DynamicProgrammingSet7 {
	public static int countWaysOfChange(int[] s, int n, int index, int[][] cache){
		if (n == 0) return 1;
		if (n < 0) return 0;
		if (index < 0 && n > 0) return 0;
		if (cache[n][index] != -1){
			return cache[n][index];
		} 

		cache[n][index] = countWaysOfChange(s, n, index-1, cache) + countWaysOfChange(s, n-s[index], index, cache);
		return cache[n][index];
	}

	public static void main(String[] args){
		int[] S = new int[]{2, 5, 1};
		int n = 10;
		int[][] cache = new int[n+1][S.length];
		for (int[] arr: cache){
			for (int i=0; i<arr.length; i++){
				arr[i] = -1;
			}
		}
		System.out.println(countWaysOfChange(S, n, S.length-1, cache));
		//System.out.println(countWaysOfChange(S, n, S.length-1));
	}
}
//Why my solution didn't work??? --> well now it works.
/**
	public static int countWaysOfChange(int[] s, int n, int index){
		if (n==0) return 1;
		if (n<0) return 0;
		if (index == 0 && n%s[index] != 0) return 0;

		int sum = 0;
		for (int i=index; i>=0; i--){
			if (n>=s[i]){
				sum = sum + countWaysOfChange(s, n-s[i], i);
				System.out.println("sum=" + sum + " i=" + i + " n=" + n + " s[index]=" + s[i]);
			}
		}
		return sum;
	}

	public static void printArray(int[] arr){
		for(int obj: arr){
			System.out.print(" " + obj);
		}
		System.out.println();
	}

*/