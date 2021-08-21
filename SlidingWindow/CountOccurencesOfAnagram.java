package SlidingWindow;

import java.util.*;

public class CountOccurencesOfAnagram {

	public static int getMax(String X, HashMap<Character, Integer> hmap, int K){
		int i=0,j=0,size=hmap.size(),count=0,temp=K;
		while(j<X.length()){
			
			if(hmap.containsKey(X.charAt(j))){
				if(hmap.get(X.charAt(j))!=-1)
					hmap.put(X.charAt(j), hmap.get(X.charAt(j))-1);
				if(hmap.get(X.charAt(j))==0)
					size--;
				temp--;
			}
			
			if(temp==0){
				if(size==0)
					count++;
				if(hmap.containsKey(X.charAt(i))){
					hmap.put(X.charAt(i), hmap.get(X.charAt(i))+1);
					size++;
					}
				i++;
				temp=1;
			}
			j++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String X="aabaabaa";
		String txt="aaba";
		Stack<Integer> stack=new Stack<Integer>();
		//stack.pus
		HashMap<Character, Integer> hmap=new HashMap<Character, Integer>();
		
		for(int i=0; i<txt.length(); i++){
			if(hmap.containsKey(txt.charAt(i)))
				hmap.put(txt.charAt(i), hmap.get(txt.charAt(i))+1);
			else
				hmap.put(txt.charAt(i), 1);
		}
		System.out.println(getMax(X, hmap,txt.length()));
	}

}
