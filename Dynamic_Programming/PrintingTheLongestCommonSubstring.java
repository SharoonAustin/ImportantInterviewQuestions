package Dynamic_Programming;

public class PrintingTheLongestCommonSubstring {

	public static String printTheLongestCommonSubString(String X, String Y, int Xlength, int Ylength){
		int maxlen = 0;        
        int endingIndex = Xlength; 
       
        int[][] t = new int[Xlength + 1][Ylength + 1];
 
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= Xlength; i++){
            for (int j = 1; j <= Ylength; j++){
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    if (t[i][j] > maxlen){
                        maxlen = t[i][j];
                        endingIndex = i;
                    }
                }
            }
        }
        return X.substring(endingIndex - maxlen, endingIndex);
	}
	
	public static void main(String[] args) {
		String X="ABCDGH";
		String Y="ACDGHR";
		int Ylength=Y.length();
		int Xlength=X.length();
		System.out.print(printTheLongestCommonSubString(X, Y, Xlength, Ylength));
	}

}
