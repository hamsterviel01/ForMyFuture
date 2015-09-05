public class WorksApplicationsExcercise9 {
	public static void heapSort(double[] input){
		for (int i=0; i<(input.length-1)/2; i++){
			heapify(input, i);
		}
	}

	public static void heapify(double[] input, int n){
		for (int i=(input.length-1+n)/2 - 1; i>=n; i--){
			swap(input, i, n);
		}
		printArray(input);
	}

	public static void swap(double[] input, int i, int n){
		System.out.println("i=" + i + " n=" + n);
		if (input[i] < input[2*i+1-n]){
			double temp = input[i];
			input[i] = input[2*i+1-n];
			input[2*i+1-n] = temp;
		}
		if (2*i+2-n < input.length){
			if (input[i] < input[2*i+2-n]){
				double temp = input[i];
				input[i] = input[2*i+2-n];
				input[2*i+2-n] = temp;
			}
		}	
	}

	public static void printArray(double[] input){
		for (int i=0; i<input.length-1; i++){
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		double[] arr = new double[]{1, 3, 5, 2, 3, 5, 8, 9};
		heapSort(arr);
		printArray(arr);
	}
}