import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Graph g = readFile(); //Creating graph from file data
		g.shortestPath(g.getVertices().get(1), g.getVertices().get(3)); //Entering id of the nodes in list vertices

	}

	//Reading the file and stores the information
	public static Graph readFile() throws FileNotFoundException{
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes1.txt"); //Nodes1.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes2.txt"); //Nodes2.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes3.txt"); //Nodes3.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes4.txt"); //Nodes4.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes5.txt"); //Nodes5.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes6.txt"); //Nodes6.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes7.txt"); //Nodes7.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes8.txt"); //Nodes8.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes9.txt"); //Nodes9.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes10.txt"); //Nodes10.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes11.txt"); //Nodes11.txt (ska funka)
		//File inputFile = new File("/Users/felixdrangel/Desktop/Testfiler/Tester implementationsval 1/Nodes12.txt"); //Nodes12.txt (ska funka)
		File inputFile = new File("C:\\Users\\anton\\Desktop\\apples.txt");
		Scanner inFile = new Scanner(inputFile);

		//First line (The graph type)
		String graphType = inFile.nextLine();

		//Reading Nodes and Edges
		LinkedList<Vertice> vertices = new LinkedList<Vertice>();
		LinkedList<Edge> edges = new LinkedList<Edge>();
		Boolean gettingEdges = false;
		int idCounter = 0;
		while(inFile.hasNextLine()){
			String str = inFile.nextLine();
			//vertices
			if (gettingEdges == false && !str.equals("")){
				Vertice temp = new Vertice(str,idCounter);
				vertices.add(temp);
				idCounter++;
			}
			//Edges
			else if (gettingEdges == true && !str.equals("")){
				String[] ary = str.split("\t"); //Splitting by "tab"
				Vertice tempStartV = new Vertice(ary[0]);
				Vertice tempEndV = new Vertice(ary[1]);
				int endId = 0;
				for(int i = 0; i<vertices.size(); i++) {
					if(tempEndV.getName().equals(vertices.get(i).getName()))
						endId = i;
				}
				Edge tempEdge = new Edge(tempStartV, tempEndV, Integer.parseInt(ary[2]), endId);
				edges.add(tempEdge);

				//if undirected (vi kan skriva ihop detta med loopen ovan)
				if (graphType.equals("UNDIRECTED")){
					Vertice tempStartV2 = new Vertice(ary[1]);
					Vertice tempEndV2 = new Vertice(ary[0]);
					int endId2 = 0;
					for(int i = 0; i<vertices.size(); i++) {
						if(tempEndV2.getName().equals(vertices.get(i).getName()))
							endId2 = i;
					}
					Edge tempEdge2 = new Edge(tempStartV2, tempEndV2, Integer.parseInt(ary[2]), endId2);
					edges.add(tempEdge2); 
				}
			}
			//Nothing
			else if (str.equals("")){
				gettingEdges = true;
			}

		}
		inFile.close();

		//Printing in order to test the file reading
		System.out.println(graphType);
		for (int i=0; i<vertices.size(); i++){
			System.out.println(vertices.get(i).getName()+" ");
		}
		for (int i=0; i<edges.size(); i++){
			System.out.println(edges.get(i).getStart().getName()+" "+edges.get(i).getEnd().getName()+" "+edges.get(i).getLength());
		}

		//Returning new graph
		return new Graph(graphType, vertices, edges);
	}
}
