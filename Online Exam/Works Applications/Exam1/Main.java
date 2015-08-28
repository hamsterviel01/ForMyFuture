import java.util.*;
import java.io.*;

/**
There are few problems right now:
- About point -1: cannot return value as -1 because then what happen if all direction is blocked , it will return max value as current point -1, and if current point is large enough, it can still be maximum value without ever reaching the other end
- If I allow the snake to go up and down, it will create a loop, many terrible loop that will cause this program to never stop --> to to resolve this issue?

Using path to check for loop??
if next point is already in the path, exluded it.

*/

public class Main {
	//Need to check if number of input match m and n
	public static int findMaximumPoint(int[][] matrixPoint, int x, int y, int[][] cache, ArrayList<Point> path){
		//if the snake has gone outside the matrix
		if (y > matrixPoint[0].length-1){
			return 0;
		}
		//if this position has been calculated
		if (cache[x][y] != -2) return cache[x][y];

		//if this position is blocked
		if (matrixPoint[x][y] == -1){
			cache[x][y] = -1;
			return cache[x][y];
		}

		//if the snake is at top or bottom
		System.out.println(path);
		if (x == 0) {
			int currentPoint = matrixPoint[x][y];
			for (Point p: path){
				currentPoint =  currentPoint + matrixPoint[p.x][p.y];
			}
			path.add(new Point(x, y));
			int temp = findMaximumPoint(matrixPoint, matrixPoint.length-1, y, cache, path);
			return max(currentPoint, temp);
		} else if (x == matrixPoint.length-1){
			int currentPoint = matrixPoint[x][y];
			for (Point p: path){
				currentPoint =  currentPoint + matrixPoint[p.x][p.y];
			}
			path.add(new Point(x, y));
			int temp = findMaximumPoint(matrixPoint, 0, y, cache, path);
			return max(currentPoint, temp);
		}

		//if the snake has reached right border
		if (y == matrixPoint[0].length){
			path.add(new Point(x, y));
			cache[x][y] = matrixPoint[x][y] + max(findMaximumPoint(matrixPoint, x-1, y, cache, path), 
				findMaximumPoint(matrixPoint, x+1, y, cache, path));
			return cache[x][y];
		}

		path.add(new Point(x, y));
		int max = max(findMaximumPoint(matrixPoint, x-1, y, cache, path), findMaximumPoint(matrixPoint, x+1, y, cache, path), 
			findMaximumPoint(matrixPoint, x, y+1, cache, path));
		if (max == -1){
			cache[x][y] = -1;
			return cache[x][y];
		} else {
			cache[x][y] = max + matrixPoint[x][y];
			return cache[x][y];
		}
	}

	public static void checkForLoop(int x, int y, ArrayList<>)

	public static int max(int... values){
		//equal to -1 because the smallest value in matrixPoint is -1
		int max = -1;
		for (int i: values){
			if (i > max){
				max = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO: Implement your program
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

			//Do I need to check if only 2 int was input in the first line???
			String[] line = rd.readLine().split(" ");
			int[][] matrix = new int[Integer.valueOf(line[0])][Integer.valueOf(line[1])];
			int[][] cache = new int[Integer.valueOf(line[0])][Integer.valueOf(line[1])];

			for (int i=0; i<cache.length; i++){
				for (int j=0; j<cache[0].length; j++){
					cache[i][j] = -2;
				}
			}
			int i = 0;
			String inputLine;
			while ((inputLine = rd.readLine()) != null && inputLine.length() > 0){
				String[] input = inputLine.split(" ");
				for(int j=0; j<input.length; j++){
					matrix[i][j] = Integer.valueOf(input[j]);
				}
				i++;
			}

			/**

			FAIL WHEN MATRIX[0][0] = -1

			*/
			System.out.println(findMaximumPoint(matrix, 0, 0, cache, new ArrayList<Point>()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Point {
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}