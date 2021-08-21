package Tree;
import java.util.*;

public class MinimumDistanceBetweenTwoNodes {
	BinaryTreeNode root;
	static int distanceFromLCA=0;
	static HashMap<Integer,BinaryTreeNode> hm=new HashMap<Integer,BinaryTreeNode>();
	
	public static int caculateTheDistance(BinaryTreeNode root, int a, int b){
		hm.clear();
		BinaryTreeNode Node=getLCA(root, a, b);
		hm.put(0,Node);
		int distanceOfA=travel(0,Node,a);
		distanceFromLCA=0;
		int distanceOfB=travel(0,Node,b);
		return distanceOfA+distanceOfB;
	}
	
	public static int travel(int distance, BinaryTreeNode root,int data){
		if(root==null)
			return 0;
	
		if(hm.get(distance).key==data)
			distanceFromLCA=distance;
		
		if(root.left!=null){
			hm.put(distance+1, root.left);
			travel(distance+1, root.left,data);
		}
		if(root.right!=null){
			hm.put(distance+1, root.right);
			travel(distance+1, root.right,data);
		}
		return distanceFromLCA;
	}
	
	public static BinaryTreeNode getLCA(BinaryTreeNode root, int n1, int n2){
		if(root==null)
			return null;
		
		if(root.key==n1 || root.key==n2)
	        return root;
	   
		BinaryTreeNode l=getLCA(root.left,n1,n2);
		BinaryTreeNode r=getLCA(root.right,n1,n2);
	    
	    if(l!=null && r!=null)
	        return root;
	        
	    if(l!=null)
	        return l;
	    
	    if(r!=null)
	        return r;
	  
	    else
	        return null;
	}
	
	public static void main(String[] args) {
		
		MinimumDistanceBetweenTwoNodes b1=new MinimumDistanceBetweenTwoNodes();
		
		b1.root=new BinaryTreeNode(8);
		b1.root.left=new BinaryTreeNode(6);
		b1.root.right=new BinaryTreeNode(69);
		
		b1.root.left.left=new BinaryTreeNode(1);
		b1.root.left.right=new BinaryTreeNode(7);
		b1.root.right.left=new BinaryTreeNode(29);
		b1.root.right.right=new BinaryTreeNode(80);
		
		b1.root.left.left.right=new BinaryTreeNode(4);
		b1.root.right.left.left=new BinaryTreeNode(15);
		b1.root.right.left.right=new BinaryTreeNode(31);
		b1.root.right.right.left=new BinaryTreeNode(75);
		b1.root.right.right.right=new BinaryTreeNode(96);
		
		
		b1.root.left.left.right.left=new BinaryTreeNode(3);
		b1.root.left.left.right.right=new BinaryTreeNode(5);
		b1.root.right.left.left.left=new BinaryTreeNode(10);
		b1.root.right.left.left.right=new BinaryTreeNode(21);
		b1.root.right.left.right.left=new BinaryTreeNode(30);
		b1.root.right.left.right.right=new BinaryTreeNode(57);
		b1.root.right.right.left.left=new BinaryTreeNode(71);
		b1.root.right.right.left.right=new BinaryTreeNode(78);
		b1.root.right.right.right.left=new BinaryTreeNode(92);
		b1.root.right.right.right.right=new BinaryTreeNode(97);
		
		System.out.println(b1.caculateTheDistance(b1.root, 96, 97));
	}

}
