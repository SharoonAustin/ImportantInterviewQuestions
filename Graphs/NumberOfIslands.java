package Graphs;

public class NumberOfIslands {
	
	int count=0;
	
	public int numberOfIsland(int graph[][], int ROW, int COLUMN, boolean isVisited[][]){
		int count=0;
		for(int i=0;i<ROW;i++)
			for(int j=0;j<COLUMN;j++)
				if(graph[i][j]==1 && !isVisited[i][j]){
					dfs(graph,i, j, isVisited, ROW, COLUMN);
					++count;
				}
		return count;
	}
	
	public static void dfs(int graph[][],int m,int n,boolean isVisited[][],int ROW, int COLUMN){
	
		 int dx[]= new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
	     int dy[]= new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
	
	    isVisited[m][n]=true;
	     
		for(int i=0;i<8;i++){
			if(isValidPath(dx[i]+m, dy[i]+n, ROW, COLUMN) && !isVisited[dx[i]+m][dy[i]+n] && graph[dx[i]+m][dy[i]+n]==1)
				dfs(graph,dx[i]+m, dy[i]+n, isVisited, ROW, COLUMN);
		}
	}
	
	public static boolean isValidPath(int x, int y, int ROW, int COLUMN){
		if(x<0 || y<0 || x>=ROW || y>=COLUMN)
			return false;
		return true;
	}

	public static void main(String[] args) {
		NumberOfIslands n1=new NumberOfIslands();
		int graph[][]=new int[][]{
				{1, 1, 0, 0, 0},
	             {0, 1, 0, 0, 1},
	             {1, 0, 0, 1, 1},
	             {0, 0, 0, 0, 0},
	             {1, 0, 1, 0, 1}
	           };
		
		int ROW=graph.length;
		int COLUMN=graph[0].length;
		
		boolean isVisited[][]=new boolean[ROW][COLUMN];
		System.out.println(n1.numberOfIsland(graph, ROW, COLUMN, isVisited));
		

	}

}
