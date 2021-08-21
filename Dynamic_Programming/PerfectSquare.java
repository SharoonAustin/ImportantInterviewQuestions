package Dynamic_Programming;
import java.util.*;
public class PerfectSquare {
	public int MinSquares(int n)
    {
      int dp[]=new int[n+1];
      return MinSquaresUtil(n, dp);
    }
	
	public static int MinSquaresUtil(int n, int dp[])
    {
		for(int i=0; i<=n; i++)
			dp[i]=i;
		
		if(n<=3)
			return dp[n];
	     	     
	     for(int i=4; i<=n; i++) {
	    	 for(int j=1; j*j<=i; j++) {
	    		 dp[i]=Math.min(dp[i], 1+dp[i-j*j]);
	     }
	     }
	    return dp[n]; 
    }
	
	public static void main(String args[]) {
		
		System.out.println(new PerfectSquare().MinSquares(13));
	}
}
