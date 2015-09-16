import java.util.*;

public class Section9DynamicProgrammingEx9 {
	public static boolean checkValid(int[] allPos, int row, int col){
		for (int i=0; i<row; i++){
			if (allPos[i] == col){
				return false;
			}
			if (Math.abs(allPos[i] - col) == row - i){
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<int[]> getAllValidPos(int n){
		int[] allPos = new int[n];
		ArrayList<int[]> allPosiblePos = new ArrayList<int[]>();
		for (int i=0; i<n; i++){
			allPos[0] = i;
			getAllValidPos(allPos, 1, allPosiblePos);
		}
		return allPosiblePos;
	}
	
	public static void getAllValidPos(int[] allPos, int row, ArrayList<int[]> allPosiblePos){
		if (row == allPos.length){
			int[] temp = (int[])allPos.clone();
			allPosiblePos.add(temp);
			return;
		}
		for (int i=0; i<allPos.length; i++){
			if (checkValid(allPos, row, i)){
				allPos[row] = i;
				getAllValidPos(allPos, row+1, allPosiblePos);
			}
		}
	}
	
	public static void main(String[] args){
		ArrayList<int[]> result = getAllValidPos(5);
		for (int[] pos: result){
			for (int i=0; i<pos.length; i++){
				System.out.print(pos[i] + " ");
			}
			System.out.println();
		}
	}
}