import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 * @ author: Moeto Sonoda
 */

public class CompetitionFloydWarshall {

	Digraph graph;
	int sA;
	int sB;
	int sC;
	double negInfinity = Double.NEGATIVE_INFINITY;
	double posInfinity = Double.POSITIVE_INFINITY;
	double matrix[][];
	int numOfVertices;


	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall (String filename, int sA, int sB, int sC){

		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		try {
			this.graph = new Digraph(filename);
			make2DArray(filename);
		} catch (NumberFormatException e) {
			this.graph = null;
		} catch (IOException e) {
			this.graph = null;
		}
	}


	private void make2DArray(String filename) throws NumberFormatException, IOException {
		if(filename == null)
		{
			graph.file = false;
			return;
		}


		numOfVertices = graph.numOfVertices;
		int numOfEdges = graph.numOfEdges;

		matrix = new double [numOfVertices][numOfVertices];

		for(int i = 0; i < matrix.length; i++)
		{
			for(int k = 0; k < matrix[i].length; k++)
			{
				matrix[i][k] = posInfinity;
			}
		}

		for(int key = 0; key < numOfVertices; key++)
		{
			ArrayList<Edge> list = graph.adjList.get(key);
			if(list != null)
			{
				for(Edge edge: list)
				{
					matrix[edge.vertex][edge.adjVertex] = edge.weight;
				}
				matrix[key][key] = 0;
			}
		}

	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){

		if(graph == null || graph.file == false) 
		{
			return -1;
		}
		
		SortSpeeds s = new SortSpeeds();
		int speeds[] = { sA, sB, sC };
		
		speeds = s.mergeSortIterative(speeds);
		
		if(speeds[0] < 50 || speeds[2] > 100)
		{
			return -1;
		}

		int minSpeedInMetersPerMinute = speeds[0];
		
		FloydWarshall(matrix);
		
		double maxDistanceInKilometers = findMaxDist(matrix);
		
		if(maxDistanceInKilometers <= 0)
        {
       	 return -1;
        }
        double maxDistanceInMeters = maxDistanceInKilometers * 1000;
        int tempTimeRequired = (int) (maxDistanceInMeters / minSpeedInMetersPerMinute);
        
        if(tempTimeRequired < (maxDistanceInMeters / minSpeedInMetersPerMinute))
        {
       	 tempTimeRequired++;
        }
        
        return tempTimeRequired;
	}


	private void FloydWarshall(double[][] matrix) {
		for(int a = 0; a < numOfVertices; a++)
		{
			for(int b = 0; b < numOfVertices; b++)
			{
				for(int c = 0; c < numOfVertices; c++)
				{
					if(matrix[b][a] + matrix[a][c] < matrix[b][c])
					{
						matrix[b][c] = matrix[b][a] + matrix[a][c];
					}
				}
			}
		}
	}

	private double findMaxDist(double[][] matrix) {
		double maxDist = negInfinity;
		
		for(int vertex1 = 0; vertex1 < numOfVertices; vertex1++)
		{
			for(int vertex2 = 0; vertex2 < numOfVertices; vertex2++)
			{
				if(vertex1 == vertex2)
				{
					continue;
				}
				else
				{
					double distFromVertex1ToVertex2 = matrix[vertex1][vertex2];
					
					if(distFromVertex1ToVertex2 == posInfinity)
					{
						return -1;
					}
					else
					{
						if(maxDist < distFromVertex1ToVertex2)
						{
							maxDist = distFromVertex1ToVertex2;
						}
					}
				}
			}
		}
		
		return maxDist;
	}

	
}