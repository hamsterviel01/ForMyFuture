public class DynamicProgrammingSet11 {
	//n eggs, k floors --> least number of egg dropping
	public static int minimalTimeToDropEggs(int n, int floors, int[][] cache){
		if (floors == 1){
			return 1;
		}
		if (n == 1){
			cache[n][floors] = floors;
			return floors;
		}
		if (cache[n][floors] != 0){
			return cache[n][floors];
		}
		
		int smallest = Integer.MAX_VALUE;
		for (int i=1; i<=floors; i++){
			//if egg break at level i
			int eggBreak = 1 + minimalTimeToDropEggs(n-1, i-1, cache);
			//if egg don't break at level i
			int eggNotBreak = 1 + minimalTimeToDropEggs(n, floors-i, cache);
			int worstCase = Math.max(eggBreak, eggNotBreak);
			if (worstCase < smallest){
				smallest = worstCase;
			}
		}
		cache[n][floors] = smallest;
		return cache[n][floors];
	}
	
	public static int minimalTimeToDropEggs(int n, int floors){
		int[][] cache = new int[n+1][floors+1];
		return minimalTimeToDropEggs(n, floors, cache);
	}
	
	public static void main(String[] args){
		System.out.println(minimalTimeToDropEggs(2, 36));
	}
}