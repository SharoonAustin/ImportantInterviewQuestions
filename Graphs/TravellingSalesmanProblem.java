package Graphs;

public class TravellingSalesmanProblem {
	
	static int min_cost=Integer.MAX_VALUE;
	public static void tsp(int u, boolean isVisited[], int graph[][], int count, int current_cost, int n){
		count++;
		isVisited[u]=true;
		
		if(count==n){
			if(graph[u][0]!=0 && current_cost+graph[u][0]<min_cost){
				min_cost=Math.min(min_cost, current_cost+graph[u][0]);
			}
			isVisited[u]=false;
			return ;
		}
		
		for(int v=0; v<n; v++){
			if(graph[u][v]!=0 && !isVisited[v]){
				tsp(v, isVisited, graph, count, current_cost+graph[u][v], n);
			}
		}
		isVisited[u]=false;
	}
	
	public static void main(String[] args) {
		int graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
                };
		boolean isVisited[]=new boolean[graph[0].length];
		int count=0;
		int current_cost=0;
		int n=graph[0].length;
		
		tsp(0, isVisited, graph, count, current_cost, n);
		System.out.println(min_cost);
	}

}
