public class DynamicProgrammingSet24 {
	public static int minimumJumps(int[] arr, int currentPos, int[] cache){
		if (currentPos >= arr.length-1){
			return 0;
		}
		if (cache[currentPos] != 0){
			return cache[currentPos];
		}
		int min = Integer.MAX_VALUE;
		for (int i=currentPos+1; i<=currentPos+arr[currentPos]; i++){
			int temp = minimumJumps(arr, i, cache);
			if (temp < min){
				min = temp;
			}
		}
		cache[currentPos] = 1 + min;
		return cache[currentPos];
	}
	
	public static int minimumJumps(int[] arr){
		int[] cache = new int[arr.length];
		return minimumJumps(arr, 0, cache);
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{15, 3, 5, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minimumJumps(arr));
	}
}