package Graphs;
import java.util.*;

public class CycleInUndirectedGraphUsingBFS {

	public void addTheEdge(ArrayList<ArrayList<Integer>> l1,int u,int v){
		l1.get(u).add(v);
		l1.get(v).add(u);
	}
	
	public boolean isCyclicOrNot(ArrayList<ArrayList<Integer>> list, boolean[] isVisited, int[] parent,int element){
		Queue<Integer> queue=new LinkedList<Integer>();
		isVisited[element]=true;
		parent[element]=element;
		queue.add(element);
		
		while(!queue.isEmpty()){
			int node=queue.poll();
			
			for(int i=0;i<list.get(node).size();i++){
				int neighbour=list.get(node).get(i);
				
				if(isVisited[neighbour]==true && parent[node]!=neighbour)
					return true;
				
				else if(!isVisited[neighbour]){
					isVisited[neighbour]=true;
					parent[neighbour]=node;
					queue.add(neighbour);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CycleInUndirectedGraphUsingBFS g1=new CycleInUndirectedGraphUsingBFS();
		int V=8;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());
		
		g1.addTheEdge(list, 0, 1);
		g1.addTheEdge(list, 0, 4);
		g1.addTheEdge(list, 1, 2);
		g1.addTheEdge(list, 1, 7);
		//g1.addTheEdge(list, 2, 3);		
		g1.addTheEdge(list, 4, 3);

		boolean[] isVisited=new boolean[V];
		int[] parent=new int[V]; 
		
		System.out.println(g1.isCyclicOrNot(list, isVisited, parent, 0));

	}

}
