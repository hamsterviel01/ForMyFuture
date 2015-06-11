import java.util.*;

public class LinkedLists27 {
	public static boolean isPalindrome(LinkedListNode head){
		int count = 0;
		int pCount = 0;
		Hashtable table = new Hashtable();
		LinkedListNode pointer = head;

		while (pointer.getNext()!=null){
			//if palindrome point was reached or passed
			if (!table.contains(pointer.getData())){
				table.add(pointer.getData(), count);
				count++;
			} else {
				// first, the string after palindrome point cannot be longer than the string before it.
				if (pCount <= count){
					if (table.)
				} else {
					return false
				}
				pCount++;
			}
		}

		//if the palindrome point exist
		if (pCount != 0){
			return true;
		}
	}

	public static void main(String[] args){

		// case need to test
		// 1. 1->3->5->3->1
		// 2. 1->3->5->3->1->2
		// 3. 1->3->5->5->3->1
		// 4. 1->3->5->3->4->6

	}
}