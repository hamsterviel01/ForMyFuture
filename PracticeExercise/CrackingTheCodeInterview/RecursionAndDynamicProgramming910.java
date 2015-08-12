import java.util.*;

public class RecursionAndDynamicProgramming910 {
	public static void buildStack(int[] w, int[] h, int[] d, int index, _<Integer> maxHeight, int currentHeight){
		int temp = currentHeight;
		for (int i=0; i<w.length; i++){
			if (isSmaller(w, h, d, i, index)){
				currentHeight++;
				System.out.println("currentHeight: " + currentHeight + " index: " + index + " i: " + i);
				if (currentHeight > maxHeight){
					maxHeight = currentHeight;
					System.out.println("maxHeight: " + maxHeight);
				}
				buildStack(w, h, d, i, maxHeight, currentHeight);
			}
			currentHeight = temp;
		}
	}

	public static boolean isSmaller(int[] w, int[] h, int[] d, int index1, int index2){
		return w[index1] < w[index2] && h[index1] < h[index2] && d[index1] < d[index2];
	}

	public static int buildStack(int[] w, int[] h, int[] d){
		_<Integer> maxHeight = new _<Integer>(0);
		for (int i=0; i<w.length; i++){
			buildStack(w, h, d, i, maxHeight, 0);		
		}

		return maxHeight;
	}

	public static void main(String[] args){
		int[] w = new int[]{1, 2, 3, 4};
		int[] h = new int[]{1, 2, 3, 4};
		int[] d = new int[]{1, 2, 3, 4};
		System.out.println("Max height of stack: " + buildStack(w, h, d));
	}
}