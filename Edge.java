// @author Moeto Sonoda
public class Edge {
	
	
    int vertex;
    int adjVertex;	
    double weight;	

    protected Edge(int vertex, int adjVertex, double weight) {
      //Set all the values properly.
      this.vertex = vertex;
      this.adjVertex = adjVertex;
      this.weight = weight;
    }
  }