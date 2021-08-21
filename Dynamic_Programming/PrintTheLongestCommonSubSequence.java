package Dynamic_Programming;
import java.util.*;
public class PrintTheLongestCommonSubSequence {
	
	public static String printTheLongestCommonSubSequence(String X, String Y, int XLength, int YLength, int t[][]){
		
		StringBuffer sBuffer=new StringBuffer();
	
		//Logic for the Matrix;
		for(int i=1; i<YLength+1; i++){
			for(int j=1; j<XLength+1; j++){
				if(Y.charAt(i-1)==X.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		int i=YLength;
		int j=XLength;
		
		while(i>0 && j>0){
			if(Y.charAt(i-1)==X.charAt(j-1)){
				sBuffer.append(Y.charAt(i-1));
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
	
		return sBuffer.reverse().toString();
	}
	
	
	public static void main(String[] args) {
		String X = "AGGTAB"; 
        String Y = "GXTXAYB"; 
		int YLength=Y.length();
		int XLength=X.length();
		int t[][]=new int[YLength+1][XLength+1];
		
		System.out.print(printTheLongestCommonSubSequence(X, Y, XLength, YLength, t));
		
	}

}
