package Dynamic_Programming;

import java.util.Arrays;

public class SequencePatternMatching {

	/*public static int sequenceMatching(String X, String Y, int xLength, int yLength){
		int t[][]=new int[yLength+1][xLength+1];
		
		for(int i=1; i<yLength+1; i++){
			for(int j=1; j<xLength+1; j++){
				if(X.charAt(xLength-1)==Y.charAt(yLength-1))
					t[i][j]=1+t[i-1][j-1];
				else
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
			}
		}
		
		return t[yLength][xLength];
	}*/
	public static int lengthOfLongestCommonSubsequence(String X, String Y, int xLength, int yLength){
		int t[][]=new int[yLength+1][xLength+1];
		for(int row[]:t)
			Arrays.fill(row, -1);
		return lengthOfLongestCommonSubsequenceUtil(X, Y, xLength, yLength, t);
	}
	
	public static int lengthOfLongestCommonSubsequenceUtil(String X, String Y, int xLength, int yLength, int t[][]){
		if(xLength==0 || yLength==0)
			return 0;
		
		if(t[yLength][xLength]!=-1)
			return t[yLength][xLength];
			
		
		if(X.charAt(xLength-1)==Y.charAt(yLength-1))
			return t[yLength][xLength]=1+lengthOfLongestCommonSubsequenceUtil(X, Y, xLength-1, yLength-1, t);
		
		else
			return t[yLength][xLength]=Math.max(lengthOfLongestCommonSubsequenceUtil(X, Y, xLength, yLength-1, t),
					lengthOfLongestCommonSubsequenceUtil(X, Y, xLength-1, yLength, t));
	}
	
	
	public static void main(String[] args) {
	String X="axc";
	String Y="ahbgdc";
	System.out.println(lengthOfLongestCommonSubsequence(X, Y, X.length(), Y.length()));
	
	}

}
