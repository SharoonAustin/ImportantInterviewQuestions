package Graphs;
import java.util.*;
public class PrimsAlgorithm {	
	
public static void addTheEdge(ArrayList<ArrayList<Integer>> list, int u, int v, int w){
	list.get(u).add(v);
	list.get(u).add(w);
}

public static int minimumVertex(int distance[],boolean isVisited[]){
	int minIndex=-1;
	for(int i=0;i<distance.length;i++){
		if(!isVisited[i] && (minIndex==-1 || distance[i]<distance[minIndex])){
				minIndex=i;
	}
	}
	return minIndex;
}

public static void printMST(int parent[], int graph[][]){
	System.out.println("Edge"+"\t"+"Weight");
	for (int i = 1; i < graph.length; i++) 
        System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 

}

public static void primsAlgorithm(ArrayList<ArrayList<Integer>> list, int src, int V, int graph[][]){
	boolean isVisited[]=new boolean[V];
	int parent[]=new int[V];
	int distance[]=new int[V];
	
	for(int i=0;i<distance.length;i++)
		distance[i]=Integer.MAX_VALUE;
	
	distance[src]=0;
	parent[0]=-1;
	

	for(int i=0;i<V;i++){
		//Find the Minimum Vertex
		int minVertex=minimumVertex(distance, isVisited);
		isVisited[minVertex]=true;
		
		//Explore all the edges near to the Minimum vertex
		for(int j=0;j<V;j++){
			if(graph[minVertex][j]!=0 && !isVisited[j] && graph[minVertex][j]<distance[j]){
				//Check if the distance of the minimum vertex and the adjacent Vertex is less than the current distance 
				parent[j]=minVertex;	
				distance[j]=graph[minVertex][j];
					
			}
		}
	}
	printMST(parent,graph);
}


public static void main(String[] args) {
	int V=5;
	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(V);
	
	for(int i=0;i<V;i++)
		list.add(new ArrayList<Integer>());

	addTheEdge(list, 0, 1, 2);
	addTheEdge(list, 0, 3, 6);
	addTheEdge(list, 1, 0, 2);
	addTheEdge(list, 1, 2, 3);
	addTheEdge(list, 1, 3, 8);
	addTheEdge(list, 1, 4, 5);
	addTheEdge(list, 2, 1, 3);
	addTheEdge(list, 2, 4, 7);
	addTheEdge(list, 3, 0, 6);
	addTheEdge(list, 3, 1, 8);
	addTheEdge(list, 3, 4, 9);
	addTheEdge(list, 4, 1, 5);
	addTheEdge(list, 4, 2, 7);
	addTheEdge(list, 4, 3, 9);
	
	int graph[][]=new int[][]{
			{0, 2, 0, 6, 0},
			{2, 0, 3, 8, 5},
			{0, 3, 0, 0, 7},
			{6, 8, 0, 0, 9},
			{0, 5, 7, 9, 0},
			};

	primsAlgorithm(list, 0, V, graph);


}
}
