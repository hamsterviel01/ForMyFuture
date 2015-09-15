import java.util.*;

public class MinimumNumberOfSquares {
	public static int minimumSquares(int n){
		int[] cache = new int[n+1];
		cache[0] = 1;
		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 3;

		for (int i=4; i<=n; i++){
			cache[i] = i;
			for (int j=1; j*j<=i; j++){
				if (cache[i] > 1 + cache[i-j*j]){
					cache[i] = 1 + cache[i-j*j];
				}
			}
		}

		return cache[n];
	}

	public static void main(String[] args){
		System.out.println(minimumSquares(8000));
	}
}