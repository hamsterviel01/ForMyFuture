public class RecursionAndDynamicProgramming93Solution2{
	//Assume that array is ascending. Using binary search for this.
	public static int findMagicIndex(int[] input, int start, int end){
		int mid = (end + start)/2;
		int result = -1;
		if (start > end){
			return -1;
		}

		if (input[mid] == mid){
			return mid;
		} 
		
		//this is a very smart move to generalize the cases, 
		//don't need to divided code into input[mid] > mid and input[mid] < mid 
		//since we will need to search for bothside with the same recursive function anyway
		int leftIndex = Math.min(input[mid], mid-1);
		result = findMagicIndex(input, start, leftIndex);
		if (result >= 0){
			return result;
		}

		int rightIndex = Math.max(input[mid], mid+1);
		result = findMagicIndex(input, rightIndex, end);

		return result;
	}

	public static void main(String[] args){
		int[] input = new int[]{-10, -5, -3, 2, 2, 3, 4, 8, 9, 12, 13};

		System.out.println(findMagicIndex(input, 0, input.length-1));
	}
}