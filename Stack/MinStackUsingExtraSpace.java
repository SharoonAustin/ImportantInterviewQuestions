package Stack;
import java.util.*;
public class MinStackUsingExtraSpace {
	
	Stack<Integer> stack=new Stack<Integer>();
	Stack<Integer> supportStack=new Stack<Integer>();
	
	public void push(int element){
		stack.push(element);
		if(supportStack.isEmpty() || supportStack.peek()>=element)
			supportStack.push(element);
	}
	
	public int pop(){
		if(stack.isEmpty())
			return -1;
		int ans=stack.pop();
		if(ans==supportStack.peek())
			supportStack.pop();
		return ans;
	}
	
	public int getMin(){
		if(supportStack.isEmpty())
			return -1;
		return supportStack.peek();
	}
	
	
	public static void main(String[] args) {
		MinStackUsingExtraSpace m1=new MinStackUsingExtraSpace();
		m1.push(18);
		m1.push(19);
		m1.push(29);
		m1.push(15);
		System.out.println(m1.getMin());
		m1.push(16);
		m1.pop();
		m1.pop();
		System.out.println(m1.getMin());
	}

}
