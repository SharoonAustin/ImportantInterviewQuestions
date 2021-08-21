package Graphs;
import java.util.*;

public class KosarajuAlgorithm {

	public void addTheEdge(ArrayList<ArrayList<Integer>> list,int u, int v){
		list.get(u).add(v);
	}
	
	public void kosarajuAlogrithm(ArrayList<ArrayList<Integer>> list){
		int V=list.size();
		boolean isVisited[]=new boolean[V];
		Stack<Integer> stack=new Stack<Integer>();
	
		for(int i=0;i<V;i++){
			if(!isVisited[i])
				dfsForList(list,isVisited,i,stack);
		}
		
		ArrayList<ArrayList<Integer>> reverse=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<V;i++)
			reverse.add(new ArrayList<Integer>());
		reverseTheList(list,reverse,V);
	
		
		for(int i=0;i<V;i++)
			isVisited[i]=false;
		
		int count=0;
		
		while(!stack.isEmpty()){
			int i=stack.pop();
			if(!isVisited[i]){
				dfs(reverse, isVisited, i);
				count++;
			}
		}
		System.out.print(count);
	}
	
	public void dfsForList(ArrayList<ArrayList<Integer>> list, boolean isVisited[], int start,Stack<Integer> stack){
		if(!isVisited[start]){
			isVisited[start]=true;
			for(int i=0;i<list.get(start).size();i++)
				dfsForList(list,isVisited,list.get(start).get(i),stack);
		stack.push(start);
		}
	}
	
	public void dfs(ArrayList<ArrayList<Integer>> list, boolean isVisited[], int start){
		if(!isVisited[start]){
			isVisited[start]=true;
			for(int i=0;i<list.get(start).size();i++)
				dfs(list,isVisited,list.get(start).get(i));
		}
	}
	
	public void reverseTheList(ArrayList<ArrayList<Integer>> list, ArrayList<ArrayList<Integer>> reverse, int V){
		for(int i=0;i<V;i++){
			for(int j=0;j<list.get(i).size();i++){
				int u=list.get(i).get(j);
				reverse.get(u).add(i);
			}
		}
	}
	
	public static void main(String[] args) {
		KosarajuAlgorithm k1=new KosarajuAlgorithm();
		int V=5;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(V);
		ArrayList<ArrayList<Integer>> reverseList=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++){
			list.add(new ArrayList<Integer>());
			reverseList.add(new ArrayList<Integer>());
		}
			
		/*k1.addTheEdge(list, 0, 1);
		k1.addTheEdge(list, 1, 2);
		k1.addTheEdge(list, 2, 0);
		k1.addTheEdge(list, 2, 3);
		k1.addTheEdge(list, 3, 4);
		k1.addTheEdge(list, 4, 3);
		k1.addTheEdge(list, 5, 4);
		k1.addTheEdge(list, 8, 5);
		k1.addTheEdge(list, 7, 8);
		k1.addTheEdge(list, 6, 7);
		k1.addTheEdge(list, 5, 6);
		k1.addTheEdge(list, 6, 9);*/
		
		k1.addTheEdge(list,1, 0); 
        k1.addTheEdge(list,0, 2); 
        k1.addTheEdge(list,2, 1); 
        k1.addTheEdge(list,0, 3); 
        k1.addTheEdge(list,3, 4); 
		
		/*k1.addTheEdge(reverseList, 1, 0);
		k1.addTheEdge(reverseList, 2, 1);
		k1.addTheEdge(reverseList, 0, 2);
		k1.addTheEdge(reverseList, 3, 2);
		k1.addTheEdge(reverseList, 4, 3);
		k1.addTheEdge(reverseList, 3, 4);
		k1.addTheEdge(reverseList, 4, 5);
		k1.addTheEdge(reverseList, 5, 8);
		k1.addTheEdge(reverseList, 8, 7);
		k1.addTheEdge(reverseList, 7, 6);
		k1.addTheEdge(reverseList, 6, 5);
		k1.addTheEdge(reverseList, 9, 6);*/
		
		k1.kosarajuAlogrithm(list);
		
		
		
	
	}

}
