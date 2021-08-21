package Graphs;
import java.util.*;
public class isBipartite {

	public static boolean isBipartiteGraph(int graph[][]){
		int color[]=new int[graph.length];
		Queue<Integer> queue=new LinkedList<Integer>();
		color[0]=1;
		queue.add(0);
		
		while(!queue.isEmpty()){
			int current=queue.poll();
			for(int next:graph[current]){
				if(current==next)
					continue;
				if(color[next]==0){
				color[next]=-color[current];
				queue.add(next);
				}
			
			 if(color[next] == color[current]) 
				 return false;
		}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int graph[][]=new int[][]{
				{0,1,0,1},
				{1,0,1,0},
				{0,1,0,1},
				{1,0,1,0}
		};
		
		System.out.print(isBipartiteGraph(graph));
	}

}
