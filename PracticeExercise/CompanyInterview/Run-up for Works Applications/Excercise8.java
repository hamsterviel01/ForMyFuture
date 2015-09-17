
public class Excercise8 {
	public static int[] sergerateOneAndZero(int[] input){
		if (input == null) return null;
		int start = 0;
		int end = input.length - 1;
		while (start < end){
			if (input[start] == 1){
				while (end>start && input[end] != 0){
					end--;
				}
				int temp = input[start];
				input[start] = input[end];
				input[end] = temp;
			} 
			start++;
		}
		
		return input;
	}
	
	public static void printArray(int[] arr){
		if (arr == null) return;
		for (int i=0; i<arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{0, 0, 0, 0, 0, 0};
		int[] input2 = new int[]{1, 1, 1, 1};
		int[] input1 = new int[]{0, 1, 0, 1, 1, 1, 0, 0, 0};
		int[] input3 = new int[]{};
		int[] input4 = null;
		printArray(sergerateOneAndZero(input));
		printArray(sergerateOneAndZero(input1));
		printArray(sergerateOneAndZero(input2));
		printArray(sergerateOneAndZero(input3));
		printArray(sergerateOneAndZero(input4));
	}

}
