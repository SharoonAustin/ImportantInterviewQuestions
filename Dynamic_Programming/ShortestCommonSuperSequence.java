package Dynamic_Programming;
import java.util.*;
public class ShortestCommonSuperSequence {
	
	public static int shortestCommonSuperSequence(String X, String Y, int m, int n){
		int t[][]=new int[m+1][n+1];
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(X.charAt(i-1)==Y.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
			}
		}
		
		return m+n-t[m][n];
	}

	public static String shortestCommonSuperSequencePrint(String X, String Y, int m, int n){
		int t[][]=new int[m+1][n+1];
		StringBuffer sbuffer=new StringBuffer(); 
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(X.charAt(i-1)==Y.charAt(j-1)){
					t[i][j]=1+t[i-1][j-1];
				}
				else
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
			}
		}
		
		int i=m;
		int j=n;
		
		while(i>0 && j>0){
			if(X.charAt(i-1)==Y.charAt(j-1)){
				sbuffer.append(Y.charAt(j-1));
				i--;
				j--;
			}
			else{
				if(t[i-1][j]>t[i][j-1])
					i--;
				else
					j--;
			
			}
		}
		return sbuffer.reverse().toString();
	}
	
	public static void main(String[] args) {
		
		String X="geek";
		String Y="eke";
		int m=X.length();
		int n=Y.length();
		int lcsLength=shortestCommonSuperSequence(X, Y, m, n);
		System.out.println(shortestCommonSuperSequencePrint(X, Y, m, n));
	}

}
