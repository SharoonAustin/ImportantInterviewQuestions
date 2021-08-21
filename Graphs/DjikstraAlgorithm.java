package Graphs;

public class DjikstraAlgorithm {

	public static void DjikStraAlgo(int graph[][],int src){
		int V=graph.length;
		boolean []isVisited=new boolean[V];
		int []distance=new int[V];
		
		for(int i=0;i<V;i++)
			distance[i]=Integer.MAX_VALUE;
	
		distance[src]=0;
	
		for(int i=0;i<V;i++){
			//Find the Minimum Vertex
			int minVertex=minimumVertex(distance, isVisited);
			isVisited[minVertex]=true;
			
			//Explore all the edges near to the Minimum vertex
			for(int j=0;j<V;j++){
				if(graph[minVertex][j]!=0 && !isVisited[j]){
					//Check if the distance of the minimum vertex and the adjacent Vertex is less than the current distance 
					int newDistance=distance[minVertex]+graph[minVertex][j];
					if(newDistance<distance[j])
						distance[j]=newDistance;
				}
			}
		}
		
		System.out.println("Vertex"+"\t"+"Distance");
		for(int i=0;i<V;i++)
			System.out.println(i+"\t"+distance[i]);
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
	
	public static void main(String[] args) {
		int graph[][] = new int[][] { 
				{0,0,0},
				{1,1,0},
				{1,1,0}
                };
	
		int src=graph[0][0];
		DjikStraAlgo(graph,src);
	}

}
