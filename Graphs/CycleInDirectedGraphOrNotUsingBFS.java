package Graphs;
import java.util.*;
public class CycleInDirectedGraphOrNotUsingBFS {

	public void addTheEdge(ArrayList<ArrayList<Integer>> list, int u, int v){
		list.get(u).add(v);
	}

	public boolean checkCycleInTheGraphUtil(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> arrayList, int i){
		for(int j=0;j<arrayList.size();j++){
			if(list.get(arrayList.get(j)).contains(i)){
				return true;
			}
		}
		return false;
	}
	
	
	public void checkCycleInTheGraph(ArrayList<ArrayList<Integer>> list){
		boolean flag=true;
		for(int i=0;i<list.size();i++){
			if(flag){
			for(int j=0;j<list.get(i).size();j++){
				if(checkCycleInTheGraphUtil(list,list.get(i),i)){
					System.out.print("Cycle exist");
					flag=false;
					break;
			}
			}
	}
		}
	}
	
	
	public static void main(String[] args) {
		CycleInDirectedGraphOrNotUsingBFS g1=new CycleInDirectedGraphOrNotUsingBFS();
		int V=5;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(5);
		
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());

		g1.addTheEdge(list, 0, 1);
		g1.addTheEdge(list, 0, 2);
		g1.addTheEdge(list, 0, 3);
		g1.addTheEdge(list, 0, 4);
		g1.addTheEdge(list, 1, 2);
		g1.addTheEdge(list, 1, 3);
		g1.addTheEdge(list, 1, 4);
		g1.addTheEdge(list, 1, 1);
		g1.addTheEdge(list, 2, 3);
		g1.addTheEdge(list, 2, 4);
		g1.addTheEdge(list, 3, 4);

		g1.checkCycleInTheGraph(list);
	}

}
