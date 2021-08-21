package Stack;
import java.util.*;
public class StackUsingQueue {
	
	public static void push(Queue<Integer> q1, int element){
		q1.add(element);
	}
	
	public static int pop(Queue<Integer> q1, Queue<Integer> q2){
		 if(q1.isEmpty())
				return -1;
		    
		   while(q1.size()!=1){
		       int x=q1.poll();
		       q2.add(x);
		   }
		   int result=q1.poll();
		   
		   while(!q2.isEmpty()){
		       int temp=q2.poll();
		       q1.add(temp);
		   }
		    return result;
		    
		    //POP USING SINGLE QUEUE
		   /* if(q1.isEmpty())
				return -1;
		    
		   for(int i=0; i<q1.size()-1; i++)
		       q1.add(q1.poll());
		       
		    return q1.poll();*/
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();
		//System.out.println(pop(q1, q2));
		push(q1, 2);
		push(q1, 3);
		push(q1, 3);
		System.out.println(pop(q1, q2));
		push(q1, 2);
		System.out.println(pop(q1, q2));
		
	}

}
