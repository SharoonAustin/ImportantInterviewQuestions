package Dynamic_Programming;

public class LongestCommonSubString {
	
	public static int longestCommonSubString(String X, String Y, int Xlength, int yLength, int t[][]){
		int max=0;
		for(int i=1; i<yLength+1; i++){
			for(int j=1; j<Xlength+1; j++){
				if(X.charAt(j-1)==Y.charAt(i-1)){
					t[i][j]=t[i-1][j-1]+1;
					max=Math.max(max, t[i][j]);
				}
				
				else
					t[i][j]=0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
	
		String X="ABCDGH";
		String Y="ACDGHR";
		int xLength=X.length();
		int yLength=Y.length();
		int t[][]=new int[yLength+1][xLength+1];
		System.out.println(longestCommonSubString(X, Y, xLength, yLength, t));
		
		
		
	}

}
