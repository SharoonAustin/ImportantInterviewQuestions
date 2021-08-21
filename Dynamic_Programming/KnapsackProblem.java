package Dynamic_Programming;
import java.util.*;
public class KnapsackProblem {

static int[][] t = new int[1001][1001];
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        for (int[] row : t)
        	Arrays.fill(row, -1);
        
        return answer(W, wt, val, n);
    }
    
    static int answer(int W, int[] wt, int[] val, int n)
    {
        if(n == 0 || W == 0)
            return 0;
        
        if(t[n][W] != -1)
            return t[n][W];
        
        if(wt[n-1] <= W)
            return t[n][W] = Math.max(val[n-1] + answer(W - wt[n-1], wt, val, n - 1)
                            , answer(W, wt, val, n-1));
        
        else if(wt[n-1] > W)
        	return t[n][W] = answer(W, wt, val, n-1);
        
        return 0;
    } 
    
	public static void main(String[] args) {
		int weight[]= {1, 3, 4, 5};
		int value[]= {1, 4, 5, 7};	
		
		System.out.println(knapSack(3,weight,value,weight.length));
	}

}
