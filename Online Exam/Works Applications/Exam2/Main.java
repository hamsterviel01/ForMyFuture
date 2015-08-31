import java.util.*;
import java.io.*;

public class Main {
	//First, since graph has n vertices and n-1 edges and all cities connect to each other --> it is a connected and simple graph.
	public static int calculateShortestPath(int visitorCity, HashMap<Integer, ArrayList<Integer>> islandMap, boolean[] isFestive){
		boolean[] visited = new boolean[isFestive.length];
		City currentCity = new City(visitorCity, 0);
		LinkedList<City> waitList = new LinkedList<City>();

		while (!isFestive[currentCity.name]){
			//set visited to true;
			visited[currentCity.name] = true;
			for (int i: islandMap.get(currentCity.name)){
				//if city is not visited yet
				if (!visited[i]){
					waitList.add(new City(i, currentCity.distance + 1));
				}
			}
			currentCity = waitList.remove();
		}
		return currentCity.distance;
	}

	public static void main(String[] args) {
		// TODO: Implement your program 
		HashMap<Integer, ArrayList<Integer>> islandMap = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		try {		
			String line[] = rd.readLine().split(" ");
			int n = Integer.valueOf(line[0]);
			int m = Integer.valueOf(line[1]);
			boolean[] isFestive = new boolean[n+1];		
			int count = 1;

			//At first only city 1 is festive
			isFestive[1] = true;
			while (count <= n-1){
				String[] temp = rd.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				if (!islandMap.containsKey(a)){
					islandMap.put(a, new ArrayList<Integer>(Arrays.asList(b)));
				} else {
					islandMap.get(a).add(b);
				}
				
				if (!islandMap.containsKey(b)){
					islandMap.put(b, new ArrayList<Integer>(Arrays.asList(a)));
				} else {
					islandMap.get(b).add(a);
				}
				count++;
			}

			ArrayList<Query> query = new ArrayList<Query>();
			String inputLine;
			while (count <= n+m-1 && (inputLine = rd.readLine()) != null && inputLine.length() > 0){
				String[] temp = inputLine.split(" ");
				query.add(new Query(Integer.valueOf(temp[0]), Integer.valueOf(temp[1])));
				count++;
			}

			for (Query q: query){
				if (q.type == 1){
					isFestive[q.city] = true;
				} else if (q.type == 2) {
					int result = calculateShortestPath(q.city, islandMap, isFestive);
					output.add(result);
				}
			}

			//Print output
			for (int i: output){
				System.out.println(i);
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				rd.close();
			} catch (IOException e){
				e.printStackTrace();
			}	
		}
	}
}

class City {
	int name;
	int distance;
	City(int name, int distance){
		this.name = name;
		this.distance = distance;
	}
}

class Query {
	int type;
	int city;
	Query(int type, int city){
		this.type = type;
		this.city = city;
	}
}