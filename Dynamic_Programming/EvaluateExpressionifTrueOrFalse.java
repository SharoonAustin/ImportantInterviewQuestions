package Dynamic_Programming;

public class EvaluateExpressionifTrueOrFalse {

	public static int evaluateExpression(String S, int i, int j, boolean isTrue){
		if(i>j)
			return 0;
		if(i==j){
			
		}
			return 0;
		
	}
	
	public static void main(String[] args) {
		String s1="T|T&F^T";
		evaluateExpression(s1, 0, s1.length()-1, true);
	}

}
