import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// @author Moeto Sonoda

public class Digraph {
	
	int numOfVertices;
	int numOfEdges;
	boolean file;
	Map<Integer, ArrayList<Edge>> adjList;

	public Digraph(String filename) throws NumberFormatException, IOException{
		if(filename == null)
		{
			file = false;
			return;
		}
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		numOfVertices = Integer.valueOf(br.readLine());
		numOfEdges = Integer.valueOf(br.readLine());
		
		adjList = new HashMap<Integer, ArrayList<Edge>>();
		String curLine = br.readLine();
		
		while(curLine != null)
		{
			Scanner scanner = new Scanner(curLine);
			int vertex = scanner.nextInt();
			int adjVertex = scanner.nextInt();
			double weight = scanner.nextDouble(); 
			
			ArrayList<Edge> list = adjList.get(vertex);
			if(list == null)
			{
				list = new ArrayList<Edge>();
			}
			
			Edge edge = new Edge(vertex, adjVertex, weight);
			list.add(edge);
			adjList.put(vertex, list);
			
			scanner.close();
			curLine = br.readLine();
		}
		br.close();
		file = true;
	}
  }