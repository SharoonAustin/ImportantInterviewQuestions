package Tree;
import java.util.*;

public class RootToLeafPath {

	BinaryTreeNode root;
	static int globalSum=0;
	static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	
	public static void calculateTreeSum(BinaryTreeNode root){
		hm.clear();
		globalSum=0;
		hm.put(0,root.key);
		travel(0,root);
	}
	
	public static void printTheTreeSum(HashMap<Integer,Integer> hm){
		int sum=0;
		for(Map.Entry<Integer,Integer> element:hm.entrySet()){
			sum+=element.getValue();
		}
		globalSum=Math.max(sum, globalSum);
			for(Map.Entry<Integer,Integer> element:hm.entrySet())
				System.out.print(element.getValue()+" ");
			System.out.print(sum+"\n");
	}
	

	public static void travel(int distance,BinaryTreeNode root){
		if(root==null){
			return ;
		}
		if(root.left==null && root.right==null){
			printTheTreeSum(hm);
		}
			
		if(root.left!=null){
			hm.put(distance+1,root.left.key);
			travel(distance+1,root.left);
		}
		if(root.right!=null){
			hm.put(distance+1,root.right.key);
			travel(distance+1,root.right);
		}
			
	}
	
	public static void main(String[] args) {
		RootToLeafPath b1=new RootToLeafPath();
		b1.root=new BinaryTreeNode(10);
		
		b1.root.left=new BinaryTreeNode(8);
		b1.root.left.left=new BinaryTreeNode(3);
		b1.root.left.right=new BinaryTreeNode(5);
		
		b1.root.right=new BinaryTreeNode(2);
		b1.root.right.left=new BinaryTreeNode(2);
		b1.calculateTreeSum(b1.root);
		System.out.println("Maximum Sum is : "+globalSum);
	}

}
