package Graphs;
import java.util.*;
class CreateGraphUsingArrayList{
	int V=0;
	ArrayList<ArrayList<Integer>> list;
	
	CreateGraphUsingArrayList(int V) {
		this.V=V;
		list=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());
	}
	
	public void addEdge(int source,int destination){
		list.get(source).add(destination);
	}
	
	private boolean isCyclic()  
    { 
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
   
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
        
        return false; 
    } 
	
	 private boolean isCyclicUtil(int i, boolean[] visited, 
             boolean[] recStack)  
	 { 


		 if (recStack[i]) 
			 return true; 

		 if (visited[i]) 
			 return false; 

		 visited[i] = true; 

		 recStack[i] = true; 
		 List<Integer> children = list.get(i); 

		 for (Integer c: children) 
			 if (isCyclicUtil(c, visited, recStack)) 
				 return true; 

		 recStack[i] = false; 

		 return false; 
	 } 
	
	
	public static void main(String[] args) {
		CreateGraphUsingArrayList graph=new CreateGraphUsingArrayList(6);
		 	graph.addEdge(0, 1); 
	        graph.addEdge(0, 2); 
	        graph.addEdge(1, 2); 
	        //graph.addEdge(2, 0); 
	        graph.addEdge(2, 3); 
	        //graph.addEdge(3, 3);
	        if(graph.isCyclic())
	        	System.out.println("Graph contains cycle");
	        else
	        	System.out.println("Graph doesn't contain cycle");

	
	}

}