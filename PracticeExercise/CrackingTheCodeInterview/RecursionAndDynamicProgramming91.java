/**
Lesson learnt:
- Alway remember to call the function within the function, if not this is not recursive --> moron know that, let alone you.
- Space complexity of Recursive is O(N) - N is n time you call the function.
- For Dynamic, develop recursive solution first, before adding a data structure to hold result.
- Try to recap answer into shorter form
*/

import java.util.*;

public class RecursionAndDynamicProgramming91 {
	public static int countPossibleWay(int n, int[] possibleWay){
		if (possibleWay[n] != 0){
			return possibleWay[n];
		}

		if (n%3 == 0){
			possibleWay[n] = countPossibleWay(n-3, possibleWay)*3;
			return possibleWay[n];
		}
		possibleWay[n] = countPossibleWay(n - n%3, possibleWay)*(n%3);
		return possibleWay[n];
	}

	public static int count(int n){
		int[] possibleWay = new int[n + 1];
		for (int i=0; i<=3; i++){
			possibleWay[i] = i;
		}
		return countPossibleWay(n, possibleWay);
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(count(n));
	}
}