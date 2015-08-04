import java.util.*;

public class WorksApplication20150804Excercise11 {
	public static int findGCD(int p, int q){
		int tempQ = q;
		int tempP = p;
		while (tempQ!=0){
			int temp = tempQ;
			tempQ = tempP%tempQ;
			tempP = temp;
		}

		return tempP;
	}

	public static HashSet<String> findAllIrreducibleFracs(int p){
		HashSet<String> result = new HashSet<String>();
		for (int i=2; i<p; i++){
			int gcd = findGCD(p, i);
			if (i/gcd != 1){
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(p/gcd));
				sb.append('/');
				sb.append(String.valueOf(i/gcd));
				result.add(sb.toString());
			}
		}

		return result;
	}

	public static HashSet<String> findAllIrreducibleFracs(int m, int n){
		HashSet<String> result = new HashSet<String>();
		for (int i=m; i<=n; i++){
			result.addAll(findAllIrreducibleFracs(i));
		}

		return result;
	}

	public static void main(String[] args){
		System.out.println(findAllIrreducibleFracs(1, 10));
	}
}