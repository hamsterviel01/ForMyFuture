public class WorksApplication20150803Excercise8 {
	public static void sergerateZeroAndOne(int[] input){
		int end = input.length-1;
		int start = 0;
		while (start < end) {
			if(input[start] == 1){
				if ((input[end]) == 0){
					//swap start with end, increment start and decrement end
					int temp = input[start];
					input[start] = input[end];
					input[end] = temp;
					end--;
					start++;
				} else {
					end--;
				}
			} else {
				start++;
			}
		}
	}

	public static void main(String[] args){
		int[] input = new int[]{0,0,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,1,1,1};
		sergerateZeroAndOne(input);
		for (int i=0; i<input.length; i++){
			System.out.print(" " + input[i]);
		}
	}
}