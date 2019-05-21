import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Graph {

	private String type;
	private LinkedList<Vertice> vertices;
	private LinkedList<Edge> edges;

	public Graph(String type, LinkedList<Vertice> vertices, LinkedList<Edge> edges) {
		this.type = type;
		this.vertices = vertices;
		this.edges = edges;
		setAdjacents();
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

	// Beräknar kortaste vägen
	public void shortestPath(Vertice startVertice, Vertice endVertice) throws FileNotFoundException {
		startVertice.setDistance(0); //setting the distance of the start vertex to 0

		LinkedList<Vertice> queue = new LinkedList<Vertice>(); //Creating queue in order to visit vertices in correct order
		queue.add(startVertice); //Adding start vertex to queue

		while (!queue.isEmpty()){ //As long as there are vertices in the queue
			queue = selectionSortOfVertice(queue); //Sorting queue based on distance (smallest distance first)
			if(queue.get(0).getVisited()==false) { //If first element in queue is not visited
				for(int i = 0; i<queue.get(0).getAdjacents().size(); i++) {//For all the vertex neighbors
					queue.add(vertices.get(queue.get(0).getAdjacents().get(i).getNodeId())); //Adding neighbor to queue
					int newDistance = queue.get(0).getDistance() + queue.get(0).getLengthToAdjacents().get(i); //Calculating distance of neighbor

					for(int j = 0; j<vertices.size(); j++) { //Searching for itself in "vertices"
						if(queue.get(0).getAdjacents().get(i).getNodeId() == vertices.get(j).getNodeId()) { //Found itself
							if(newDistance < vertices.get(j).getDistance()) {//If its new distance is shorter than its current
								vertices.get(j).setDistance(newDistance); //Updating distance
								vertices.get(j).setMinPrevious(vertices.get(queue.get(0).getNodeId()));
							}
						}
					}
				}
			}
			queue.get(0).setVisited(true); //Setting the first vertex to visited (done)
			queue.remove(0); //Removing it from queue so next vertex will be treated
		}

		Vertice tempVertex = vertices.get(endVertice.getNodeId());
		System.out.println("\nShortest distance between "+vertices.get(startVertice.getNodeId()).getName()+" and "+
		vertices.get(endVertice.getNodeId()).getName()+" is "+vertices.get(endVertice.getNodeId()).getDistance());
		printPath(tempVertex); //kan tas bort sen
		printShortestPathInFile(tempVertex);
	}

	private void printPath(Vertice previous){
		if (previous.getMinPrevious().getName() != null){
			printPath(previous.getMinPrevious());
			System.out.print(" -> "+previous.getName());
		}
		else
			System.out.print(previous.getName());
	}

	private String getShortestPath(Vertice previous, String path){
		if (previous.getMinPrevious().getName() != null){
			path = path + getShortestPath(previous.getMinPrevious(), path);
			path = path + " -> "+ previous.getName();
		}
		else
			path = path + previous.getName();

		return path;
	}

	private void printShortestPathInFile(Vertice tempVertex) throws FileNotFoundException{
		PrintWriter out = new PrintWriter (new File("/Users/felixdrangel/Desktop/Answers.txt"));
		out.println(0);
		out.println(vertices.get(tempVertex.getNodeId()).getDistance());
		out.println(getShortestPath(tempVertex, ""));
		out.close();
	}

	// make quicksort instead
	private LinkedList<Vertice> selectionSortOfVertice(LinkedList<Vertice> list) {

		Vertice temp = new Vertice();

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getDistance() > list.get(j).getDistance()) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);

				}
			}
		}
		return list;
	}

	private void setAdjacents() {
		//Adding adjacents to all vertices 
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < edges.size(); j++) {
				if (edges.get(j).getStart().getName().equals(vertices.get(i).getName())) { 
					vertices.get(i).addAdjacent(vertices.get(edges.get(j).getEndId())); // l�gger till gran-noden
					vertices.get(i).addAdjacentLength(edges.get(j).getLength());
				}
			}
		}

	}

	
	
}
