public class DynamicProgrammingSet13 {
	public static int cuttingRod(int[] price, int length, int[] cache){
		if (length == 0){
			return 0;
		}
		if (cache[length] != 0){
			return cache[length];
		}
		//i = length-1
		int max = 0;
		for (int i=0; i<=length-1; i++){
			int temp = price[i] + cuttingRod(price, length-i-1, cache);
			if (temp > max){
				max = temp;
			}
		}
		cache[length] = max;
		return cache[length];
	}
	
	public static int cuttingRod(int[] price){
		int[] cache = new int[price.length+1];
		return cuttingRod(price, price.length, cache);
	}
	
	public static void main(String[] args){
		int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(cuttingRod(price));
	}
}