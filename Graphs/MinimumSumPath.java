package Graphs;

public class MinimumSumPath {

	  	static int mimimumSumPath=Integer.MAX_VALUE; 
	  
	  		
	  	public int minPathSum(int[][] grid) {
	        int destinationX=grid.length, destinationY=grid[0].length;
			int resultant[][]=new int[grid.length][grid[0].length];
	        int srcX=0, srcY=0;
	        mimimumSumPath=Integer.MAX_VALUE;
	        minPathSumUtil(grid, resultant,srcX, srcY, destinationX, destinationY);
	        return mimimumSumPath;
	    }
	    
	    public void minPathSumUtil(int graph[][], int resultant[][],int srcX, int srcY, int maxX, int maxY){
	        if(srcX<0 || srcY<0 || srcX>=maxX || srcY>=maxY)
				return ;
	        
	        if(srcX==maxX-1 && srcY==maxY-1){
		        resultant[srcX][srcY]=1;
		        mimimumSumPath=Math.min(mimimumSumPath, getCurrentCost(graph, resultant));
	        }
	        
	        resultant[srcX][srcY]=1;
	        
	        minPathSumUtil(graph, resultant, srcX+1, srcY, maxX, maxY);
	        minPathSumUtil(graph, resultant, srcX, srcY+1, maxX, maxY);

			resultant[srcX][srcY]=0;    
	}
	    
	    public int getCurrentCost(int graph[][], int resultant[][]){
	    	int cost=0;
	    	for(int i=0; i<resultant.length; i++){
	    		for(int j=0; j<resultant[0].length; j++){
	    			if(resultant[i][j]==1)
	    				cost+=graph[i][j];
	    		}
	    	}
	    	return cost;
	    }
	    
	    
	    
	public static void main(String[] args) {
		int graph[][]={
				{1, 2, 3},
				{4, 5, 6}
		};

	System.out.print(new MinimumSumPath().minPathSum(graph));
	}
}
