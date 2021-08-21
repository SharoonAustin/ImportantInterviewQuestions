package Graphs;
import java.util.*;
public class DjikstraAlgorithmForUndirectedGraph {

	public void djikstraAlgoirth(int graph[][],int src){
		int V=graph.length;
		
		boolean isVisited[]=new boolean[V];
		int distance[]=new int[V];
		
		for(int i=1;i<distance.length;i++)
			distance[i]=Integer.MAX_VALUE;
		
		distance[src]=0;
		
		for(int i=0;i<V;i++){
			int minIndex=getMinimumIndex(distance,isVisited);
			isVisited[minIndex]=true;
			for(int j=0;j<V;j++){
				if(graph[minIndex][j]!=0 && !isVisited[j]){
					int newDistance=distance[minIndex]+graph[minIndex][j];
					if(newDistance<distance[j])
						distance[j]=newDistance;
				}
			}
		}
		System.out.println("Vertex"+"\t"+"Distance");
		for(int i=0;i<V;i++)
			System.out.println(i+"\t"+distance[i]);
	}
	
	
	public static int getMinimumIndex(int distance[], boolean isVisited[]){
		int minIndex=-1;
		for(int i=0;i<distance.length;i++){
			if(!isVisited[i] && (minIndex==-1 || distance[i]<distance[minIndex]))
				minIndex=i;
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		DjikstraAlgorithmForUndirectedGraph d1=new DjikstraAlgorithmForUndirectedGraph();
	int graph[][]={
			{0,1,0,0,0},
			{1,0,1,1,0},
			{0,1,0,1,0},
			{0,1,0,0,1},
			{0,0,0,1,0}
	};
	d1.djikstraAlgoirth(graph, 0);
		
	}

}
