package Dynamic_Programming;
import java.util.*;



public class ScrambledStrings {
	static HashMap<String, Boolean> hmap=new HashMap<String, Boolean>();
	public static boolean isScramble(String a, String b){
	
		int n=a.length();
		boolean flag=false;
		
		String key = a + ":" + b;
		
		if(hmap.containsKey(key))
			return hmap.get(key);
		
		if(a.compareTo(b)==0){
			hmap.put(key,true);
			return true;
		}
		
		if(a.length()<=1)
			return false;
		
		for(int i=1; i<n; i++){
			boolean condition1=isScramble(a.substring(0,i),b.substring(n-i)) && isScramble(a.substring(i,n),b.substring(0,n-i));
			boolean condition2=isScramble(a.substring(0,i),b.substring(0,i)) && isScramble(a.substring(i,n),b.substring(i,n));
			
			if(condition1 || condition2){
				flag=true;
				break;
			}
		}
		hmap.put(key, flag);
		return flag;
	}
	
	public static void main(String[] args) {
		String a="bomb";
		String b="mobb";
		if(a.length()!=b.length())
			System.out.println(false);
		if(a.length()==0 && b.length()==0)
			System.out.println(true);
		else
			System.out.println(isScramble(a, b));
	}

}
