/**
Describle an algorithm to find 1 millions smallest number in 1 billion numbers, assume that computer memory can hold all 1 billion number.
- Divided 1 billion numbers into 1000 segments of 1 million.
- Find smallest value of each segment; space complexity o(1);
- Sorted them in an array arr[]; space complexity O(n) n - size of segment; time O(1 bil * log(n))
- Find all number within ranges of arr[i] and arr[i+1] and increase i from 0 to 1000 until there are enough 1 million numbers. 

The reason to divide into 1000 segments is to ensure arr[i] and arr[i+1] won't have more than 1 million element in between them

Time complexity 1 bil * 1000

Textbook answer:

Solution 1: Sorting
We can sort the elements in ascending order and then take the first million numbers
from that.The time complexity is 0(n log(n)).

Solution 2: Min Heap
We can use a min heap to solve this problem. We first create a max heap (largest element
at the top) for the first million numbers.
Then, we traverse through the list. On each element, we insert it into the list and delete
the largest element.
At the end of the traversal, we will have a heap containing the smallest one million
numbers. This algorithm is 0(n log(m)), where m is the number of values we are
looking for.

Approach 3: Selection Rank Algorithm (if you can modify the original array)
Selection Rank is a well-known algorithm in computer science to find the ith smallest (or largest) element in an array in linear time.

If the elements are unique, you can find the ith smallest element in expected 0(n) time.The basic algorithm operates like this:

1. Pick a random element in the array and use it as a "pivot." Partition elements around
the pivot, keeping track of the number of elements on the left side of the partition.
2. If there are exactly i elements on the left, then you just return the biggest element
on the left.
3. If the left side is bigger than i, repeat the algorithm on just the left part of the array.
4. If the left side is smaller than i, repeat the algorithm on the right, but look for the
element with rank i - lef tSize.

The code below implements this algorithm.

public int partition(int[] array, int left, int right, int pivot) {
	while (true) {
		while (left <= right && array[left] <= pivot) {
		left++;
	}

	while (left <= right && array[right] > pivot) {
		right--;
	}

	if (left > right) {
		return left - 1;
	}
	swap(array, left, right);
}

public int rank(int[] array, int left, int right, int rank) {
	int pivot = array[randomInt!nRange(left, right)];

	/* Partition and return end of left partition */
	int leftEnd = partition(array, left, right, pivot);
	
	int leftSize = leftEnd - left + 1;
	if (leftSize == rank + 1) {
		return max(array, left, leftEnd);
	} else if (rank < leftSize) {
		return rank(array, left, leftEnd, rank);
	} else {
		return rank(array, leftEnd + 1, right, rank - leftSize);
	}
}

Once you have found the ith smallest element, you can run through the array to find all
values less than or equal to this element.
If the elements are not unique (which they are unlikely to be), we can tweak this algorithm slightly to accomodate this change. However, we no longer have as tight of a
guarantee on the runtime.
There is an algorithm that can guarantee that we can find the ith smallest element in
linear time, regardless of the uniqueness of the elements. However, the complexity of
this algorithm is far beyond the scope of this interview. If you are interested though, you
can look up the algorithm in CLRS'Introduction to Algorithms textbook.
*/

public class AdditionalReviewProblemsHard186 {
	public int partition(int[] array, int left, int right, int pivot) {
		while (true) {
			while (left <= right && array[left] <= pivot) {
				left++;
			}

			while (left <= right && array[right] > pivot) {
				right--;
			}

			if (left > right) {
				return left - 1;
			}
			swap(array, left, right);
		}
	}

	public int rank(int[] array, int left, int right, int rank) {
		int pivot = array[randomIntInRange(left, right)];

		/* Partition and return end of left partition */
		int leftEnd = partition(array, left, right, pivot);
		
		int leftSize = leftEnd - left + 1;
		if (leftSize == rank + 1) {
			return max(array, left, leftEnd);
		} else if (rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else {
			return rank(array, leftEnd + 1, right, rank - leftSize);
		}
	}
	
}