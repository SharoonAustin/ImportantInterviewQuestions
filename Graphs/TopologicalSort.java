package Graphs;
import java.util.*;

public class TopologicalSort {

	public void addTheEdge(ArrayList<ArrayList<Integer>> list,int u,int v){
		list.get(u).add(v);
	}
	
	public void DFS(ArrayList<ArrayList<Integer>> list, boolean isVisited[], int start, Stack<Integer> stack){
		if(isVisited[start]==false){
		isVisited[start]=true;
		for(int i=0;i<list.get(start).size();i++)
				DFS(list, isVisited, list.get(start).get(i), stack);
		stack.push(start);
		}
	}
	
	public static void main(String[] args) {
		TopologicalSort t1=new TopologicalSort();
		int V=6;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());
		
		t1.addTheEdge(list, 1, 2);
		t1.addTheEdge(list, 2, 4);
		t1.addTheEdge(list, 1, 4);
		t1.addTheEdge(list, 2, 3);
		t1.addTheEdge(list, 4, 3);
		t1.addTheEdge(list, 4, 5);

		boolean []isVisited=new boolean[V];
		Stack<Integer> stack=new Stack<Integer>();
		
		t1.DFS(list, isVisited, 1, stack);
		
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		
	}

}
