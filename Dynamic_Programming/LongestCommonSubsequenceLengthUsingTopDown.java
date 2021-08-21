package Dynamic_Programming;

public class LongestCommonSubsequenceLengthUsingTopDown {
	
	public static int LCS(String X, String Y, int xLength, int yLength, int t[][]){
		for(int i=1; i<yLength+1; i++){
			for(int j=1; j<xLength+1; j++){
				if(X.charAt(j-1)==Y.charAt(i-1)){
					System.out.print(X.charAt(j-1));
					t[i][j]=t[i-1][j-1]+1;
				}
				
				else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
				
			}
		}
		System.out.println();
		return t[yLength][xLength];
	}
	
	public static void main(String[] args) {
		String X="ABCDGH";
		String Y="AEDFHR";
		
		int xLength=X.length();
		int yLength=Y.length();
		
		int t[][]=new int[yLength+1][xLength+1];
		System.out.println(LCS(X, Y, xLength, yLength, t));
		
	}

}
