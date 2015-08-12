/**
2 solution share the same speed, 
but solving this case using recursive method is cleaner
*/

public class RecursionAndDynamicProgramming98 {
	public static int calculateCombination(int n){
		int count = 0;
		if (n == 0) return 0;
		if (n == 1) return 1;
		for (int i=0; i<=n/25; i++){
			int m = n - i*25;
			for (int j=0; j<=m/10; j++){
				int o = m - j*10;
				for (int k=0; k<=o/5; k++){
					count++;
					int p = o - k*5;
				}
			}
		}
		return count;
	}

	public static int calculateCombinationRecur(int n, int denom){
		int next_denom = 0;
		int way  = 0;
		switch(denom){
			case 25:
			next_denom = 10;
			break;
			case 10:
			next_denom = 5;
			break;
			case 5:
			next_denom = 1;
			break;
			case 1:
			return 1;
		}
		int denomNo = n/denom;
		for (int i=0; i<=denomNo; i++){
			way = way + calculateCombinationRecur(n-i*denom, next_denom);
		}
		return way;
	}

	public static void main(String[] args){
		System.out.println(calculateCombination(25));
		System.out.println(calculateCombinationRecur(25, 25));
	}

}