public class Section9DynamicProgrammingEx1 {
	public static int possibleWaysToRunUp(int n, int[] cache){
		if (n==0) return 0;
		if (n==1) return 1;
		if (n==2) return 2;
		if (n==3) return 4;
		if (cache[n] != 0) return cache[n];

		cache[n] = possibleWaysToRunUp(n-1) + possibleWaysToRunUp(n-2) + possibleWaysToRunUp(n-3);
		return cache[n];
	}

	public static int possibleWaysToRunUp(int n){
		int cache[] = new int[n+1];
		return possibleWaysToRunUp(n, cache);
	}

	public static void main(String[] args){
		System.out.println(possibleWaysToRunUp(9000));
	}
}