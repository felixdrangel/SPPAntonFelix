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

	// BerÃ¤knar kortaste vÃ¤gen
	public void shortestPath(Vertice startVertice, Vertice endVertice) {
			System.out.println(
				"Calculating the shortest path between " + startVertice.getName() + " and " + endVertice.getName());
		startVertice.setDistance(0);
		

		LinkedList<Vertice> queue = new <Vertice>LinkedList();
		queue.add(startVertice);	
		while (!queue.isEmpty()){ //så länge det finns noder i kön
			
			queue = selectionSortOfVertice(queue); //sorterar kön baserat på distans
			
			if(queue.get(0).getVisited()==false) { //om noden inte redan är färdig
			for(int i = 0; i<queue.get(0).getAdjacents().size(); i++) {//gå igenom alla nodes grannar
	
				queue.add(vertices.get(queue.get(0).getAdjacents().get(i).getNodeId())); //lägger till nodens grannar till kön
			//	System.out.println("ok " + queue.get(0).getName() + " ska vara v1 nu: " + queue.get(1).getName());
				int newDistance = queue.get(0).getDistance() + queue.get(0).getLengthToAdjacents().get(i); //beräknar grannens potentiellt nya distans
				
				for(int j = 0; j<vertices.size(); j++) { //kollar vilken noden är i listan så den poteniellt kan uppdateras

					if(queue.get(0).getAdjacents().get(i).getNodeId() == vertices.get(j).getNodeId()) { //när noden har hittat sig själv
						System.out.println("ok1");
						if(newDistance < vertices.get(j).getDistance()) {//om nodens nya distans är mindre än dens gamla
							System.out.println("ok2");
						vertices.get(j).setDistance(newDistance); //uppdatera distans
						
						}
					}
				}
				//vertices.get(c).getAdjacents().get(i).setDistance(queue.get(0).getDistance() + queue.get(0).getLengthToAdjacents().get(i));
				//System.out.println("New distance for "+queue.get(0).getAdjacents().get(i).getName() + " is " +newDistance);
			
				
			}
			}
			queue.get(0).setVisited(true);
			queue.remove(0);
		}
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

	public void setAdjacents() {
			// metoden lägger till nodgrannar till varje nod som hittas igenom att loopa igenom kanterna 
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < edges.size(); j++) {
				if (edges.get(j).getStart().getName().equals(vertices.get(i).getName())) { 
					vertices.get(i).addAdjacent(vertices.get(edges.get(j).getEndId())); // lägger till gran-noden
					vertices.get(i).addAdjacentLength(edges.get(j).getLength());
				}
			}
		}

	}

	public void print() {
				
		for (int i = 0; i < vertices.size(); i++) {
			System.out.println("Vertices " + vertices.get(i).getName());
			for (int j = 0; j < vertices.get(i).getAdjacents().size(); j++) {
				System.out.println("\n granne " + vertices.get(i).getAdjacents().get(j).getName());
				System.out.println("Längd " + vertices.get(i).getLengthToAdjacents().get(j));

			}
			System.out.println("---------------------------");
		}

	}
	public void print2() {
		
		for (int i = 0; i < vertices.size(); i++) {
			System.out.println(vertices.get(i).getDistance());
	}
	}
}
