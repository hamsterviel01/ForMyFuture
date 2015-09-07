import java.util.*;

public class Section9DynamicProgrammingEx4 {
	public static ArrayList<ArrayList<Integer>> returnAllSubset(int[] arr, int index){
		if (index == -1){
			return new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>()));
		}
		
		ArrayList<ArrayList<Integer>> subsets = returnAllSubset(arr, index-1);
		int length = subsets.size();
		for (int i=0; i<length; i++){
			ArrayList<Integer> newElement = (ArrayList<Integer>)subsets.get(i).clone();
			newElement.add(arr[index]);
			subsets.add(newElement); 
		}

		return subsets;
	}

	public static ArrayList<ArrayList<Integer>> returnAllSubset(int[] arr){
		return returnAllSubset(arr, arr.length-1);
	}

	public static void printSubset(ArrayList<ArrayList<Integer>> subsets){
		for (ArrayList<Integer> subset: subsets){
			System.out.println(subset);
		}
	}

	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 3};
		printSubset(returnAllSubset(arr));
	}
}