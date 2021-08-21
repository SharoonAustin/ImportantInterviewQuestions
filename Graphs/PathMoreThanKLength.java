package Graphs;

public class PathMoreThanKLength {
	static int sum=0;
	public static boolean pathExistOrNot(int graph[][], int resultant[][], int i, int j, int K){
		if(isValidPath(i, j, graph.length, graph[0].length)){
		
		if(sum>=K){
			return true;
		}
			
		sum+=graph[i][j];
		pathExistOrNot(graph, resultant, i, j+1, K);
		pathExistOrNot(graph, resultant, i+1, j, K);
		sum-=graph[i][j];		
		}
		return false;

	}
	
	public static boolean isValidPath(int i, int j, int maxRow, int maxColumn){
		if(i<0 || j<0 || i>=maxRow || j>=maxColumn)
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{0, 10, 5, 1},
				{10, 0, 3, 7},
				{5, 3, 0, 2},
				{1, 7, 2, 0}
		};
		
		int resultant[][]=new int[graph.length][graph[0].length];
		
		int K=26;
		
		System.out.println(pathExistOrNot(graph, resultant, 0, 0, K));
	}

}
