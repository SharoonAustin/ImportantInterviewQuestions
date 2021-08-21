package Graphs;
import java.util.*;

public class NQueenProblem {

	public void getQueen(int board[][], int i, HashSet<Integer> diagonal1, HashSet<Integer> diagonal2, HashSet<Integer> vertical){
		for(int j=0; j<board.length;j++){
			if(i==board.length){
				addToList(board);
				return ;
			}
			
			if(!diagonal1.contains(i+j) && !diagonal2.contains(j-i) && !vertical.contains(j)){
				board[i][j]=1;
				diagonal1.add(i+j);
				diagonal2.add(j-i);
				vertical.add(j);
				getQueen(board,i+1,diagonal1,diagonal2,vertical);
				board[i][j]=0;
				diagonal1.remove(i+j);
				diagonal2.remove(j-i);
				vertical.remove(j);
				
			}
			
		}
		
		
	}
	
	
	private void addToList(int[][] board) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j]==1)
					System.out.print(j+1+" ");
			}
	
		}
		System.out.println();
		}


	public static void main(String[] args) {
		NQueenProblem n1=new NQueenProblem();
		Scanner s1=new Scanner(System.in);
		int n=s1.nextInt();
		int board[][]=new int[n][n];
		n1.getQueen(board, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
		//System.out.println(list.toString());
	}

}
