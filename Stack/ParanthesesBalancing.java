package Stack;
import java.util.*;
public class ParanthesesBalancing {

	Stack<Character> s1=new Stack<Character>();
	char c='/';
	public boolean isBalanced(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
				s1.push(str.charAt(i));
			
			else if(s1.isEmpty())
				return false;
			
			else{
				switch(str.charAt(i)){
				case ')':
					c=s1.pop();
					if(c=='[' || c=='{')
						return false;
					break;
				
				case ']':
					c=s1.pop();
					if(c=='(' || c=='{')
						return false;
					break;
					
				case '}':
					c=s1.pop();
					if(c=='[' || c=='(')
						return false;
					break;
				}
					
			}
			
		}
		return s1.isEmpty();
		
	}
	
	public static void main(String[] args) {
		String str="{(()())}";
		/*String input = "SOS";
		String sent="SOSSOT";
		int length=sent.length()/3;
		String newInput = new String(new char[length]).replace("\0", input);
		System.out.print(newInput);
		*/
		//System.out.print();
		ParanthesesBalancing b1=new ParanthesesBalancing();
		System.out.println(b1.isBalanced(str));
	}

}
