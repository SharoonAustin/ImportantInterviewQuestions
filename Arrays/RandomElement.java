package Arrays;
import java.util.*;
public class RandomElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("Sharoon");
		list.add("Ramesh");
		list.add("Rajesh");
		int m=(int)Math.floor(Math.random()*list.size());
		System.out.println(list.get(m));
		list.remove(m);

	}

}
