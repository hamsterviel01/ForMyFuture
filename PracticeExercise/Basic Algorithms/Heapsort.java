public class Heapsort {
	public static void heapsort(int[] input){
		//Remember to use input.length-1 as end
		heapsort(input, input.length-1);
	}

	public static void heapsort(int[] input, int end){
		for(int i=(end-1)/2; i>=0; i--){
			heapify(input, i, end);
		}
		//swap input[0] with input[end]
		int temp = input[0];
		input[0] = input[end];
		input[end] = temp;
		if (end > 1){
			heapsort(input, end-1);
		}


	}

	//Remember heapify take 3 args
	public static void heapify(int[] input, int i, int end){
		if (input[i] < input[2*i + 1]){
			int temp = input[i];
			input[i] = input[2*i + 1];
			input[2*i + 1] = temp;
		}
		if (2*i + 2 <= end){
			if (input[i] < input[2*i+2]){
				int temp = input[i];
				input[i] = input[2*i+2];
				input[2*i+2] = temp;
			}
		}
	}

	public static void main(String[] args){
		int[] input = new int[]{1,3,2,6,4,8,9,14,7, 18, 9, 8, 2};
		heapsort(input);
		for (int i=0; i<input.length; i++){
			System.out.print(input[i] + " ");
		}
	}
}