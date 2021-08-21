package Dynamic_Programming;

public class LongestRepeatingSubsequence {
	
	public static int LRS(String X, String Y, int length1, int length2){
		int t[][]=new int[length1+1][length2+1];
		StringBuffer sb=new StringBuffer();

		for(int i=1; i<=length1; i++){
			for(int j=1; j<=length2; j++){
				if(X.charAt(i-1)==Y.charAt(j-1) && i!=j)
					t[i][j]=1+t[i-1][j-1];
				else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		return t[length1][length2];
	}
	
	public static void main(String[] args) {
		String s1="aabebcddf";
		String s2=s1;
		System.out.println(LRS(s1, s2, s1.length(), s2.length()));

	}

}
