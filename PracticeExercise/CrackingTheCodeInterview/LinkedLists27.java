import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LinkedLists27 {
	public static boolean isPalindrome(LinkedListNode head){
		//if linked list only have 1 element
		if (head.getNext() == null){
			return true;
		}

		int count = 0;
		boolean reachPalindromePoint = false;
		boolean singlePalindromePoint = false;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		LinkedListNode pointer = head;

		while (pointer!=null){
			//if palindrome point was not reached or passed
			// 1. node data didn't exist in table as key
			// 2. reachPalindromePoint is false;
			if (!table.containsKey(pointer.getData()) && !reachPalindromePoint){
				table.put(pointer.getData(), count);
				stack.push(pointer.getData());
				pointer = pointer.getNext();
			} else {
				// check if this is first match
				if (count == 0){
					//if it has 1 palindrome points
					if (stack.peek() != pointer.getData()){
						stack.pop();
					}
					reachPalindromePoint = true;
				}
				if (!stack.isEmpty()){
					if (pointer.getData() == stack.pop()) {
						pointer = pointer.getNext();
						count++;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		//if the palindrome point exist -> true, not -> false
		return reachPalindromePoint;
	}

	public static void main(String[] args){
		// case need to test
		// 1. 1->3->5->3->1
		// 2. 1->3->5->3->1->2
		// 3. 1->3->5->5->3->1
		// 4. 1->3->5->3->4->6
		// 5. 1->3->5->3->2->1
		// 6. 1->2->3->4->5
		// 7. 1
		// 8. 1->2->1

		Scanner scan = new Scanner(System.in);
		Pattern delimiter = Pattern.compile("\\s");
		scan.useDelimiter(delimiter);
		SinglyLinkedListNode head = new SinglyLinkedListNode(scan.nextInt());
		SinglyLinkedListNode pointer = head;
		while(scan.hasNextInt()){
			pointer.appendToTail(scan.nextInt());
			pointer = pointer.getNext();
		}
		scan.close();

		System.out.println("Is palindrome: " + isPalindrome(head));
	}
}