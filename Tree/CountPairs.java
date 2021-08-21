package Tree;
import java.util.*;

public class CountPairs {
	BinaryTreeNode root;
	 
	public static int countPairs(BinaryTreeNode root1, BinaryTreeNode root2, int x)
	    {
	        int count=0;
	        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
	        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
	        storeTheTree(root1,h1);
	        storeTheTree(root2,h2);
	        
	       for (Map.Entry mapElement : h1.entrySet()){
	           if(h2.containsKey(x-(Integer)mapElement.getKey()))
	            count++;
	       } 
	    return count;      
	    }
	 
	    public static void storeTheTree(BinaryTreeNode root,HashMap<Integer,Integer> h1){
	        if(root==null)
	            return;
	        storeTheTree(root.left,h1);
	        h1.put(root.key,root.key);
	        storeTheTree(root.right,h1);
	    }
	    
	public static void main(String[] args) {
		CountPairs c1=new CountPairs();
		c1.root=new BinaryTreeNode(5);
		c1.root.left=new BinaryTreeNode(3);
		c1.root.right=new BinaryTreeNode(7);
		c1.root.left.left=new BinaryTreeNode(2);
		c1.root.left.right=new BinaryTreeNode(4);
		c1.root.right.left=new BinaryTreeNode(6);
		c1.root.right.right=new BinaryTreeNode(8);
		
		CountPairs c2=new CountPairs();
		c2.root=new BinaryTreeNode(10);
		c2.root.left=new BinaryTreeNode(6);
		c2.root.right=new BinaryTreeNode(15);
		c2.root.left.left=new BinaryTreeNode(3);
		c2.root.left.right=new BinaryTreeNode(8);
		c2.root.right.left=new BinaryTreeNode(11);
		c2.root.right.right=new BinaryTreeNode(18);

		int output=countPairs(c1.root,c2.root,16);
		System.out.print(output);
	}

}
