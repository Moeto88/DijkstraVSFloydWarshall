import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 * 
 * @ author: Moeto Sonoda
 */

public class CompetitionDijkstra{
	
	  Digraph graph;
	  int sA;
	  int sB;
	  int sC;
	  double negInfinity = Double.NEGATIVE_INFINITY;
	  double posInfinity = Double.POSITIVE_INFINITY;
	  Map<Integer, ArrayList<Route>> routeList;
	  ArrayList<Integer> finalRouteList;
	  
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     * @throws NumberFormatException 
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC) throws NumberFormatException{

    	//Set the integers representing the average walking speed of each of the contestants.
    	this.sA = sA;
    	this.sB = sB;
    	this.sC = sC;
    	try {
			this.graph = new Digraph(filename);
		} catch (NumberFormatException e) {
			this.graph = null;
		} catch (IOException e) {
			this.graph = null;
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
         double maxDistanceInKilometers = findMaxDist();
         
         finalRouteList = new ArrayList<Integer>();
         int curStop = 6;
         finalRouteList.add(curStop);
         int finalStop = 0;
         while(curStop != finalStop)
         {
        	 curStop = getRoutes(curStop);
         }
         
         for(int i = finalRouteList.size() - 1; i >= 0; i--)
         {
        	 System.out.println("Route: " + finalRouteList.get(i));
         }
          
         
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
     
     

     int getRoutes(int curStop) {
		Map<Integer, ArrayList<Route>> routeList = getRouteList();
        for(int key: routeList.keySet())
        {
       	 
       	 ArrayList<Route> a = routeList.get(key);
       	 for(Route r: a)
       	 {
       		 
       		if(curStop == r.connectingVertex)
       		{
       			curStop = r.vertex;
       			System.out.println(curStop);
       			finalRouteList.add(curStop);
       		}
       	 }
       	 
        }
        
        return curStop;
	}

	private Map<Integer, ArrayList<Route>> getRouteList() {
		return routeList;
	}

	private double findMaxDist() {
		double maxDist = negInfinity;
		int numOfVertices = graph.numOfVertices;
		/*
		for(int vertex1 = 0; vertex1 < numOfVertices; vertex1++)
		{
		*/
			double shortestPath[] = Dijkstra(0);
			/*
			for(int vertex2 = 0; vertex2 < numOfVertices; vertex2++)
			{
				if(vertex1 == vertex2)
				{
					continue;
				}
				else
				{
				*/
					double distFromVertex1ToVertex2 = shortestPath[6];
					
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
					/*
				}
	
			}
		}
		
		*/
		
		return maxDist;
	}

	private double[] Dijkstra(int start) {
		Map<Integer, ArrayList<Edge>> adjList = graph.adjList;
		double distTo[] = new double[graph.numOfVertices];
		Queue<Integer> pq = new PriorityQueue<>(Comparator.comparing(integer -> distTo[integer]));
		routeList = new HashMap<Integer, ArrayList<Route>>();
		
		for(int i = 0; i < graph.numOfVertices; i++)
		{
			if(i == start)
			{
				distTo[i] = 0;
			}
			else
			{
				distTo[i] = posInfinity;
			}
		}
		
		pq.add(start);
		
		boolean completedVertex[] = new boolean[graph.numOfVertices];
		
		while(pq.isEmpty() != true)
		{
			int vertex = pq.remove();
			ArrayList<Edge> keyList = adjList.get(vertex);
			if(keyList == null)
			{
				keyList = new ArrayList<Edge>();
			}
			
			for(Edge edge: keyList)
			{
				int connectingVertex = edge.adjVertex;
				
				if(completedVertex[connectingVertex] == false)
				{
					double updatedWeight = distTo[vertex] + edge.weight;

					if(updatedWeight < distTo[connectingVertex])
					{
						distTo[connectingVertex] = updatedWeight;
						System.out.println("Vertex: "+vertex);
						System.out.println("connectingVertex: "+connectingVertex);
						
						ArrayList<Route> tmpList = routeList.get(vertex);
						if(tmpList == null)
						{
							tmpList = new ArrayList<Route>();
						}
						
						Route route = new Route(vertex, connectingVertex);
						tmpList.add(route);
						routeList.put(vertex, tmpList);
					}
				
					pq.remove(connectingVertex);
					pq.add(connectingVertex);
				}
			}
			
			completedVertex[vertex] = true;
		}
		
		return distTo;
	}
    
	
	
}