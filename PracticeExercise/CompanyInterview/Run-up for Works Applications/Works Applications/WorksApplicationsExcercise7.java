import java.util.*;

/**
There is algorithm run with O(n*n!), following these steps:
- Sort the input string
*/

public class WorksApplicationsExcercise7 {
	public static ArrayList<String> allPermutation(String str, int n){
		ArrayList<String> newPermu = new ArrayList<String>();
		if (n == 0){
			newPermu.add(String.valueOf(str.charAt(0)));
			return newPermu;
		}
		if (n == 1){
			newPermu.add(String.valueOf(str.charAt(0)) + String.valueOf(str.charAt(1)));
			newPermu.add(String.valueOf(str.charAt(1))+ String.valueOf(str.charAt(0)));
			return newPermu;
		}
		ArrayList<String> allPermu = allPermutation(str, n-1);
		for (String permu: allPermu){
			for (int i=n-1; i>=0; i--){
				StringBuilder sb = new StringBuilder();
				sb.append(permu.substring(0, i));
				sb.append(str.charAt(n));
				sb.append(permu.substring(i));
				newPermu.add(sb.toString());
			}
			StringBuilder sb = new StringBuilder();
			sb.append(permu);
			sb.append(str.charAt(n));
			newPermu.add(sb.toString());
		}
		return newPermu;
	}

	public static TreeSet<String> sortAllPermuatation(String str){
		ArrayList<String> allPermu = allPermutation(str, str.length() - 1);
		TreeSet<String> allSortedPermu = new TreeSet<String>();

		for (String permu: allPermu){
			//O(log(n)) for add
			allSortedPermu.add(permu);
		}

		return allSortedPermu;
	}

	public static void main(String[] args){
		System.out.println(sortAllPermuatation("defghik"));
	}
}