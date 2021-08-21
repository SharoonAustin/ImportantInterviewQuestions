package Dynamic_Programming;

public class PrintShortestCommonSuperSequence {
	
	public static String LCS(String X, String Y, int length1, int length2){
		int t[][]=new int[length1+1][length2+1];
		StringBuffer sb=new StringBuffer();

		for(int i=1; i<=length1; i++){
			for(int j=1; j<=length2; j++){
				if(X.charAt(i-1)==Y.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		int i=length1;
		int j=length2;
		while(i>0 && j>0){
			if(X.charAt(i-1)==Y.charAt(j-1)){
				sb.append(Y.charAt(j-1));
				i--;
				j--;
			}
			else{
				if(t[i-1][j]>t[i][j-1]){
					sb.append(X.charAt(i-1));
					i--;
				}
				else{
					sb.append(Y.charAt(j-1));
					j--;
				}
			}
		}
		
		while(i>0){
			sb.append(X.charAt(i-1));
			i--;
		}
		while(j>0){
			sb.append(Y.charAt(j-1));
			j--;
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		 String X = "HELLO",  Y = "GEEK";	 
		 System.out.println(LCS(X, Y, X.length(), Y.length()));
	}
}
