package Dynamic_Programming;
import java.util.*;

public class LongestCommonSubsequenceLengthUsingRecursion {

	public static int lengthOfLongestCommonSubsequence(String X, String Y, int N, int M){
		int t[][]=new int[M+1][N+1];
		for(int row[]:t)
			Arrays.fill(row, -1);
		return lengthOfLongestCommonSubsequenceUtil(X, Y, N, M, t);
	}
	
	public static int lengthOfLongestCommonSubsequenceUtil(String X, String Y, int N, int M, int t[][]){
		if(N==0 || M==0)
			return 0;
		
		if(t[N][M]!=-1)
			return t[M][N];
			
		
		if(X.charAt(N-1)==Y.charAt(M-1))
			return t[M][N]=1+lengthOfLongestCommonSubsequenceUtil(X, Y, N-1, M-1, t);
		
		else
			return t[M][N]=Math.max(lengthOfLongestCommonSubsequenceUtil(X, Y, N, M-1, t),
					lengthOfLongestCommonSubsequenceUtil(X, Y, N-1, M, t));
	}
	
	public static void main(String[] args) {
		String X="axc";
		String Y="ahbgdc";
		int N=X.length();
		int M=Y.length();
	
		System.out.println(lengthOfLongestCommonSubsequence(X, Y, N, M));
	}

}
