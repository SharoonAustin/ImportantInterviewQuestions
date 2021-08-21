package Graphs;

public class PrintAllPossiblePaths {
	
	public static void allPossiblePath(int graph[][],int resultant[][], int i, int j, int rowLength, int columnLength){
		if(i<0 || j<0 || i>=rowLength || j>=columnLength)
			return ;
		
		if(i==rowLength-1 && j==columnLength-1){
			resultant[rowLength-1][columnLength-1]=graph[rowLength-1][columnLength-1];
			printThePath(resultant);
			resultant[rowLength-1][columnLength-1]=0;
		}
		
		resultant[i][j]=graph[i][j];
		allPossiblePath(graph, resultant, i, j+1, rowLength, columnLength);
		allPossiblePath(graph, resultant, i+1, j, rowLength, columnLength);
		resultant[i][j]=0;
	}
	
	private static void printThePath(int[][] resultant) {
		for(int i=0;i<resultant.length;i++){
			for(int j=0;j<resultant[0].length;j++){
				if(resultant[i][j]>0)
					System.out.print(resultant[i][j]+" ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{1, 2},
				{3, 4}
		};
		int rowLength=graph.length;
		int columnLength=graph[0].length;
		int resultant[][]=new int[rowLength][columnLength];
		allPossiblePath(graph, resultant, 0, 0, rowLength, columnLength);
	}
}
