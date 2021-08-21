package Graphs;
import java.util.*;
public class BreadthFirstSearchInGraph {
	
	public void addThEdge(HashMap<Integer,ArrayList<Integer>> hm,int u,int v){
		hm.putIfAbsent(u,new ArrayList<Integer>());
		hm.get(u).add(v);
		hm.putIfAbsent(v,new ArrayList<Integer>());
		hm.get(v).add(u);	
	}
	
	public void breadthFirstSearchInGraph(int element,boolean isVisited[],Queue<Integer> queue,HashMap<Integer,ArrayList<Integer>> hm){
		int u=Integer.MIN_VALUE;
		System.out.print(element+" ");
		isVisited[element]=true;
		queue.add(element);
		while(!queue.isEmpty()){
			u=queue.poll();
			for(int v=0;v<hm.get(u).size();v++){
				if(isVisited[hm.get(u).get(v)]==false){
					System.out.print(hm.get(u).get(v)+" ");
					isVisited[hm.get(u).get(v)]=true;
					queue.add(hm.get(u).get(v));
				}
			}
				
		}
		
	}
	
	public static void main(String[] args) {
		BreadthFirstSearchInGraph g1=new BreadthFirstSearchInGraph();
		HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
		g1.addThEdge(hm,1,2);
		g1.addThEdge(hm,1,3);
		g1.addThEdge(hm,1,4);
		g1.addThEdge(hm,2,3);
		g1.addThEdge(hm,4,3);
		g1.addThEdge(hm,4,5);
		g1.addThEdge(hm,3,5);
		
		boolean isVisited[]=new boolean[hm.size()+1];
		Queue<Integer> queue=new LinkedList<Integer>();
		
		g1.breadthFirstSearchInGraph(4, isVisited, queue, hm);
	}

}
