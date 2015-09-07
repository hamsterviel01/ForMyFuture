public class Section9DynamicProgrammingEx3 {
	//Asumming order is increasing
	public static int returnMagicIndex(int[] arr, int start, int end){
		if (start > end || start < 0 || end > arr.length-1) return -1;
		int i = (start+end)/2;
		if (arr[i] == i) return i;
		int rightIndex = Math.max(arr[i], i+1);
		int right = returnMagicIndex(arr, rightIndex, end);
		if (right != -1){
			return right;
		}
			
		int leftIndex = Math.min(arr[i], i-1);
		return returnMagicIndex(arr, start, leftIndex);
	}

	public static void main(String[] args){
		int[] arr = new int[]{-4, -2, -2, 0, 2, 3, 4, 6, 7, 8, 8, 9, 9, 10, 12, 15, 22};
		System.out.println(returnMagicIndex(arr, 0, arr.length-1));
	}
}