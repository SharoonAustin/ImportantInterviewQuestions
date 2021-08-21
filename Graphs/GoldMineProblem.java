package Graphs;

public class GoldMineProblem {
	
	static int sum=0;
	public int getSolution(int graph[][],int x,int y, int desty){
		
		if(x<0 || y<0 || x>=graph.length || y>=graph.length)
			return Integer.MIN_VALUE;
		
		else if(y==desty)
			return graph[x][y];

		
		return graph[x][y]+ maximum(getSolution(graph, x, y+1, desty), getSolution(graph, x-1, y+1, desty), getSolution(graph, x+1, y+1, desty));
	}
	
	public int maximum(int x, int y, int z){
		if(x>=y && x>=z)
			return x;
		else if(y>=x && y>=z)
			return y;
		else
			return z;
	}
	
	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{1, 3, 3},
	            {2, 1, 4},
	            {0, 6, 4}
	            };
		System.out.print(new GoldMineProblem().getSolution(graph, 2, 0, graph[0].length-1));
}
}