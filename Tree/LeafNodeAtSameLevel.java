package Tree;
import java.util.*;

public class LeafNodeAtSameLevel {
	BinaryTreeNode root;
	static HashMap<Integer,Integer> leftLeaf=new HashMap<Integer,Integer>();
	static HashMap<Integer,Integer> rightLeaf=new HashMap<Integer,Integer>();

	public boolean sameLevel(BinaryTreeNode root){
		leftLeaf.clear();
        rightLeaf.clear();
       
        if(root.left!=null)
			travelLeft(1,root.left);
			
		if(root.right!=null)
			travelRight(1,root.right);
			
		if(!leftLeaf.isEmpty() && !rightLeaf.isEmpty())
			return (leftLeaf.keySet().equals(rightLeaf.keySet()));
		
	   	else if(!leftLeaf.isEmpty() && rightLeaf.isEmpty())
	   	    if(leftLeaf.size()>1)
	   	        return false;
	   	    else
	   	        return true;
	   	
        else if(!rightLeaf.isEmpty() && leftLeaf.isEmpty())
	   	    if(rightLeaf.size()>1)
	   	        return false;
	   	    else
	   	        return true;
	   	
	   	else
	   	    return true;
	}

//2910 7670 N 712 4700 N 8459 2271 N 332 8570 N 7403 8390 N 9496 8400 N 8771 6683 N 1647 440 N 1979 1254

	
	public static void travelLeft(int distance,BinaryTreeNode root){
		if(root==null)
			return ;
		
		else if(root.left==null && root.right==null){
			leftLeaf.put(distance,root.key);
		}
		
		else{
			if(root.left!=null)
				travelLeft(distance+1,root.left);
			if(root.right!=null)
				travelLeft(distance+1,root.right);
		}
	}
	
	public static void travelRight(int distance,BinaryTreeNode root){
		if(root==null)
			return ;
		
		else if(root.left==null && root.right==null){
			rightLeaf.put(distance,root.key);
		}
		
		else{
			if(root.left!=null)
				travelRight(distance+1,root.left);
			if(root.right!=null)
				travelRight(distance+1,root.right);
		}
	}
	
	
	public static void main(String[] args) {
		LeafNodeAtSameLevel b1=new LeafNodeAtSameLevel();
		b1.root=new BinaryTreeNode(10);
		b1.root.left=new BinaryTreeNode(20);
		b1.root.left.left=new BinaryTreeNode(40);
		b1.root.left.right=new BinaryTreeNode(60);

		System.out.print(b1.sameLevel(b1.root));

	}

}
