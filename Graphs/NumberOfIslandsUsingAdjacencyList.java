package Graphs;
import java.util.*;


public class NumberOfIslandsUsingAdjacencyList {
	
	 public int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
		 boolean isVisited[][]=new boolean[N][M];
		 int count=0;
		 for(int i=0;i<N;i++){
			 for(int j=0;j<M;j++){
				 if(A.get(i).get(j)==1 && !isVisited[i][j]){
					 dfs(A,i,j,isVisited,N,M);
					 count++;
				 }
			 }
		 }
		 return count;
	 }
	 
	 public static void dfs(ArrayList<ArrayList<Integer>> A,int m,int n,boolean isVisited[][],int N, int M){
			
		 int dx[]= new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
	     int dy[]= new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
	
	    isVisited[m][n]=true;
	     
		for(int i=0;i<8;i++){
			if(isValidPath(dx[i]+m, dy[i]+n, N, M) && !isVisited[dx[i]+m][dy[i]+n] && A.get(dx[i]+m).get(dy[i]+n)==1)
				dfs(A,dx[i]+m, dy[i]+n, isVisited, N, M);
		}
	}
	 
	 
	 public static boolean isValidPath(int x, int y, int N, int M){
		 if(x<0 || y< 0 || x>=N || y>=M)
			 return false;
		 return true;
	 }
	
	
	public static void main(String[] args) {
		NumberOfIslandsUsingAdjacencyList n1=new NumberOfIslandsUsingAdjacencyList();
		int V=4;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(4);
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Integer>());
		
		list.get(0).add(1);
		list.get(0).add(1);
		list.get(0).add(0);
		list.get(0).add(0);
		
		list.get(1).add(0);
		list.get(1).add(0);
		list.get(1).add(1);
		list.get(1).add(0);
		
		list.get(2).add(0);
		list.get(2).add(0);
		list.get(2).add(0);
		list.get(2).add(1);
		
		list.get(3).add(0);
		list.get(3).add(1);
		list.get(3).add(0);
		list.get(3).add(0);
		
		System.out.print(n1.findIslands(list, list.size(), list.get(0).size()));
	}

}
