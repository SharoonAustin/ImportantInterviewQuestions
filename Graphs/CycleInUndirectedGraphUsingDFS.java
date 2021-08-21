package Graphs;
import java.util.*;
public class CycleInUndirectedGraphUsingDFS {

	public void addTheEdge(ArrayList<ArrayList<Integer>> adj,int u, int v){
		adj.get(u).add(v);
		adj.get(v).add(u);
		
	}
	
	public boolean isCyclicOrNot(ArrayList<ArrayList<Integer>> list,int V){
		boolean isVisited[]=new boolean[V];
		
		for(int i=0;i<V;i++)
			if(!isVisited[i])
				if(isCyclicOrNotUtil(i,list, isVisited,-1))
					return true;
		
		return false;
	}
	
	public boolean isCyclicOrNotUtil(int current, ArrayList<ArrayList<Integer>> list, boolean isVisited[], int parent){
		isVisited[current]=true;
		List<Integer> l1=list.get(current);
		for(Integer c:l1){
			if(!isVisited[c]){
				if(isCyclicOrNotUtil(c,list,isVisited,current))
					return true;
			}
			else if(c!=parent)
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		CycleInUndirectedGraphUsingDFS g1=new CycleInUndirectedGraphUsingDFS();
		int V=4;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());
		
		g1.addTheEdge(list, 0, 1);
		g1.addTheEdge(list,	1, 2);
		g1.addTheEdge(list, 2, 3);
		System.out.print(g1.isCyclicOrNot(list,V));
		
	}

}
