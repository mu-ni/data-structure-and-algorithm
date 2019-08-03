package datastruc.graph;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Init an empty adjacency matrix");
		Graph graph = new Graph(6);
		graph.displayAdjMat();
		
		System.out.println("Insert some vertexes");
		String charArray = "ABCDEF";
		for(char c : charArray.toCharArray()){
			graph.addVertex(c);
		}
		graph.addEdge(0, 1);//A->B
		graph.addEdge(1, 2);//B->C
		graph.addEdge(0, 3);//A->D
		graph.addEdge(3, 4);//D->E
		graph.addEdge(1, 5);//B->F
		graph.displayAdjMat();
		
		System.out.println("Deep First Search Visit: ");
		graph.dfs();
		
		System.out.println("Breadth First Search Visit: ");
		graph.bfs();
		
		System.out.println("Test Minimum Spanning Tree with a star graph");
		Graph graph1 = new Graph(5);
		String starArray = "ABCDE";
		for(char c : starArray.toCharArray()){
			graph1.addVertex(c);
		}
		graph1.addEdge(0, 1);//A->B
		graph1.addEdge(0, 2);//A->C
		graph1.addEdge(0, 3);//A->D
		graph1.addEdge(0, 4);//A->E
		graph1.addEdge(1, 2);//B->C
		graph1.addEdge(1, 3);//B->D
		graph1.addEdge(1, 4);//B->E
		graph1.addEdge(2, 3);//C->D
		graph1.addEdge(2, 4);//C->E
		graph1.addEdge(3, 4);//D->E
		graph1.displayAdjMat();
		System.out.println("Minimum Spanning Tree: ");
		graph1.mst(0);
	}

}
