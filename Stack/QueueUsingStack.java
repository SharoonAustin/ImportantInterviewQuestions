package Stack;
import java.util.*;
public class QueueUsingStack {

	public static void push(Stack<Integer> s1, int x){
		s1.push(x);
	}
	
	public static int pop(Stack<Integer> s1, Stack<Integer> s2){
		 if(s1.isEmpty())
			    return -1;
			   
			   while(s1.size()!=1)
			    s2.push(s1.pop());
			   
			   int result=s1.pop();
			   
			   while(!s2.isEmpty())
			       s1.push(s2.pop());
			   
			   return result;
	}

	public static void main(String[] args) {
		Stack<Integer> s1=new Stack<Integer>();
		Stack<Integer> s2=new Stack<Integer>();
		

	}

}
