package Graphs;
import java.util.*;
public class SnakeAndLadderProblem {
	
	 public static int snakesAndLadders(int[][] board) {
		 int n=board.length;
		 HashMap<Integer, ArrayList<Integer>> hm=new HashMap<Integer, ArrayList<Integer>>();
		 int m=1;
		 
		 for(int l=0;l<n;l++){
			 for(int p=0;p<n;p++){
				 if(board[l][p]==-1){
					 hm.putIfAbsent(m, new ArrayList<Integer>());
				 	 hm.get(m).add(l);
				 	 hm.get(m).add(p);
				 	 m++;
				 }
				 else{
					 hm.putIfAbsent(board[l][p], new ArrayList<Integer>());
					 hm.get(board[l][p]).add(l);
				 	 hm.get(board[l][p]).add(p);
				 }
		 }
		 
		 
		 int steps=0;   
		 Queue<Integer> queue=new LinkedList<Integer>();
		 queue.add(1);
	     boolean[][] isVisited=new boolean[board.length][board[0].length];
	     while(!queue.isEmpty()){
	    	 int size=queue.size();
	    	 for(int i=0;i<size;i++){
	    		 int x=queue.poll();
	    		 if(x==(board.length*board[0].length)) return steps;
	    		 for(int j=1;j<=6;j++){
	    			 if(j+x>board.length*board[0].length) break;
	    			int p[]=findCoordinates(j+x,board);
	    			 int r=p[0];
	    			 int c=p[1];
	    			 if(isVisited[r][c]==true) continue;
	    			 isVisited[r][c]=true;
	    			if(board[r][c]==-1)
	    				queue.add(j+x);
	    			else
	    				queue.add(board[r][c]);
	    		 }
	    	 }
	    	 steps++;
	     }
	       
	    }
		 return -1;
	 }
	 
 public static int[] findCoordinates(int current,int board[][]){
		 int r=board.length-((current-1)/board.length)-1;
		 int c=(board[0].length-1)%board.length;
		 
		 if(r%2 == c%2)
			 return new int[] {r,board[0].length-1-c};
		 else
			 return new int[] {r,c};
		 
	 }
	
	public static void main(String[] args) {
		int board[][]=new int[][]{
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}
	};
		System.out.println(snakesAndLadders(board));

}
}
