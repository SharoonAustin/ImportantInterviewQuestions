package Arrays;
import java.util.*;

public class MaximumLengthOfStringWithoutRepeatingCharacters {

	public static int maxiMumLengthOfTheString(String str){
		int i=0,j=0;
		int maxSum=0;
		HashSet<Character> hset=new HashSet<Character>();
		
		while(j<str.length()){
			if(!hset.contains(str.charAt(j))){
				hset.add(str.charAt(j));
				j++;
			}
			else{
				maxSum=Math.max(maxSum, hset.size());
				i++;
				j=i;
				hset.clear();
			}
			maxSum=Math.max(maxSum, hset.size());
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		System.out.println(maxiMumLengthOfTheString("dvdf"));
		
	}

}
