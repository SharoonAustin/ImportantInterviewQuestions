package Arrays;
import java.util.*;

public class FirstNonRepeatingCharacter {

	public static char firstNonRepeating(HashMap<Character,Integer> hmap, String str, Queue<Character> list){
		char ch='\0';
		
		for(int i=0;i<str.length();i++){
			if(!hmap.containsKey(str.charAt(i))){
				ch=str.charAt(i);
				hmap.put(str.charAt(i),1);
			}
			else{
				hmap.put(str.charAt(i),hmap.get(str.charAt(i)));
				System.out.println(list.element());
			}
			
		}
		return list.poll();
	}
	
	
	public static char firstNonRepeating(String str){
		
		for(int i=0;i<str.length();i++){
			if(str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i)))
				return str.charAt(i);
		}
		return '\0';
	}
	
	public static void main(String[] args) {
		
		HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
		Queue<Character> list=new LinkedList<Character>();
		String str="aaabcccedddf";
	//	System.out.println(firstNonRepeating(hmap,str,list));
		System.out.println(firstNonRepeating(str));
		 int v=2;
		 v += v++;
		 System.out.println(v);

	}

}
