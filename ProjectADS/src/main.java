import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Graph g = readFile(); //Creating graph from file data
	//	g.print2();
		g.shortestPath(g.getVertices().get(0), g.getVertices().get(1));
		g.print2();
		//g.print();

		
		


	}

	//Reading the file and stores the information
	public static Graph readFile() throws FileNotFoundException{
		File inputFile = new File("inputFile.txt"); //The file
		Scanner inFile = new Scanner(inputFile);

		//First line (The grapgh type)
		String graphType = inFile.nextLine();
		System.out.println(graphType);

		//Reading Nodes and Edges
		LinkedList<Vertice> vertices = new LinkedList<Vertice>();
		LinkedList<Edge> edges = new LinkedList<Edge>();

		Boolean gettingEdges = false;
		int idCounter = 0;
		while(inFile.hasNextLine()){

			String str = inFile.nextLine();

			if (gettingEdges == false && !str.equals("")){
				Vertice temp = new Vertice(str,idCounter);
				vertices.add(temp);
				idCounter++;
			}
			else if (gettingEdges == true && !str.equals("")){
				String[] ary = str.split(" ");
				Vertice tempStartV = new Vertice(ary[0]);
				Vertice tempEndV = new Vertice(ary[1]);
				int endId = 0;
				for(int i = 0; i<vertices.size(); i++) {
					if(tempEndV.getName().equals(vertices.get(i).getName()))
						   endId = i;
				}
				Edge tempEdge = new Edge(tempStartV, tempEndV, Integer.parseInt(ary[2]), endId);
				edges.add(tempEdge);
			}
			else if (str.equals("")){
				gettingEdges = true;
			}

		}
		inFile.close();

		//Printing in order to test the file reading
		System.out.println("\nVertices: ");
		for (int i=0; i<vertices.size(); i++){
			System.out.println(vertices.get(i).getName()+" ");
		}
		System.out.println("\nEdges: ");
		for (int i=0; i<edges.size(); i++){
			System.out.println(edges.get(i).getStart().getName()+" "+edges.get(i).getEnd().getName()+" "+edges.get(i).getLength());
		}
		
		//Returning new graph
		return new Graph(graphType, vertices, edges);
	}
}
