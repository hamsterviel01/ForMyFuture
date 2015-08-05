import java.util.*;

public class RecursionAndDynamicProgramming92 {
	public static int countPossibleRoute(int x, int y, int[][] possibleRoute){
		if (x == 0 || y == 0){
			return 1;
		}

		if (possibleRoute[x][y]!=0){
			return possibleRoute[x][y];
		}

		int sum = 0;
		for (int i=0; i<=x; i++){
			sum = sum + countPossibleRoute(i, y-1, possibleRoute);
		}
		possibleRoute[x][y] = sum;
		return sum;
	}

	public static int count(int x, int y){
		int[][] possibleRoute = new int[x + 1][y + 1];
		possibleRoute[0][0] = 0;
		possibleRoute[0][1] = 1;
		possibleRoute[1][0] = 1;
		possibleRoute[1][1] = 2;
		
		return countPossibleRoute(x, y, possibleRoute);
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();

		System.out.println(count(x, y));
	}
}