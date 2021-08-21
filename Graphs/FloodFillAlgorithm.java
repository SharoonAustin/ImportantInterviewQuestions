package Graphs;

public class FloodFillAlgorithm {

	
	public static void floodFill(int graph[][], int srcX, int srcY, int maxX, int maxY, int newColor, int currentColor){
		if(srcX<0 || srcY<0 || srcX>=maxX || srcY>=maxY || graph[srcX][srcY]!=currentColor)
			return ;
		
		graph[srcX][srcY]=newColor;
		floodFill(graph, srcX-1, srcY, maxX, maxY, newColor, currentColor);
		floodFill(graph, srcX, srcY+1, maxX, maxY, newColor, currentColor);
		floodFill(graph, srcX+1, srcY, maxX, maxY, newColor, currentColor);
		floodFill(graph, srcX, srcY-1, maxX, maxY, newColor, currentColor);
	
	}
	
	public static void printTheGraph(int graph[][]){
		for(int i=0; i<graph.length;i++){
			for(int j=0;j<graph[0].length;j++)
				System.out.print(graph[i][j]+" ");
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		int graph[][]=new int[][]
				{
				{1,1,1},
				{1,1,0},
				{1,0,1}
				};
		int maxX=graph.length;
		int maxY=graph[0].length;
		int srcX=1;
		int srcY=1;
		int newColor=2;
		int currentColor=graph[srcX][srcY];
		floodFill(graph, srcX, srcY, maxX, maxY, newColor, currentColor);
		printTheGraph(graph);
	}

}
