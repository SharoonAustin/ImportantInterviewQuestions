package Dynamic_Programming;

public class RodCuttingProblem {

	public static int rodCuttingProblem(int N, int length[], int prices[]){
		int t[][]=new int[length.length+1][N+1];
		for(int i=0; i<length.length+1; i++){
			for(int j=0; j<N+1; j++){
				if(i==0 || j==0)
					t[i][j]=0;
			}
		}
		for(int i=1; i<length.length+1; i++){
			for(int j=1; j<N+1; j++){
				
				if(length[i-1]<=j)
					t[i][j]=Math.max(prices[i-1]+t[i][j-length[i-1]],t[i-1][j]);
				
				else
					t[i][j]=t[i-1][j];
				
			}
		}
		return t[length.length][N];
	}
	
	public static void main(String[] args) {
		int length[]={1, 2, 3, 4, 5, 6, 7, 8};
		int prices[]={1, 5, 8, 9, 10, 17, 17, 20};
		int N=4;
		System.out.print(rodCuttingProblem(N, length, prices));
	}

}
