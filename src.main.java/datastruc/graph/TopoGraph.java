package datastruc.graph;


public class TopoGraph {
	private final int MAX_VERTS;
	private Vertex vertexList[];
	private int adjMat[][];//adjacency matrix
	private int nVerts;
	private char sortedArray[];
	
	public TopoGraph(int n){
		this.MAX_VERTS = n;
		this.vertexList = new Vertex[MAX_VERTS];
		this.adjMat = new int[MAX_VERTS][MAX_VERTS];
		this.nVerts = 0;
		for(int i=0; i<MAX_VERTS; i++){
			for(int j=0; j<MAX_VERTS; j++){
				this.adjMat[i][j] = 0;
			}
		}	
		this.sortedArray = new char[MAX_VERTS];
	}
	
	public void addVertex(char lab){
		vertexList[nVerts] = new Vertex(lab);
		nVerts ++;
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
	}
	
	public void topo(){
		int orig_nVerts = nVerts;
		while(nVerts > 0){
			int currentVertex = noSuccessors();
			if(currentVertex == -1){
				System.out.println("Error: Graph has cysles");
				return;
			}
			sortedArray[nVerts-1] = vertexList[currentVertex].label;
			deleteVertex(currentVertex);
		}
		
		System.out.println("Topologically sorted order: ");
		for(int i=0; i<orig_nVerts; i++){
			System.out.print(sortedArray[i]);
		}
		System.out.println();
	}
	
	public int noSuccessors(){//find a vertex doesn't have any next vertex
		boolean isEdge;
		for(int row=0; row<nVerts; row++){
			isEdge = false;
			for(int col=0; col<nVerts; col++){
				if(adjMat[row][col] > 0){
					isEdge = true;
					break;
				}
			}
			if(!isEdge){
				return row;
			}
		}
		return -1;
	}
	
	public void deleteVertex(int delVert){
		if(delVert != nVerts-1){
			for(int j=delVert; j<nVerts-1; j++){
				vertexList[j] = vertexList[j+1];
			}
			
			for(int row=delVert; row<nVerts-1; row++){
				moveRowUp(row, nVerts);
			}
			
			for(int col=delVert; col<nVerts-1; col++){
				moveColLeft(col, nVerts);
			}
		}
		nVerts --;
	}
	
	private void moveRowUp(int row, int length){
		for(int col=0; col<length; col++){
			adjMat[row][col] = adjMat[row+1][col];
		}
	}
	
	private void moveColLeft(int col, int length){
		for(int row=0; row<length; row++){
			adjMat[row][col] = adjMat[row][col+1];
		}
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
