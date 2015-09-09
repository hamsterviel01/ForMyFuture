import java.util.*;

public class WorksApplicationsExcercise11 {
	public static HashSet<String> returnAllFractions(int m, int n){
		HashSet<String> fracs = new HashSet<String>();
		for (int i=m; i<=n; i++){
			for (int j=1; j<m; j++){
				int gcd = gcd(i, j);
				int numerator = i/gcd;
				int denumerator = j/gcd;
				fracs.add(numerator + "/" + denumerator);
			}
		}

		return fracs;
	}

	public static int gcd(int i, int j){
		if (j==0) return i;
		return gcd(j, i%j);
	}
	public static void main(String[] args){
		System.out.println(returnAllFractions(100, 200));
	}
}