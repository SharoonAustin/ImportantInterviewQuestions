package Tree;
import java.util.*;

public class RightViewOfBinaryTree {
	BinaryTreeNode root;
	static HashMap<Integer,BinaryTreeNode> hm= new HashMap<Integer,BinaryTreeNode>();
	
	public void rigthView(BinaryTreeNode root){
		hm.put(0, root);
		travelForRightView(0, root);
		
		for(int i=0; i<hm.size();i++){
			System.out.print(hm.get(i).key+" ");
		}
		
	}
	
	public static void travelForRightView(int distance, BinaryTreeNode root){
		if(root==null)
			return;

		if(root.left!=null){
			hm.put(distance+1,root.left);
			travelForRightView(distance+1,root.left);
		}
		
		if(root.right!=null)
			hm.put(distance+1,root.right);
			travelForRightView(distance+1,root.right);

	}
	
	
	public static void main(String[] args) {
		RightViewOfBinaryTree b1=new RightViewOfBinaryTree();
		
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.right.left=new BinaryTreeNode(6);
		b1.root.right.right=new BinaryTreeNode(7);
		b1.rigthView(b1.root);
	}

}
