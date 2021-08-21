package Dynamic_Programming;

public class MinimumNumberOfInsertionOrDeletion {

	public int minOperations(String str1, String str2) 
	{ 
	    int lcs=LCS(str1, str2, str1.length(), str2.length());
	    int deletion=str1.length()-lcs;
	    int insertion=str2.length()-lcs;
	    
	    return insertion+deletion;
	} 
	
	public int LCS(String s1, String s2, int length1, int length2){
	    int t[][]=new int[length1+1][length2+1];
	    
	    for(int i=1; i<=length1; i++){
	        for(int j=1; j<=length2; j++){
	            if(s1.charAt(i-1)==s2.charAt(j-1))
	                t[i][j]=1+t[i-1][j-1];
	            
	            else
	                t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
	        }
	    }
	    
	    return t[length1][length2];
	}
	public static void main(String[] args) {
		String str1 = "Anshuman", str2 = "Antihuman";
		System.out.print(new MinimumNumberOfInsertionOrDeletion().minOperations(str1, str2));

	}

}
