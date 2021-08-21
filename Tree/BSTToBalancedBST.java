package Tree;
import java.util.*;
public class BSTToBalancedBST {
	
	BinaryTreeNode root;
	static ArrayList<Integer> l1=new ArrayList<Integer>();
	
	public void addToTheList(BinaryTreeNode root){
		if(root==null)
			return;
		addToTheList(root.left);
		l1.add(root.key);
		addToTheList(root.right);
	}
	
	public BinaryTreeNode bstToBalancedBST(ArrayList<Integer> l1, int start,int end){
		int element,index;
		
		if(start>end)
			return null;
		
		if(start!=end){
		index=start + ((end - start)/2);
		element =l1.get(index);
		}
		
		else{
			element =l1.get(end);
			index=end;
		}
		BinaryTreeNode tnode=new BinaryTreeNode(element);
		
		/* if (start == end) 
	            return tnode;*/
		 
		tnode.left=bstToBalancedBST(l1,start,index-1);
		tnode.right=bstToBalancedBST(l1, index+1, end);
		
		return tnode;
	}
	
	
	public static void main(String[] args) {
		BSTToBalancedBST b1=new BSTToBalancedBST();
		b1.root=new BinaryTreeNode(10);
		b1.root.left=new BinaryTreeNode(20);
		b1.root.left.left=new BinaryTreeNode(30);
		b1.root.right=new BinaryTreeNode(40);
		b1.root.right.right=new BinaryTreeNode(50);

		b1.addToTheList(b1.root);
		Collections.sort(l1);
		BinaryTreeNode node=b1.bstToBalancedBST(l1, 0, l1.size()-1);
		BinaryTree.levelOrderTraversal(node);
		
	}

}
