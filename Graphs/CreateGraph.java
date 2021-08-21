package Graphs;
import java.util.*;
public class CreateGraph {


	public void addEdge(ArrayList<ArrayList<Integer>>l1,int u,int v){
		l1.get(u).add(v);
		l1.get(v).add(u);
	}
	
	public void printTheGraph(ArrayList<ArrayList<Integer>>l1){
		for(int i=0;i<l1.size();i++){
			System.out.print(i);
		for(int j=0;j<l1.get(i).size();j++){
			System.out.print("-->"+l1.get(i).get(j));
		}
		System.out.println();
		}
	}
	
	public static void main(String[] args) {
		CreateGraph g1=new CreateGraph();
		int V=6;
		ArrayList<ArrayList<Integer> > l1=new ArrayList<ArrayList<Integer> >(V);

		for(int i=0;i<V;i++){
			l1.add(new ArrayList<Integer>());
		}
		
		g1.addEdge(l1, 1, 2);
		g1.addEdge(l1, 1, 3);
		g1.addEdge(l1, 1, 4);
		g1.addEdge(l1, 2, 3);
		g1.addEdge(l1, 4, 3);
		g1.addEdge(l1, 4, 5);
		g1.addEdge(l1, 3, 5);

		g1.printTheGraph(l1);

		
	}

}
