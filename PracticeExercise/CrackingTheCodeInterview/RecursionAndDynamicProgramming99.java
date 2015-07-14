import java.util.*;

/**
Lesson learnt:
- Thing more careful before implement the algorithm, and if along the way, you find out that it is too complicated, need to rethink the process.
- The observation to check if two queen shared the same diagonal --> very good observation indeed --> how can I think like that 
	--> think harder --> I tends to content with my first solution and that was usually inefficient
*/

public class RecursionAndDynamicProgramming99 {
	static int GRID_SIZE = 8;

	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) { // Found valid placement
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col; // Place queen
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	/* Check if (rowl, columnl) is a valid spot for a queen by checking
	* if there is a queen in the same column or diagonal. We don't
	* need to check it for queens in the same row because the calling
	* placeQueen only attempts to place one queen at a time. We know
	* this row is empty. */
	public static boolean checkValid(Integer[] columns, int rowl, int columnl) {
		for (int row2 = 0; row2 < rowl; row2++) {
			int column2 = columns[row2];
			/* Check if (row2, column2) invalidates (rowl, columnl) as a
			* queen spot. */

			/* Check if rows have a queen in the same column */
			if (columnl == column2) {
				return false;
			}

			/* Check diagonals: if the distance between the columns
			* equals the distance between the rows, then they're in the
			* same diagonal. */
			int columnDistance = Math.abs(column2 - columnl);

			/* rowl > row2, so no need for abs */
			int rowDistance = rowl - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		int row = 0;
		Integer[] columns = new Integer[8];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(row, columns, results);
		int count = 0;
		for (Integer[] result: results){
			for (int i=0; i<result.length; i++){
				System.out.print(i*10 + result[i] + " ;");
			}
			System.out.println();
			count++;
		}
		System.out.println(count);
	}
}

/**
My incorrect and inefficient solution:
	//int map contains available spaces for next queen.
	public static void availSpace(int queen, HashSet<Integer> map, ArrayList<Integer> queensPos, ArrayList<ArrayList<Integer>> allQueensPos){
		int x = queen/10;
		int y = queen%10;
		if (queensPos.size() < 8){
			if (map.contains(queen)){
				//eliminate all horizontal + vertical blocks
				for (int i=0; i<8; i++){
					if (map.contains(x*10 + i)){
						map.remove(x*10 + i);
					}
					if (map.contains(i*10 + y)){
						map.remove(i*10 + y);
					}
				}

				//Eliminate downleft diagon
				int xDownLeft = (x+y < 7) ? x+y : 7;
				int yDownLeft = 0;
				while (xDownLeft >= 0 || yDownLeft <= 7){
					if (map.contains(xDownLeft*10 + yDownLeft)){
						map.remove(xDownLeft*10 + yDownLeft);
					}
					xDownLeft--;
					yDownLeft++;
				}

				//Eliminate downright diagon
				if (x > y){
					int xDownRight = x - y;
					int yDownRight = 0;
					while (xDownRight < 8){
						if (map.contains(xDownRight*10 + yDownRight)){
							map.remove(xDownRight*10 + yDownRight);
						}
						xDownRight++;
						yDownRight++;
					}
				} else if (x < y){
					int xDownRight = 0;
					int yDownRight = y - x;
					while (xDownRight < 8){
						if (map.contains(xDownRight*10 + yDownRight)){
							map.remove(xDownRight*10 + yDownRight);
						}
						xDownRight++;
						yDownRight++;
					}
				} else {
					if (map.contains(x*10 + y)){
						int xDownRight = 0;
						int yDownRight = 0;
						while (xDownRight < 8){
							if (map.contains(xDownRight*10 + yDownRight)){
								map.remove(xDownRight*10 + yDownRight);
							}
							xDownRight++;
							yDownRight++;
						}
					}
				}

				//Add queen pos to array
				queensPos.add(queen);
				if (map.isEmpty() && queensPos.size() == 8){
					allQueensPos.add(queensPos);
				}

				//Investigate next queen's position
				for (int pos=0; pos<8; pos++){
					if (pos != x){
						HashSet<Integer> mapClone = new HashSet<Integer>(map);
						availSpace((x+1)*10 + pos, mapClone, queensPos, allQueensPos);
					}
				}
			}
		} else {
			allQueensPos.add(queensPos);
		}
	}

	public static ArrayList<ArrayList<Integer>> numberOfArrangement(){
		ArrayList<ArrayList<Integer>> allQueensPos = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> map = new HashSet<Integer>();
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				map.add(i*10 + j);
			}
		}

		for (int pos=0; pos < 8; pos++){
			HashSet<Integer> mapClone = new HashSet<Integer>(map);
			ArrayList<Integer> queensPos = new ArrayList<Integer>();
			availSpace(pos, mapClone, queensPos, allQueensPos);
		}

		return allQueensPos;
	}
*/