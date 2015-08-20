public class DynamicProgrammingSet5 {
	//convert str2 to str1
	public static int editDistanceShortest(String str1, String str2, int start1, int start2, int[][] minRecords){
		//Base case
		if (start1 == str1.length()) return str2.length() - start2;
		if (start2 == str2.length()) return str1.length() - start1;

		if (minRecords[start1][start2] != -1){
			return minRecords[start1][start2];
		} else {
			if (str1.charAt(start1) == str2.charAt(start2)){
				minRecords[start1][start2] = editDistanceShortest(str1, str2, start1+1, start2+1, minRecords);
				return minRecords[start1][start2];
			} else {
				minRecords[start1][start2] = min(1 + editDistanceShortest(str1, str2, start1+1, start2+1, minRecords), /*replace at str2 charAt(start2) by str1.charAt(start1)*/
					1 + editDistanceShortest(str1, str2, start1, start2 + 1, minRecords), /*delete char at str2*/
					1 + editDistanceShortest(str1, str2, start1+1, start2, minRecords)); /*insert char at str2*/
				return minRecords[start1][start2];
			}	
		}
	}

	public static int editDistanceShortest(String str1, String str2){
		int[][] minRecords = new int[str1.length()][str2.length()];

		for (int i=0; i<str1.length(); i++){
			for (int j=0; j<str2.length(); j++){
				minRecords[i][j] = -1;
			}
		}

		return editDistanceShortest(str1, str2, 0, 0, minRecords);
	}

	//utility func
	public static int min(int... numbers){
		int min = Integer.MAX_VALUE;
		for (int each: numbers){
			min = Math.min(min, each);
		}
		return min;
	}

	public static void main(String[] args){
		System.out.println(editDistanceShortest("abcgedfdfsdfasdfg", "abdefgfggasdfasdfasdghasdfasdf"));
		// System.out.println(editDistanceShortestNonDynamic("abcgedfdfsdfasdfg", "abdefgfggasdfasdfasdghasdfasdf", 0, 0));
	}
}

/**
	public static int editDistanceShortestNonDynamic(String str1, String str2, int start1, int start2){
		//Base case
		if (start1 == str1.length()) return str2.length() - start2;
		if (start2 == str2.length()) return str1.length() - start1;

		if (str1.charAt(start1) == str2.charAt(start2)){
			return editDistanceShortestNonDynamic(str1, str2, start1+1, start2+1);
		} else {
			return min(1 + editDistanceShortestNonDynamic(str1, str2, start1+1, start2+1), /*replace at str2 charAt(start2) by str1.charAt(start1)*/
				1 + editDistanceShortestNonDynamic(str1, str2, start1, start2 + 1), /*delete char at str2*/
				1 + editDistanceShortestNonDynamic(str1, str2, start1+1, start2)); /*insert char at str2*/
		}	
	}
*/