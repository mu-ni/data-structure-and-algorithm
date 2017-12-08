package datastructure.graph;

public class TestTopoGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Init topo graph");
		TopoGraph graph = new TopoGraph(8);
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addVertex('G');
		graph.addVertex('H');
		
		graph.addEdge(0, 3);//AD
		graph.addEdge(0, 4);//AE
		graph.addEdge(1, 4);//BE
		graph.addEdge(2, 5);//CF
		graph.addEdge(3, 6);//DG
		graph.addEdge(4, 6);//EG
		graph.addEdge(5, 7);//FH
		graph.addEdge(6, 7);//GH
		
		graph.displayAdjMat();
		
		System.out.println("Topo parse: ");
		graph.topo();		
	}

}
