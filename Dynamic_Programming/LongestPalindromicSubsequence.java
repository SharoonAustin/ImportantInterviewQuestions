package Dynamic_Programming;

public class LongestPalindromicSubsequence {

	  public int longestPalindromeSubseq(String s) {
	        StringBuffer sbuffer=new StringBuffer();
	        
	        for(int i=s.length()-1; i>=0; i--)
	            sbuffer.append(s.charAt(i));
	        
	        return LPS(s, sbuffer.toString(), s.length());
	        
	    }
	    
	    public static int LPS(String s1, String s2, int length){
	        int t[][]=new int[length+1][length+1];
	        
	        for(int i=1; i<=length; i++){
	            for(int j=1; j<=length; j++){
	                if(s1.charAt(i-1)==s2.charAt(j-1)){
	                	System.out.print(s1.charAt(i-1));
	                    t[i][j]=1+t[i-1][j-1];
	                }
	                
	                else
	                    t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
	                
	            }
	        }
	        System.out.println();
	        return t[length][length];
	    }
	
	public static void main(String[] args) {
		String s="bbbab";
		System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(s));
		
		
	}

}
