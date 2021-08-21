package Dynamic_Programming;
import java.util.*;

public class EggDropProblem {

	 static int eggDrop(int eggs, int floor) {
		int t[][]=new int[eggs+1][floor+1];
		for(int row[]:t)
			Arrays.fill(row, -1);
		return eggDropUtil(eggs, floor, t);
	 }
	 static int eggDropUtil(int eggs, int floor, int t[][]){
		 if(floor==0 || floor==1)
			 return floor;
		if(eggs==1)
			return floor;
		
		if(t[eggs][floor]!=-1)
			return t[eggs][floor];
		
		int minimum=Integer.MAX_VALUE;
		
		for(int k=1; k<=floor; k++){
			int breaking=0;
			int notbreaking=0;
			
			if(t[eggs-1][k-1]!=-1){
				breaking = t[eggs-1][k-1];
			}
			else{
				breaking=eggDropUtil(eggs-1, k-1, t);
				t[eggs-1][k-1]=breaking;
			}
			
			if(t[eggs][floor-k]!=-1){
				notbreaking=t[eggs][floor-k];
			}
			else{
				notbreaking=eggDropUtil(eggs, floor-k, t);
				t[eggs][floor-k]=notbreaking;
			}
			
			int temp=1+Math.max(breaking, notbreaking);
			minimum=Math.min(minimum, temp);		
		}
		return t[eggs][floor]=minimum;
	 }
	 
	 
	public static void main(String[] args) {
		int eggs=2;
		int floors=10;
		System.out.println(eggDrop(eggs, floors));
	}

}
