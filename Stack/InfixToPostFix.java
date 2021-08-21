package Stack;
import java.util.*;
public class InfixToPostFix {

	public void convert(String str){
		Stack<Character> stack=new Stack<Character>();
		char arr[]=new char[str.length()];
		int i=0,j=0;
		while(i<str.length()){
			if(isOperand(str.charAt(i))){
				stack.push(str.charAt(i));
				i++;
			}
			else{
				if(!stack.isEmpty() && (precedenceOrder(str.charAt(i))>precedenceOrder(stack.peek()))){
					stack.push(str.charAt(i));
					i++;
				}
				else if(stack.isEmpty()){
					stack.push(str.charAt(i));
					i++;
				}

				else{
					char temp=stack.pop();
					arr[j]=temp;
					j++;
				}
			}
		}
		while(!stack.isEmpty()){
			arr[j++]=stack.pop();
		}
		
		for(int k=0;k<arr.length;k++)
			System.out.print((char)arr[k]);
	}
	
	public static boolean isOperand(char x){
		if(x=='+' || x=='-' || x=='*' || x=='/')
			return false;
		else
			return true;	
	}
	
	public static int precedenceOrder(char x){
		if(x=='+' || x=='-')
			return 1;
		else if(x=='*' || x=='/')
			return 2;
		
		else if(x=='^')
			return 3;
		
		else if(x=='(' || x==')')
			return 4;
		else
			return 5;
	}
	
	
	public static void main(String[] args) {
		InfixToPostFix i1=new InfixToPostFix();
		String str="a+b*(c^d-e)^(f+g*h)-i";
		i1.convert(str);
	}

}
