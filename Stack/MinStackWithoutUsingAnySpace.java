package Stack;
import java.util.*;
public class MinStackWithoutUsingAnySpace {
	
	Stack<Integer> stack=new Stack<Integer>();
	int minimum=Integer.MAX_VALUE;
	
	public void push(int element){
		if(stack.isEmpty()){
			minimum=element;
			stack.push(element);
		}
		if(element>stack.peek())
			stack.push(element);
		
		else{
		int calculation=((2*element)-minimum);	
		stack.push(calculation);
		minimum=element;
		}	
	}
	
	public void pop(){
		if(stack.peek()>=minimum)
			stack.pop();
		else{
			minimum=(2*minimum)-stack.pop();
		}
	}
	
	public int getMinimum(){
		if(stack.isEmpty() || stack.size()==1)
			return -1;
		return minimum;
	}
	
	public int top(){
		if(stack.peek()>=minimum)
			return stack.peek();
		
		else if(stack.peek()<minimum)
			return minimum;
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		MinStackWithoutUsingAnySpace m1=new MinStackWithoutUsingAnySpace();
		m1.push(10);
		m1.push(9);
		System.out.print(m1.getMinimum()+" ");
		m1.push(8);
		System.out.print(m1.getMinimum()+" ");
		m1.push(7);
		System.out.print(m1.getMinimum()+" ");
		m1.push(6);
		System.out.print(m1.getMinimum()+" ");
		m1.pop();
		System.out.print(m1.getMinimum()+" ");
		m1.pop();
		System.out.print(m1.getMinimum()+" ");
		m1.pop();
		System.out.print(m1.getMinimum()+" ");
		m1.pop();
		System.out.print(m1.getMinimum()+" ");
		m1.pop();
		System.out.print(m1.getMinimum()+" ");

	}

}
