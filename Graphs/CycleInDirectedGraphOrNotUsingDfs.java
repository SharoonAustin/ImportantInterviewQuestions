package Graphs;
import java.util.*;

public class CycleInDirectedGraphOrNotUsingDfs {

	public void addTheEdge(ArrayList<ArrayList<Integer>> list, int u, int v){
		list.get(u).add(v);
	}
	
	public void addTheEdgeInHashMap(HashMap<Integer,ArrayList<Integer>> hm, int u, int v){
		hm.putIfAbsent(u, new ArrayList<Integer>());
		hm.get(u).add(v);
	}
	
	public boolean isCyclic(int V,ArrayList<ArrayList<Integer>> list){
		boolean []isVisited=new boolean[V];
		boolean[] isStack=new boolean[V];
		
		for(int i=0;i<V;i++)
			if(!isVisited[i])
				if(isCyclicUtil(i,list,isVisited,isStack))
					return true;
		return false;
	}
	
	public static boolean isCyclicUtil(int i,ArrayList<ArrayList<Integer>> list,boolean isVisited[], boolean isStack[]){
		
		if(isStack[i])
			return true;
		
		if(isVisited[i])
			return false;
		
		isStack[i]=true;
		isVisited[i]=true;
		
		List<Integer> l1=list.get(i);
		
		for(Integer c:l1)
			if(isCyclicUtil(c,list,isVisited,isStack))
				return true;
		
		isStack[i]=false;
		return false;
		
	}
	
	
	public static void main(String[] args) {
		CycleInDirectedGraphOrNotUsingDfs g1=new CycleInDirectedGraphOrNotUsingDfs();
		int V=5;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());
		
		g1.addTheEdge(list,0, 1); 
        g1.addTheEdge(list,0, 2);
        g1.addTheEdge(list,2, 0);
        g1.addTheEdge(list,1, 2); 
        g1.addTheEdge(list,2, 3); 
   
        if(g1.isCyclic(V, list)){
        	System.out.print("Contains Cycle");
        }
        else{
        	System.out.print("Doesn't contain cycle");
        }
        
       /* HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
        g1.addTheEdgeInHashMap(hm, 0, 1);
        g1.addTheEdgeInHashMap(hm,0, 2);
        g1.addTheEdgeInHashMap(hm,1, 2); 
        g1.addTheEdgeInHashMap(hm,2, 3); */

	}

}
