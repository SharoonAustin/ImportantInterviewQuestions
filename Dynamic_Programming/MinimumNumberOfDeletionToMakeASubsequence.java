package Dynamic_Programming;
import java.util.*;
public class MinimumNumberOfDeletionToMakeASubsequence {

	public static int LPS(String s1){
		StringBuffer sbuffer=new StringBuffer();
		for(int i=s1.length()-1; i>=0; i--){
			sbuffer.append(s1.charAt(i));
		}
		return s1.length()-LPSUtil(s1, sbuffer.toString(), s1.length());
	}
	
	public static int LPSUtil(String s1, String s2, int length){
		int t[][]=new int [length+1][length+1];
		
		for(int i=1; i<=length; i++){
			for(int j=1; j<=length; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		return t[length][length];
	}
	
	public static void main(String[] args) {
		String s1="hbjeausdwetcoigruoczwvlfxjvygtpnuatvulatsuxie";
		System.out.print(LPS(s1));
		
	}

}
