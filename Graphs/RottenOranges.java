package Graphs;
import java.util.*;

class Coordinates{
	int x,y;
	Coordinates(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class RottenOranges {

	
	public static int rottenOranges(int graph[][]){
		Queue<Coordinates> queue=new LinkedList<Coordinates>();
		int row=graph.length;
		int column=graph[0].length;
		int total=0;
		int rotten=0;
		int time=0;
		//Calculate the total number of oranges and add the rotten oranges in the queue
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[0].length;j++){
				if(graph[i][j]==1 || graph[i][j]==2) total++;
				if(graph[i][j]==2)
					queue.add(new Coordinates(i, j));
			}
		}
		
		//If no oranges are there
		if(total==0) return 0;
		
		//Start Emptying the queue until every fresh orange gets rotten
		while(!queue.isEmpty()){
			int size=queue.size();
			rotten+=size;
			//If rotten has become equal to the total simply return it.
			if(rotten==total) return time;
		
			time++;
			
			
			for(int i=0;i<size;i++){
				//Start polling by one
				Coordinates pair=queue.poll();
				
				//Check in all the direction from the current pair
				if(isValid(pair.x-1,pair.y,row,column)==0 && graph[pair.x-1][pair.y]==1){
					graph[pair.x-1][pair.y]=2;
					queue.add(new Coordinates(pair.x-1, pair.y));
				}
				
				if(isValid(pair.x,pair.y+1,row,column)==0 && graph[pair.x][pair.y+1]==1){
					graph[pair.x][pair.y+1]=2;
					queue.add(new Coordinates(pair.x, pair.y+1));
				}
				
				if(isValid(pair.x+1,pair.y,row,column)==0 && graph[pair.x+1][pair.y]==1){
					graph[pair.x+1][pair.y]=2;
					queue.add(new Coordinates(pair.x+1, pair.y));
				}
				
				if(isValid(pair.x,pair.y-1,row,column)==0 && graph[pair.x][pair.y-1]==1){
					graph[pair.x][pair.y-1]=2;
					queue.add(new Coordinates(pair.x, pair.y-1));
				}
				
			}
			
			
		}
		//Even after emptying the queue if rotten!=total then it means fresh oranges are still left.
		return -1;
	}
	
	

	public static int isValid(int x, int y, int maxX, int maxY){
		if(x<0 || y<0 || x>=maxX || y>=maxY)
			return -1;
		return 0;
	}

	public static void main(String[] args) {
		 int graph[][]=new int[][]{ 
				 {2, 1, 0, 2, 1},
                 {1, 0, 1, 2, 1},
                 {1, 0, 0, 2, 1}
         };
		 
		 System.out.print(rottenOranges(graph));
	}

}
