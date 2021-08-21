package Graphs;
import java.util.*;
public class CreateGraphUsingHashMap {

	public  void addThEdge(HashMap<Integer,ArrayList<Integer>> hm, int u,int v){
		hm.putIfAbsent(u, new ArrayList<Integer>());
		hm.get(u).add(v);
	}
	
	public void printTheGraph(HashMap<Integer,ArrayList<Integer>> hm){
		for(int i=1;i<=hm.size();i++){
			System.out.print(i);
		for(int j=0;j<hm.get(i).size();j++){
			System.out.print("-->"+hm.get(i).get(j));
		}
		System.out.println();
		}
	}
	
	public static void main(String[] args) {
		CreateGraphUsingHashMap g1=new CreateGraphUsingHashMap();

		HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
		g1.addThEdge(hm,1,2);
		g1.addThEdge(hm,1,3);
		g1.addThEdge(hm,1,4);
		g1.addThEdge(hm,2,3);
		g1.addThEdge(hm,4,3);
		g1.addThEdge(hm,4,5);
		g1.addThEdge(hm,3,5);
		
		
		g1.printTheGraph(hm);

	}

}
