import java.util.LinkedList;

public class Vertice {
	
	private static final int INFINITY = Integer.MAX_VALUE;

	private String name;
	private Boolean visited;
	private int distance;
	private LinkedList<Vertice> adjacents;
	private LinkedList<Integer> lengthToAdjacents;
	private Vertice minPrevious;
	private int nodeId;
	
	public Vertice(String name,int nodeId){
		this.name = name;
		this.visited = false;
		this.distance = INFINITY;
		this.adjacents = new LinkedList<Vertice>();
		this.lengthToAdjacents = new LinkedList<Integer>();
		this.minPrevious = null;
		this.nodeId = nodeId;
		
	}
	public Vertice(String name){
		this.name = name;
		this.visited = false;
		this.distance = INFINITY;
		this.adjacents = new LinkedList<Vertice>();
		this.lengthToAdjacents = new LinkedList<Integer>();
		this.minPrevious = null;
		
	}
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public LinkedList<Integer> getLengthToAdjacents() {
		return lengthToAdjacents;
	}
	public void setLengthToAdjacents(LinkedList<Integer> lengthToAdjacents) {
		this.lengthToAdjacents = lengthToAdjacents;
	}
	public Vertice() {
		
	}

	public Vertice getMinPrevious() {
		return minPrevious;
	}

	public void setMinPrevious(Vertice minPrevious) {
		this.minPrevious = minPrevious;
	}

	public void setAdjacents(LinkedList<Vertice> adjacents) {
		this.adjacents = adjacents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LinkedList<Vertice> getAdjacents() {
		return adjacents;
	}

	public void addAdjacent(Vertice adjacent) {
		
		adjacents.add(adjacent);
		
	}
	public void addAdjacentLength(int length) {
		this.lengthToAdjacents.add(length);
	}
	
	public void printAdjacents() {
		
		for(int i = 0; i<adjacents.size(); i++) {
			System.out.println(adjacents.get(i).getName());
		}
		
	}	
	
}
