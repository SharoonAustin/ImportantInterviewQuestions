package Graphs;

import java.util.LinkedList;
import java.util.Queue;


class Pair{
	int x,y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class MinimumPathIn8D {

	public static int findMinimum(int Matrix[][]) {
		int dx[]={-1,-1,-1,0,1,1,1,0};
		int dy[]={-1,0,1,1,1,0,-1,-1};
		int maxX=Matrix.length;
		int maxY=Matrix[0].length;
		
		boolean[][] isVisited=new boolean[maxX][maxY];
		Queue<Pair> queue=new LinkedList<Pair>();
		queue.add(new Pair(0,0));
		isVisited[0][0]=true;
		int count=0;
		
		while(!queue.isEmpty()){
			int getSize=queue.size();
			
			for(int j=0;j<getSize;j++){
				Pair current=queue.remove();
				

				if(current.x==maxX-1 && current.y==maxY-1){
					return count;
				}
			
			for(int i=0;i<8;i++){
				if(isValid(dx[i]+current.x, dy[i]+current.y, maxX, maxY) && !isVisited[dx[i]+current.x][dy[i]+current.y]){
					isVisited[dx[i]+current.x][dy[i]+current.y]=true;
					queue.add(new Pair(dx[i]+current.x,dy[i]+current.y));
					
				}
			}
		}
			count++;
		}
		return -1;
	}
	
	public static boolean isValid(int x, int y,int N,int M){
		if(x<0 || y<0 || x>=N || y>=M)
			return false;
	return true;
	}
	
	public static void main(String args[]) {
		int Matrix[][]=new int[][] {
			{2,0,2,2,0,0,1,2,2,1},
			{2,0,2,2,0,0,1,2,2,1},
			{2,0,2,2,0,0,1,2,2,1},
			{2,0,2,2,0,0,1,2,2,1},
			{2,0,2,2,0,0,1,2,2,1},
			{2,0,2,2,0,0,1,2,2,1}
		};
		System.out.println(findMinimum(Matrix));
		
	}
}
