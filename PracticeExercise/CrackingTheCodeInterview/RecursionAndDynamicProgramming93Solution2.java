public class RecursionAndDynamicProgramming93Solution2{
	//Assume that array is ascending. Using binary search for this.
	public static int findMagicIndex(int[] input, int start, int end){
		int mid = (end + start)/2;
		if (start > end){
			return -1;
		}

		if (input[mid] == mid){
			return mid;
		} else if (input[start] == start){
			return start;
		} else if (input[end] == end){
			return end;
		} else {
			if (input[mid] > mid){
				//search if there is similar value to mid on the right
				int rightMid = mid;
				while(input[mid] == input[rightMid]){
					if (rightMid == input[rightMid]){
						return rightMid;
					}
					rightMid++;
				}
				System.out.println("start: " + start + " end: " + mid);
				return findMagicIndex(input, start+1, mid-1);
			} else {
				//search if there is similar value to mid on the left
				int leftMid = mid;
				while (input[mid] == input[leftMid]){
					if (leftMid == input[leftMid]){
						return leftMid;
					}
					leftMid--;
				}
				System.out.println("start: " + mid + " end: " + end);
				return findMagicIndex(input, mid+1, end-1);
			}
		}
	}

	public static void main(String[] args){
		int[] input = new int[]{-10, -5, 2, 2, 2, 3, 4, 8, 9, 12, 13};

		System.out.println(findMagicIndex(input, 0, input.length-1));
	}
}