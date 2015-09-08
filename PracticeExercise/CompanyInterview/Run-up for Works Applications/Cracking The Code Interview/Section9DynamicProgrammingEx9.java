import java.util.*;

public class Section9DynamicProgrammingEx9 {
	final static int SIZE = 4;
	public static void returnQueenPos(int[] queenPos, int currentRow, ArrayList<int[]> maps) {
		if (currentRow == SIZE){
			maps.add(queenPos);
			return;
		}
		//There is no column 0 --> avoid later situation with position where column = 0
		for (int column=1; column<=SIZE; column++){
			if (isValid(currentRow, column, queenPos)){
				int[] newArr = (int[])queenPos.clone(); 
				newArr[currentRow] = column;
				returnQueenPos(newArr, currentRow+1, maps);
			}
		}
	}

	public static ArrayList<int[]> returnQueenPos(){
		ArrayList<int[]> maps = new ArrayList<int[]>();
		returnQueenPos(new int[SIZE], 0, maps);
		return maps;
	}

	public static boolean isValid(int row, int column, int[] queenPos){
		//queenPos is empty
		if (queenPos[0] == 0) return true;
		
		//We should only consider i that is smaller that row
		for (int i=0; i<row; i++){
			//Check vertically and horizontally
			if (column == queenPos[i]){
				return false;
			}

			//Check diagonally, 
			if (Math.abs(column - queenPos[i]) == (row - i)){
				return false;
			}
		}

		return true;
	}

	public static void printArrayList(ArrayList<int[]> arrs){
		for (int[] arr: arrs){
			System.out.print("{");
			for (int i=0; i<arr.length; i++){
				int temp = i + 1;
				System.out.print(" (" + temp + ", " + arr[i] + ") ");
			}
			System.out.print("}\n");
		}
	}

	public static void main(String[] args){
		printArrayList(returnQueenPos());
	}
}