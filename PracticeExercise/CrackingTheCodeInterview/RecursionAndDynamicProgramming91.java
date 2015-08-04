/**
Lesson learnt:
- Alway remember to call the function within the function, if not this is not recursive --> morons know that, let alone you.
- Space complexity of Recursive is O(N) - N is n time you call the function.
- For Dynamic, develop recursive solution first, before adding a data structure to hold result.
- Try to recap answer into shorter form
*/

import java.util.*;

public class RecursionAndDynamicProgramming91 {
	/**This solution is wrong, because it was failed to count the case where n = 4 and children jump in seuqence (2, 2)
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
	*/
	public static int countPossibleWay(int n, int[] map){
		if (n < 0){
			return 0;
		} else if (n == 0){
			return 1;
		} else if (map[n] > -1){//Here is where dynamic programming actually happened.
			return map[n];
		} else {
			//although simple, but to derive this expression is more complicated:
			//actually: map[n] = countPossibleWay(n-1, map)*1 + countPossibleWay(n-2, map)*(1 + 1 - 1) + countPossibleWay(n-3, map)*(1 + 1 + 1 + 1 - 1 - 1 - 1);
			map[n] = countPossibleWay(n-1, map) + countPossibleWay(n-2, map) + countPossibleWay(n-3, map);
			return map[n];
		}
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n+1];
		for (int i=1; i<n+1; i++){
			arr[i] = -1;
		} 
		System.out.println(countPossibleWay(n, arr));
	}
}