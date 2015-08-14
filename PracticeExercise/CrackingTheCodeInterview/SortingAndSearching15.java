public class SortingAndSearching15 {
	//This algo don't accept "value" as empty string
	public static int findString(String[] strArray, String value, int start, int end){
		int mid = (start+end)/2;
		int beforeMid = mid ;
		int afterMid = mid ;

		if (strArray[mid] == value){
			return mid;
		}
		if (strArray[start] == value){
			return start;
		}
		if (strArray[end] == value){
			return end;
		}
		while (strArray[beforeMid] == ""){
			beforeMid--;
		}
		while (strArray[afterMid] == ""){
			afterMid++;
		}

		if (value.compareTo(strArray[beforeMid]) > 0){
			if (afterMid == end) return -1;
			return findString(strArray, value, afterMid, end-1);
		}
		if (start == beforeMid) return -1;
		return findString(strArray, value, start+1, beforeMid);
	}

	public static int findString(String[] strArray, String value){
		if (strArray.length == 0) return -1;
		int start = 0;
		int end = strArray.length-1;

		while (strArray[start] == "" && start < end){
			if (value == "") return start;
			start++;
		}
		if (start == end && value != "") return -1;
		while (strArray[end] == ""){
			if (value == "") return end;
			end--;
		}
		return findString(strArray, value, start, end);
	}

	public static void main(String[] args){
		String[] strArray = new String[]{"abd", "bbd", "c", ""};
	}
}