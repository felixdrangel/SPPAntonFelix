
public class Edge {

	private Vertice start;
	private Vertice end;
	private int length;
	private int endId;
	
	public Edge(Vertice start, Vertice end, int length,int endId){
		this.start = start;
		this.end = end;
		this.length = length;
		this.endId = endId;
	}
	public int getEndId() {
		return endId;
	}
	public void setEndId(int endId) {
		this.endId = endId;
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
