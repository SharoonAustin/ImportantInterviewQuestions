package Graphs;

public class MinimumCostPath {
	
	public static int minCost(int graph[][],int dp[][]){
		int colLength=graph[0].length;
		//Filling the first rows
		int i=1;
		while(i<colLength){
			dp[0][i]=graph[0][i]+dp[0][i-1];
			i++;
		}
		
		//Filling the first column
		int rowLength=graph.length;
		i=1;
		while(i<rowLength){
			dp[i][0]=graph[i][0]+dp[i-1][0];
			i++;
		}
		
		//Filling rest of the matrix
		for(int k=1;k<rowLength;k++){
			for(int m=1;m<colLength;m++){
				dp[k][m]=graph[k][m]+Math.min(dp[k-1][m], dp[k][m-1]);
			}
		}
		
		
		return dp[dp.length-1][dp[0].length-1];		
	}
	
	//Recursion+Memoization
	
	public static int recursiveSolution(int graph[][],int x,int y,int destX,int destY){
	 	if(x<0 || x>= graph.length || y<0 || y>=graph[0].length)
         return Integer.MAX_VALUE;
	 	
	 	else if(x==destX && y==destY)
	 		return graph[x][y];
	 	
	 	return graph[x][y]+Math.min(recursiveSolution(graph,x+1,y,destX,destY), recursiveSolution(graph,x,y+1,destX,destY));
	}
	
	
	public static void main(String[] args) {
		/*int graph[][]=new int[][]{
		 {31,   100,   65,   12,   18},
		 {10,    13,    47,  157,   6},
		 {100,  113,  174,   11,   33},
		 {88,   124,   41,    20,  140},
		 {99,    32,   111,   41,   20}
	};*/
		int graph[][]={
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3}
		};
		int dp[][]=new int[graph.length][graph[0].length];
		dp[0][0]=graph[0][0];
		System.out.println(minCost(graph, dp));
		int t[][]=new int[graph.length][graph[0].length];
		System.out.println(recursiveSolution(graph,0,0,graph.length,graph[0].length));
}
}
