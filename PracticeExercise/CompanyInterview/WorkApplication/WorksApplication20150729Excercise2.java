//Find the longest common subsequence between 2 Str.

public class WorksApplication20150729Excercise2 {
	//Time complexity O(m^2*n^2)
	public static String longestCommonSubsequence(String str1, String str2){
		if (str1 == "" || str1.isEmpty() || str2 == "" || str2.isEmpty()) return "";
		//str1 - verticle, str2 - horizontal
		int[][] table = new int[str1.length()][str2.length()];
		int maxLength = 0;
		StringBuilder maxString = new StringBuilder();

		for (int i=0; i<str1.length(); i++){
			for (int j=0; j<str2.length(); j++){
				//since if char at str1 != char at str2 --> longest subsequence string will not increase
				StringBuilder str = new StringBuilder();
				if (str1.charAt(i) == str2.charAt(j)){
					if (i == 0 || j == 0){
						table[i][j] = 1;
					} else {
						str = getLocalMax(table, str1, i-1, j-1).append(str1.charAt(i));
						table[i][j] = str.length();
					}

					if (table[i][j] > maxLength){
						maxString = str;
					} 
				}
			}
		}

		return maxString.toString();
	}

	//Using Dynamic for this one, can reduce time complexity to (O(n + m) instead of O(n*m))
	public static StringBuilder getLocalMax(int[][] table, String str1, int n, int m){
		int max = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<=n; i++){
			for (int j=0; j<=m; j++){
				if (table[i][j] > max){
					max = table[i][j];
					sb.append(str1.charAt(i));
				}
			}
		}

		return sb;
	}

	//Solution from geekforgeek O(m*n)
	public static String longestCommonSubsequence1(String str1, String str2){
		if (str1 == "" || str1.isEmpty() || str2 == "" || str2.isEmpty()) return "";
		int[][] table = new int[str1.length() + 1][str2.length() + 1];

		//Build table of length for longest common subsequences
		for (int i=0; i<=str1.length(); i++){
			for (int j=0; j<=str2.length(); j++){
				if (i==0 || j==0){
					table[i][j] = 0;
				} else if (str1.charAt(i-1) == str2.charAt(j-1)){
					table[i][j] = table[i-1][j-1] + 1;
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}

		int i = str1.length();
		int j = str2.length();
		StringBuilder sbrevesed = new StringBuilder();


		while (i>0 & j>0){
			if (str1.charAt(i-1) == str2.charAt(j-1)){
				sbrevesed.append(str1.charAt(i-1));
				i--;
				j--;
			} else {
				if (table[i-1][j] > table[i][j-1]){
					i--;
				} else {
					j--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int k=sbrevesed.length()-1; k>=0; k--){
			sb.append(sbrevesed.charAt(k));
		}

		return sb.toString();
	}

	//ultility function
	public static void printTable(String str1, String str2, int[][] table){
		System.out.printf("%3s", " ");
		for (int j=0; j<str2.length(); j++) {
			System.out.printf("%1s%2d", str2.charAt(j), j);
		}
		System.out.println();
		for (int i=0; i<str1.length(); i++){
			System.out.printf("%1s%2d", str1.charAt(i), i);
			for (int j=0; j<str2.length(); j++){
				System.out.printf("%3d", table[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		System.out.println(longestCommonSubsequence("bnmscabaaaaf", "bcaaaate"));
		System.out.println(longestCommonSubsequence1("bnmscabaaaaf", "bcaaaate"));
	}
}