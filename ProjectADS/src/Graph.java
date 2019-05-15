import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

	private String type;
	private LinkedList<Vertice> vertices;
	private LinkedList<Edge> edges;

	public Graph(String type, LinkedList<Vertice> vertices, LinkedList<Edge> edges){
		this.type = type;
		this.vertices = vertices;
		this.edges = edges;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LinkedList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(LinkedList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public LinkedList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}

	//Beräknar kortaste vägen
	public void shortestPath(Vertice startVertice, Vertice endVertice){
		System.out.println("Calculating the shortest path between "+startVertice.getName()+" and "+endVertice.getName());
		System.out.println("The distance of "+startVertice.getName()+" is "+startVertice.getDistance());
		startVertice.setDistance(0);
		startVertice.setVisited(true);

		LinkedList <Vertice> queue = new <Vertice>LinkedList();
		queue.add(startVertice);

		while (!queue.isEmpty()){
			int lowIndex = 0;
			LinkedList <Edge> edgesOfCurrentVertex = new LinkedList<Edge>();

			int c = 0; //edgesOfCurrentVertexCounter
			for (int i=0; i<edges.size(); i++){
				if (edges.get(i).getStart().getName().equals(queue.get(0).getName())){
					edgesOfCurrentVertex.add(edges.get(i));
					if(edgesOfCurrentVertex.get(c).getLength()<(edgesOfCurrentVertex.get(lowIndex).getLength()))
						lowIndex = i;
					queue.add(edgesOfCurrentVertex.get(c).getEnd());
					c++; //edgesOfCurrentVertexCounter
				}
			}
			
			
			
			queue.get(0).setVisited(true);
			System.out.println(queue.get(0).getName());
			queue.pop();

		}
	}
	//make quicksort instead
	private LinkedList<Edge> selectionSortOfEdge(LinkedList<Edge> list){

		Edge temp = new Edge();

				for(int i=0; i<list.size(); i++)  
				{  
					for(int j=i+1; j<list.size(); j++)  
					{  
						if(list.get(i).getLength() > list.get(j).getLength())  
						{  
							temp = list.get(i);		
							list.set(i, list.get(j));  
							list.set(j, temp); 
							
						}  
					}  
				}
				return list; 

	}



}
