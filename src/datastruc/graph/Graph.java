package datastruc.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private final int MAX_VERTS;
	private Vertex vertexList[];
	private int adjMat[][];//adjacency matrix
	private int nVerts;
	private Stack<Integer> stack = new Stack<>();
	private Queue<Integer> queue = new LinkedList<>();
	
	public Graph(int n){
		this.MAX_VERTS = n;
		this.vertexList = new Vertex[MAX_VERTS];
		this.adjMat = new int[MAX_VERTS][MAX_VERTS];
		this.nVerts = 0;
		for(int i=0; i<MAX_VERTS; i++){
			for(int j=0; j<MAX_VERTS; j++){
				this.adjMat[i][j] = 0;
			}
		}	
	}
	
	public void addVertex(char label){
		vertexList[nVerts] = new Vertex(label);
		nVerts++;
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public int getAdjUnvisitedVertex(int v){
		for(int i=0; i<nVerts; i++){
			if(adjMat[v][i]==1 && vertexList[i].wasVisited == false){
				return i;//return the first such vertex
			}
		}
		return -1;//no such vertex
	}
	
	public void dfs(){//deep first search//stack
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()){
			int v = getAdjUnvisitedVertex(stack.peek());
			if(v == -1){
				stack.pop();
			}else{
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
		}
		
		for(int i=0; i<nVerts; i++){
			vertexList[i].wasVisited = false;
		}
		System.out.println();
	}
	
	public void bfs(){//breadth first search
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.add(0);//peek//remove
		int v2;
		
		while(!queue.isEmpty()){
			int v1 = queue.remove();
			while(getAdjUnvisitedVertex(v1) != -1){
				v2 = getAdjUnvisitedVertex(v1);
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				queue.add(v2);
			}
		}
		
		for(int i=0; i<nVerts; i++){
			vertexList[i].wasVisited = false;
		}
		System.out.println();
	}
	
	public void mst(int start){//minimum spanning tree
		vertexList[start].wasVisited = true;
		stack.push(start);
		
		while(!stack.isEmpty()){
			int currentVertex = stack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1){
				stack.pop();
			}else{
				vertexList[v].wasVisited = true;
				stack.push(v);

				displayVertex(currentVertex);
				displayVertex(v);
				System.out.print(" ");
			}
		}
		
		for(int i=0; i<nVerts; i++){
			vertexList[i].wasVisited = false;
		}
		System.out.println();
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void displayAdjMat(){
		for(int i=0; i<MAX_VERTS; i++){
			System.out.print("[");
			for(int j=0; j<MAX_VERTS; j++){
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println("]");
		}	
	}
	
}
