
public class Edge {

	private Vertice start;
	private Vertice end;
	private int length;
	
	public Edge(Vertice start, Vertice end, int length){
		this.start = start;
		this.end = end;
		this.length = length;
	}
	public Edge(){
		
	}

	public Vertice getStart() {
		return start;
	}

	public void setStart(Vertice start) {
		this.start = start;
	}

	public Vertice getEnd() {
		return end;
	}

	public void setEnd(Vertice end) {
		this.end = end;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
}
