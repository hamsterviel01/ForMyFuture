/**
Given an array of random numbers:
a) Find longest monotonically increasing subsequence. --> O(n)
b) Print all subsequence (LIS) in the array 
*/
import java.util.*;

public class WorksApplication20150730Excercise6 {
	public static void printMonoIncreaseSequence(int[] input){
		//to print all subsequence --> print all subsequence start at int[i] (i = 0 --> endpoint) and add them to HashSet. --> O(n*n)
		ArrayList<LinkedList<Integer>> list = printMonoIncreaseSequence(input, input.length-1);

		for (int i=1; i<list.size(); i++){
			System.out.println(list.get(i));
		}

		// Stack<Integer> longestSeq = new Stack<Integer>();
		// int i=input.length-1;
		// while (i>=0){
		// 	if ()
		// }
	}

	public static ArrayList<LinkedList<Integer>> printMonoIncreaseSequence(int[] input, int end){
		if (end == 0){
			ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
			if (input[0] != 0){
				list.add(new LinkedList<Integer>(Arrays.asList(0)));
			}
			list.add(new LinkedList<Integer>(Arrays.asList(input[end])));
			return list;
		} else {
			ArrayList<LinkedList<Integer>> list = printMonoIncreaseSequence(input, end-1);
			int length = list.size();
			for (int i=0; i<length; i++){
				if (list.get(i).getLast() < input[end]){
					LinkedList<Integer> sequence = new LinkedList<Integer>();
					for (int j=0; j<list.get(i).size(); j++){
						sequence.add(list.get(i).get(j));
					}
					sequence.offerLast(input[end]);
					if (sequence.getFirst() == 0){
						sequence.removeFirst();
					}
					list.add(sequence);
				}
			}
			return list;
		}
	}

	public static void main(String[] args){
		int[] input = new int[]{5, 8, 10, 6, 7, 8, 13, 9, 17, 14};
		printMonoIncreaseSequence(input);
	}
}