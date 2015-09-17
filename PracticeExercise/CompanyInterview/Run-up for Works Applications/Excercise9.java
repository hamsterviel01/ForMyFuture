import java.util.Arrays;
import java.util.Hashtable;


public class Excercise9 {
	public static int gcm(int a, int b){
		if (b==0) return a;
		return gcm(b, a%b);
	}
	
	public static void sortFractions(String[] input){
		if (input == null || input.length == 0) return;
		double[] value = new double[input.length];
		int[] numerator = new int[input.length];
		int[] denumerator = new int[input.length];
		Hashtable<Double, String> map = new Hashtable<Double, String>();
		
		for (int i=0; i<input.length; i++){
			String[] temp = input[i].split("/");
			int num = Integer.valueOf(temp[0]);
			int denum = Integer.valueOf(temp[1]);
			int gcm = gcm(Math.max(num, denum), Math.min(denum, num));
			numerator[i] = num/gcm;
			denumerator[i] = denum/gcm;
			value[i] = (double)numerator[i] / (double)denumerator[i];
			map.put(value[i], String.valueOf(numerator[i]) + "/" + String.valueOf(denumerator[i]));
		}
		
		Arrays.sort(value);
		for (int i=0; i<input.length; i++){
			input[i] = map.get(value[i]);
		}
	}
	
	public static void printArray(String[] input){
		if (input == null || input.length == 0) return;
		for (int i=0; i<input.length; i++){
			System.out.print(" " + input[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[]{"1/2", "2/8", "8/4", "7/3", "145/75"};
		sortFractions(input);
		printArray(input);
	}

}
