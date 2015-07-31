import java.util.*;

public class WorksApplication20150731Excercise7 {
	//Time complexity O(n!)
	public static void printAllSortedPermu(String str){
		TreeSet<String> list = populateAllPermu(str, str.length()-1);
		System.out.println(list);
	}

	public static TreeSet<String> populateAllPermu(String str, int end){
		if (end == 0){
			StringBuilder s = new StringBuilder();
			s.append(str.charAt(end));
			return new TreeSet<String>(Arrays.asList(s.toString()));
		}

		TreeSet<String> list = populateAllPermu(str, end-1);
		TreeSet<String> newList = new TreeSet<String>();
		for (String sb: list){
			for (int i=0; i<=sb.length(); i++){
				StringBuilder temp = new StringBuilder();
				temp.append(sb.substring(0, i) + str.charAt(end) + sb.substring(i));
				newList.add(temp.toString());
			}
		}

		return newList;
	}

	public static void main(String[] args){
		printAllSortedPermu("aaadef");
	}
}