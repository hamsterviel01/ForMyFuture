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

	public static void main(String[] args){
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(100, 60, 8, 50, 7));
		System.out.println(smallestOperations(input));
	}
}

/**
	This algorithm is wrong because it base on following assumption
		- {a, b, c, d} if b > c --> a*b*c + a*c*d < b*c*d + a*b*d
	This assumption is wrong because if a >> d while b > c --> the inequation will be reverted.
	public static int smallestOperations(ArrayList<Integer> input){
		if (input.size() < 3) return 0;

		ArrayList<Integer> tempArr = (ArrayList<Integer>)input.clone();
		int maxIndex = searchBiggest(input);
		tempArr.remove(maxIndex);

		return input.get(maxIndex-1)*input.get(maxIndex)*input.get(maxIndex+1) + smallestOperations(tempArr);
	}

	//utility func
	public static int searchBiggest(ArrayList<Integer> input){
		int maxIndex = 1;
		for(int i=2; i<input.size()-1; i++){
			if (input.get(i) > input.get(maxIndex)){
				maxIndex = i;
			}
		}
		return maxIndex;
	}
*/