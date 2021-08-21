package Tree;
import java.util.*;

public class SumOfLongestNode {
	static BinaryTreeNode root;
	static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	static int globalMax=0;
	static int Sum=0,rSum=0;
	
	Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
	static BinaryTreeNode temp;
	
	public void levelOrderTravesal(BinaryTreeNode root){
		q1.add(root);

		while(!q1.isEmpty()){
			temp=q1.poll();
			if(temp.left!=null)
				q1.add(temp.left);
			if(temp.right!=null)
				q1.add(temp.right);
		}
		System.out.println(sumOfLargest(root,temp));
	}
	
	public static int sumOfLargest(BinaryTreeNode root, BinaryTreeNode temp){
		if(root==null)
			return 0;
		
		if(root.key==temp.key)
			Sum=temp.key;
		sumOfLargest(root.left,temp);
		Sum+=root.key;
		sumOfLargest(root.right,temp);
		
		return Sum;
	}
	
	public static int largestSum(BinaryTreeNode root){
		if(root==null)
			return 0;
		
		else
			return Math.max(root.key+largestSum(root.left), root.key+largestSum(root.right));
	}

	
	
	public static void main(String[] args) {
		SumOfLongestNode b1=new SumOfLongestNode();
		
		b1.root=new BinaryTreeNode(4);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(5);
		
		b1.root.left.left=new BinaryTreeNode(7);
		b1.root.left.right=new BinaryTreeNode(1);
		b1.root.right.left=new BinaryTreeNode(2);
		b1.root.right.right=new BinaryTreeNode(3);
		
		b1.root.left.right.left=new BinaryTreeNode(6);
		System.out.println(b1.largestSum(b1.root));
		b1.levelOrderTravesal(b1.root);

	}

}
