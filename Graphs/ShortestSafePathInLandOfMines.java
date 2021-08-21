package Graphs;

import java.util.*;

public class ShortestSafePathInLandOfMines {
	
	
	public static int shortestPath(int graph[][], boolean isVisited[][], int x, int y, int destX, int destY){
		int dx[]={0,1,0,-1};
		int dy[]={1,0,-1,0};
		int count=0;
		Queue<Coordinates> queue=new LinkedList<Coordinates>();
		queue.add(new Coordinates(x, y));
		isVisited[x][y]=true;

		while(!queue.isEmpty()){
			int getSize=queue.size();
			
			for(int m=0;m<getSize;m++){
				Coordinates current=queue.poll();
				
				if(current.x==destX && current.y==destY)
					return count;
				
				for(int i=0;i<4;i++){
					if(isValid(graph,dx[i]+current.x, dy[i]+current.y, graph.length, graph[0].length) && !isVisited[dx[i]+current.x][dy[i]+current.y]){
						isVisited[dx[i]+current.x][dy[i]+current.y]=true;
						queue.add(new Coordinates(dx[i]+current.x,dy[i]+current.y));			
					}
				}
				
			}
			count++;
		}
		return -1;
	}
	
	public static boolean isValid(int graph[][],int x, int y, int maxX, int maxY) {
		if(x<0 || y<0 || x>=maxX || y>=maxY || graph[x][y]==0)
			return false;
		return true;
	}

	
	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
				{ 1,  0,  1,  1,  1,  1,  1,  1,  1,  1 },
				{ 1,  1,  1,  0,  1,  1,  1,  1,  1,  1 },
				{ 1,  1,  1,  1,  0,  1,  1,  1,  1,  1 },
				{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
				{ 1,  1,  1,  1,  1,  0,  1,  1,  1,  1 },
				{ 1,  0,  1,  1,  1,  1,  1,  1,  0,  1 },
				{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
				{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
				{ 0,  1,  1,  1,  1,  0,  1,  1,  1,  1 },
				{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
				{ 1,  1,  1,  0,  1,  1,  1,  1,  1,  1 }	
		};

		
		boolean isVisited[][]=new boolean[graph.length][graph[0].length];
		
		int srcX=4;
		int srcY=0;
		
		int destX=8;
		int destY=9;
		
	
		System.out.println(shortestPath(graph,isVisited,srcX,srcY,destX,destY));
	}

}
