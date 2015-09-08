public class Section9DynamicProgrammingEx8 {
	public static int numberOfWays(int n, int denom){
		if (n < 0) return 0;
		if (n == 0) return 1;
		if (denom == 25) {
			return numberOfWays(n-25, 25) + numberOfWays(n-10, 10) + numberOfWays(n-5, 5) + numberOfWays(n-1, 1);
		}
		if (denom == 10) {
			return numberOfWays(n-10, 10) + numberOfWays(n-5, 5) + numberOfWays(n-1, 1);
		}
		if (denom == 5){
			return numberOfWays(n-5, 5) + numberOfWays(n-1, 1);
		}
		return 1;
	}

	public static int numberOfWays(int n){
		return numberOfWays(n, 25);
	}

	public static void main(String[] args){
		System.out.println(numberOfWays(3000));
	}
}