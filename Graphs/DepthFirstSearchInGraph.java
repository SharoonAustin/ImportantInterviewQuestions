package Graphs;
import java.util.*;
public class DepthFirstSearchInGraph {
	
	public void addThEdge(HashMap<Integer,ArrayList<Integer>> hm,int u, int v){
		hm.putIfAbsent(u,new ArrayList<Integer>());
		hm.get(u).add(v);
		hm.putIfAbsent(v,new ArrayList<Integer>());
		hm.get(v).add(u);
	}
	
	public void depthFirstSearchInTheGraph(int element,boolean[] isVisted,HashMap<Integer,ArrayList<Integer>> hm){
		if(isVisted[element]==false){
			System.out.print(element+" ");
			isVisted[element]=true;
			for(int i=0;i<hm.get(element).size();i++)
				depthFirstSearchInTheGraph(hm.get(element).get(i),isVisted,hm);
		}
	}

	public static void main(String[] args) {
		DepthFirstSearchInGraph g1=new DepthFirstSearchInGraph();
		HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
		
		g1.addThEdge(hm,1,3);
		g1.addThEdge(hm,1,2);
		g1.addThEdge(hm,1,4);
		g1.addThEdge(hm,2,3);
		g1.addThEdge(hm,4,3);
		g1.addThEdge(hm,4,5);
		g1.addThEdge(hm,3,5);
		
		boolean isVisited[]=new boolean[hm.size()+1];
		g1.depthFirstSearchInTheGraph(4, isVisited, hm);
		
		
	}

}
