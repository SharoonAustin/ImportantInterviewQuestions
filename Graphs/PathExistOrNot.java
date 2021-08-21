package Graphs;
import java.util.*;
public class PathExistOrNot {

	public boolean getPath(int graph[][]){
		Queue<Coordinate> queue=new LinkedList<Coordinate>();
		boolean isVisited[][]=new boolean[graph.length][graph[0].length];
		
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[0].length;j++){
				if(graph[i][j]==1){
					queue.add(new Coordinate(i, j));
					isVisited[i][j]=true;
				}
			}
		}
		
		while(!queue.isEmpty()){
			int size=queue.size();
			
			for(int i=0;i<queue.size();i++){
				Coordinate c1=queue.poll();
				
				if(graph[c1.x][c1.y]==2)
					return true;
				
				if(isValidPath(c1.x, c1.y-1, graph) && !isVisited[c1.x][c1.y-1]){
					queue.add(new Coordinate(c1.x, c1.y-1));
					isVisited[c1.x][c1.y-1]=true;
				}
				
				if(isValidPath(c1.x-1, c1.y, graph) && !isVisited[c1.x-1][c1.y]){
					queue.add(new Coordinate(c1.x-1, c1.y));
					isVisited[c1.x-1][c1.y]=true;
				}
				
				if(isValidPath(c1.x, c1.y+1, graph) && !isVisited[c1.x][c1.y+1]){
					queue.add(new Coordinate(c1.x, c1.y+1));
					isVisited[c1.x][c1.y+1]=true;
				}
				
				if(isValidPath(c1.x+1, c1.y, graph) && !isVisited[c1.x+1][c1.y]){
					queue.add(new Coordinate(c1.x+1, c1.y));
					isVisited[c1.x+1][c1.y]=true;
				}
			}
			
		}
		return false;
	}
	
	public boolean isValidPath(int x, int y, int graph[][]){
		if(x<0 || y<0 || x>=graph.length || y>=graph[0].length || graph[x][y]==0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{0,3,2},
				{3,0,0},
				{1,0,0}
		};
		
		
		PathExistOrNot p1=new PathExistOrNot();
		System.out.println(p1.getPath(graph));
	}

}
