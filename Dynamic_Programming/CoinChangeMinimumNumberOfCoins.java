package Dynamic_Programming;

public class CoinChangeMinimumNumberOfCoins {
	
	public static int minNumberOfCoins(int coin[], int sum, int N){
		int totalSum=0;
		int returningValue=0;
		
		for(int i=0; i<coin.length; i++) {
			totalSum+=coin[i];
			returningValue++;
		}
		
		int row=N+1;
		    int column=sum+1;
		    
		    int dp[][]=new int[row][column];
					
			//Initialization first row and first column;
			for(int i=0; i<row;i++){
				for(int j=0; j<column; j++){
					if(i==0)
						dp[i][j]=Integer.MAX_VALUE-1;
				}
			}
			
			
			
			  for (int i=1; i<row; i++) {
	            for (int j=1; j<column; j++) {
	                if (j<coin[i-1]) {
	                    dp[i][j] = dp[i-1][j];
	                } else {
	                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i-1][j-coin[i-1]]);
	                }
	            }
	        }
			  
			if (dp[row-1][column-1] == Integer.MAX_VALUE-1) {
				if(totalSum>=sum)
					return returningValue;
				else
					return -1;
			}
	       
	        else
	            return dp[row-1][column-1];
	}
	
	
	
	public static void main(String[] args) {
		int coins[]={5, 1, 2, 3, 4};
		int sum=13;
		int N=coins.length;
		System.out.println(minNumberOfCoins(coins, sum, N));
	}

}
