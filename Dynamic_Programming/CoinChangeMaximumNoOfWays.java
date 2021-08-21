package Dynamic_Programming;

public class CoinChangeMaximumNoOfWays {

	public static int coinChange(int coins[], int sum, int N){
		int t[][]=new int[N+1][sum+1];
		for(int i=0; i<N+1; i++){
			for(int j=0; j<sum+1; j++){
				if(i==0)
					t[i][j]=0;
				if(j==0)
					t[i][j]=1;
			}
		}
		
		for(int i=1; i<N+1; i++){
			for(int j=1; j<sum+1; j++){
				
				if(coins[i-1]<=j)
					t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
				
				else
					t[i][j]=t[i-1][j];
				
			}
		}
		return t[N][sum];
	}
	
	public static void main(String[] args) {
		int coins[]={3,5,10};
		int sum=8;
		int N=coins.length;

	System.out.println(new CoinChangeMaximumNoOfWays().coinChange(coins, sum, N));
	}
	}
