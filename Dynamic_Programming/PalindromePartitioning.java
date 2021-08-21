package Dynamic_Programming;
import java.util.*;
public class PalindromePartitioning {
	
	
	public static int palindromePartition(String S, int i, int j, int t[][]){
		if(i>=j || isPalindrome(S, i, j))
			return 0;
		if(t[i][j]!=-1)
			return t[i][j];
		
		int min = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++){
			int left=0;
			int right=0;
			
			if(t[i][k]!=-1)
				left=t[i][k];
			else{
				left=palindromePartition(S, i, k, t);
				t[i][k]=left;
			}
			
			if(t[k+1][j]!=-1)
				right=t[k+1][j];
			else{
				right=palindromePartition(S, k+1, j, t);
				t[k+1][j]=right;
			}
				
			//int temp=1+palindromePartition(S, i, k, t) + palindromePartition(S, k+1, j, t);
			int temp=1+ left + right;
			min=Math.min(min, temp);
		}
		return t[i][j]=min;
	}
	
	public static boolean isPalindrome(String X, int i, int j)
    {
		ArrayList<Character> list=new ArrayList<Character>();
        while (i <= j) {
            if (X.charAt(i++) != X.charAt(j--)) {
                return false;
            }
        	list.add(X.charAt(i));
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s="abracadabra";
		int t[][]=new int[s.length()+1][s.length()+1];
		for(int row[]: t)
			Arrays.fill(row, -1);
	
		System.out.println(palindromePartition(s, 0, s.length()-1, t));
	}

}
