import java.util.*;

public class DynamicProgrammingSet8 {
	//Brute Force solution
	public static int smallestOperations(ArrayList<Integer> input){
		if (input.size() <= 2) return 0;
		int minValue = Integer.MAX_VALUE;

		for (int i=1; i<input.size()-1; i++){
			ArrayList<Integer> tempArr = (ArrayList<Integer>)input.clone();
			tempArr.remove(i);
			int tempValue = input.get(i-1)*input.get(i)*input.get(i+1) + smallestOperations(tempArr);
			if (tempValue < minValue){
				minValue = tempValue;
			}
		}

		return minValue;
	}

	//Dynamic Programming
	public static int smallestOperationsDynamic(ArrayList<Integer> input, int[][] cacheResult, int start, int end){
		if (cacheResult[start][end] != -1){
			return cacheResult[start][end];
		}

		int minValue = Integer.MAX_VALUE;
		for (int i=start; i<end; i++){
			int temp = smallestOperationsDynamic(input, cacheResult, start, i) + smallestOperationsDynamic(input, cacheResult, i+1, end) + 
				input.get(start)*input.get(i+1)*input.get(end+1);
			if (temp < minValue){
				minValue = temp;
			}
		}

		cacheResult[start][end] = minValue;

		return minValue;
	}

	public static int smallestOperationsDynamic(ArrayList<Integer> input){
		int[][] cacheResult = new int[input.size()][input.size()];

		for (int i=0; i<cacheResult.length; i++){
			for (int j=0; j<cacheResult.length; j++){
				if (i==j){
					cacheResult[i][j] = 0;
				} else {
					cacheResult[i][j] = -1;
				}
			}
		}

		return smallestOperationsDynamic(input, cacheResult, 0, input.size()-2);
	}

	public static void main(String[] args){
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(100, 60, 8, 50, 7, 34, 15, 67, 78, 100, 60, 8, 50, 7, 34, 15, 67, 78));
		System.out.println(smallestOperationsDynamic(input));
	}
}