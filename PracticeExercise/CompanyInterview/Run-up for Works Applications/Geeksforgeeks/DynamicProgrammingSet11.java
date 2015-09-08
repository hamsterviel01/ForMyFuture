public class DynamicProgrammingSet11 {
	//n eggs, k floors --> least number of egg dropping
	public static int minimalTimeToDropEggs(int n, int bottom, int top){
		if (n == 1){
			//Dropping is guaranteed
			if (bottom == top){
				return 1;
			} else { //Dropping is not guaranteed
				//Return max value will caused issue to be overflowed
				return 
			}
		}
		if (n>1 && bottom == top){
			return 1;
		}
		
		int smallest = Integer.MIN_VALUE;
		for (int i=bottom; i<=top; i++){
			//if egg break at level i
			int smallest1 = 1 + minimalTimeToDropEggs(n-1, bottom, i);
			//if egg don't break at level i
			int smallest2 = 1 + minimalTimeToDropEggs(n-1, i, top);
			int small = Math.max(smallest1, smallest2);
			if (small < smallest){
				smallest = small;
			}
		}
		return smallest;
	}

	public static void main(String[] args){
		System.out.println(minimalTimeToDropEggs(2, 1, 36));
	}
}