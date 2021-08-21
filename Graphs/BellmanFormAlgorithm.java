package Graphs;
import java.util.*;
public class BellmanFormAlgorithm {

	
	public static void bellmanFordAlgorithm(int graph[][],ArrayList<ArrayList<Integer>> list, int src){
		int V=graph.length;
		int []distance=new int[V];
		
		for(int i=0;i<V;i++)
			distance[i]=Integer.MAX_VALUE;
		
		distance[src]=0;
		
		for(int i=0;i<V-1;i++){
			for(int j=0;j<list.size();j++){
				if(!list.get(j).isEmpty()){
				int u=list.get(j).get(0);
				int v=list.get(j).get(1);
				if(distance[u]+graph[u][v]<distance[v])
					distance[v]=distance[u]+graph[u][v];
				}
			}
		}
		
				//Check negative cycles
				for(int j=0;j<list.size();j++){
					if(!list.get(j).isEmpty()){
					int u=list.get(j).get(0);
					int v=list.get(j).get(1);
					if(distance[u]!=Integer.MAX_VALUE && distance[u]+graph[u][v]<distance[v])
						System.out.println("Graph Contains Negative Cycle");
					}
				}
		
		System.out.println("Vertex"+"\t\t"+"distance");
		for(int i=0;i<V;i++){
			System.out.println(i+"\t\t"+distance[i]);
		}
		
		
	}

	public static void main(String[] args) {
		int graph[][]= new int[][] { 
				{ 0, 6, 5, 5, 0, 0, 0}, 
				{ 0, 0, 0, 0, -1, 0, 0},
				{ 0, -2, 0, 0, 1, 0, 0}, 
				{ 0, 0, -2, 0, 0, -1, 0}, 
				{ 0, 0, 0, 0, 0, 0, 3}, 
				{ 0, 0, 0, 0, 0, 0, 3},
				{ 0, 0, 0, 0, 0, 0, 0}
                };
		
		ArrayList<ArrayList<Integer>> l1=new ArrayList<ArrayList<Integer>>(graph.length*2);
		
		for(int i=0;i<graph.length*graph.length;i++)
			l1.add(new ArrayList<Integer>());
		int m=0;
		for(int i=0;i<graph[0].length;i++){
			for(int j=0;j<graph.length;j++){
				if(graph[i][j]>0 || graph[i][j]<0){
					l1.get(m).add(i);
					l1.get(m).add(j);
					m++;
				}
		}
	}
		bellmanFordAlgorithm(graph, l1, 0);	
		System.out.println();
	}

}
