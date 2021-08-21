package Graphs;

import java.util.ArrayList;

public class MinimumCostPathIn4D {

	static int sum=0;
	public int minimumPath(int graph[][], int i, int j){
		
		if(i<0 || j<0 || i>=graph.length || j>=graph[0].length)
			return Integer.MAX_VALUE;
		
		return graph[i][j]+min(minimumPath(graph, i, j-1),
				minimumPath(graph, i-1, j),
				minimumPath(graph, i, j+1),
				minimumPath(graph, i+1, j));
	}
	
	public static int min(int i, int j, int k, int l){
		
		if(i<j && i<k)
			return (i<l) ? i : l;
		
		else if(j<i && j<k)
			return (j<l)? j: l;
		
		else if(k<i && k<j)
			return (k<l) ? k : l;
		
		else
			return l;
		
	}
	
	public static void main(String[] args) {
		MinimumCostPathIn4D d1=new MinimumCostPathIn4D();
		int graph[][]=new int[][]{
		{31,   100,   65,   12,   18},
		{10,    13,    47,  157,   6},
		{100,  113,  174,   11,   33},
		{88,   124,   41,    20,  140},
		{99,    32,   111,   41,   20}
		};
		sum=graph[0][0];
		System.out.print(d1.minimumPath(graph,0,0));
		
	}
}
