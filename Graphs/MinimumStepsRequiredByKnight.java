package Graphs;
import java.util.*;

class Coordinate{
	int x,y;
	Coordinate(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class MinimumStepsRequiredByKnight {
	
	public int knight(int N, int M, int startX, int startY, int endX, int endY){
		int dx[]={-2,-2,-1,1,2,2,1,-1};
		int dy[]={-1,1,2,2,1,-1,-2,-2};
		
		boolean[][] isVisited=new boolean[N][M];
		Queue<Coordinate> queue=new LinkedList<Coordinate>();
		queue.add(new Coordinate(startX,startY));
		isVisited[startX][startY]=true;
		int count=0;
		
		while(!queue.isEmpty()){
			int getSize=queue.size();
			
			for(int j=0;j<getSize;j++){
				Coordinate current=queue.remove();
			

				if(current.x==endX && current.y==endY){
					return count;
				}
			
			for(int i=0;i<8;i++){
				if(isValid(dx[i]+current.x, dy[i]+current.y, N, M) && !isVisited[dx[i]+current.x][dy[i]+current.y]){
					isVisited[dx[i]+current.x][dy[i]+current.y]=true;
					queue.add(new Coordinate(dx[i]+current.x,dy[i]+current.y));
					
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

	
	public static void main(String[] args) {
		int N=8;
		int M=8;

		int knightPos[] = { 0, 0 }; 
	    int targetPos[] = { 7, 7 }; 
	    MinimumStepsRequiredByKnight k1=new MinimumStepsRequiredByKnight();
	    System.out.println(k1.knight(N, M, knightPos[0], knightPos[1], targetPos[0], targetPos[1]));
		
	}

}
