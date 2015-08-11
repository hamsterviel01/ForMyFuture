import java.util.*;

/**
Algorithm

*/

public class RecursionAndDynamicProgramming92 {

	//Follow up probleam
	public static boolean findPossibleRoute(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> points){
		Point currentPoint = new Point(x, y);
		if (x == 0 && y == 0){
			return true;
		}

		if (!isFree(0, 0)){
			return false;
		}

		if (points.containsKey(currentPoint)){
			return false;
		}

		boolean success = false;
		points.put(currentPoint, false);
		if (x > 0 && isFree(x-1, y)){
			success = findPossibleRoute(x-1, y, path, points);
		} else if (y > 0 && isFree(x, y-1)){
			success = findPossibleRoute(x, y-1, path, points);
		} else {
			success = false;
		}

		if (success){
			path.add(currentPoint);
		}
		//points.put(currentPoint, success);
		return success;
	}

	public static boolean isFree(int x, int y){
		boolean[][] blockages = new boolean[][] {
			{true, true, true, true},
			{true, true, false, false},
			{true, false, true, true},
			{true, false, true, true}
		};

		return blockages[x][y];
	}

	public static void main(String[] args){
		Hashtable<Point, Boolean> points = new Hashtable<Point, Boolean>();
		ArrayList<Point> path = new ArrayList<Point>();
		System.out.println(findPossibleRoute(3, 3, path, points));

		//Print out path
		Iterator<Point> it = path.iterator();
		while(it.hasNext()){
			Point entry = it.next();
			System.out.println(entry.x + ":" + entry.y);
		}
	}
}

class Point {
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

















// 	public static int countPossibleRoute(int x, int y, int[][] possibleRoute){
// 		if (x == 0 || y == 0){
// 			return 1;
// 		}

// 		if (possibleRoute[x][y]!=0){
// 			return possibleRoute[x][y];
// 		}

// 		int sum = 0;
// 		for (int i=0; i<=x; i++){
// 			sum = sum + countPossibleRoute(i, y-1, possibleRoute);
// 		}
// 		possibleRoute[x][y] = sum;
// 		return sum;
// 	}

// 	public static int count(int x, int y){
// 		int[][] possibleRoute = new int[x + 1][y + 1];
// 		possibleRoute[0][0] = 0;
// 		possibleRoute[0][1] = 1;
// 		possibleRoute[1][0] = 1;
// 		possibleRoute[1][1] = 2;
		
// 		return countPossibleRoute(x, y, possibleRoute);
// 	}