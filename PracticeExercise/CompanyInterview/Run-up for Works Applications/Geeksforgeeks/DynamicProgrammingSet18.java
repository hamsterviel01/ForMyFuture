import java.util.ArrayList;

public class DynamicProgrammingSet18 {	
	public static boolean isPartitionable(int[] arr, int n, int sum1, int sum2, int halfSum, 
			ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<ArrayList<Integer>> result){
		if (sum2 > halfSum || sum1 > halfSum){
			return false;
		}
		if (n == arr.length){
			if (sum1 != sum2){
				return false;
			} else {
				result.add(arr1);
				result.add(arr2);
				return true;
			}
		}
		ArrayList<Integer> arr1New = (ArrayList<Integer>)arr1.clone();
		arr1New.add(arr[n]);
		ArrayList<Integer> arr2New = (ArrayList<Integer>)arr2.clone();
		arr2New.add(arr[n]);
		return isPartitionable(arr, n+1, sum1 + arr[n], sum2, halfSum, arr1New, arr2, result) || isPartitionable(arr, n+1, sum1, sum2+arr[n], halfSum, arr1, arr2New, result);
	}
	
	public static void isPartitionable(int[] arr){
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		boolean partition;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (int i=0; i<arr.length; i++){
			sum = sum + arr[i];
		}
		if (sum%2 != 0){
			partition = false;
		} else {
			partition = isPartitionable(arr, 0, sum1, sum2, sum/2, arr1, arr2, result);
		}
		System.out.println(partition);
		if (partition){
			System.out.println("The array can be partitioned into 2 equal sum set as " + result.get(0) + " and " + result.get(1));
		} else {
			System.out.println("The array cannot be partitioned into equal sum sets.");
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1, 5, 11, 5, 12, 15, 29, 31, 45, 27, 13};
		isPartitionable(arr);
	}
}