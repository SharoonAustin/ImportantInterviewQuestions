package Graphs;

public class RatInAMazeAlgorithm {

	public static void mazeProblem(int graph[][], int resultant[][], int x, int y, int destX, int destY){
		if(x<0 || y<0 || x>=graph.length || y>=graph[0].length || graph[x][y]==0)
			return ;
		
		if(x==destX || y==destY){
			resultant[x][y]=1;
			if(resultant[destX][destY]==1)
				printTheGraph(resultant);
		}
		
		resultant[x][y]=1;
		
		mazeProblem(graph,resultant,x+1,y,destX,destY);
		mazeProblem(graph,resultant,x,y+1,destX,destY);
		resultant[x][y]=0;
	}
	
	public static void printTheGraph(int resultant[][]){
		for(int i=0; i<resultant.length; i++){
			System.out.print(i+" ");
			for(int j=0; j<resultant[0].length;j++)
				System.out.print(j+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{1,0,0,0},
				{1,1,1,1},
				{0,1,1,0},
				{1,1,1,1}
		};
		int destinationX=graph.length-1;
		int destinationY=graph[0].length-1;
		int resultant[][]=new int[][]{
				{1,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
		};
		int x=0;
		int y=0;
		mazeProblem(graph,resultant,x,y,destinationX,destinationY);
	}

}
