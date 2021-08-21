package Tree;
import java.util.*;
public class ReverseLevelOrderTraversal {
	static BinaryTreeNode root;
	
	public void reverseOrderTraversal(BinaryTreeNode root){
		Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		q1.add(root);
		while(!q1.isEmpty()){
			BinaryTreeNode temp=q1.poll();
			stack.push(temp);
			if(temp.right!=null)
				q1.add(temp.right);
			if(temp.left!=null)
				q1.add(temp.left);			
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().key+" ");
		}
	}
	
	public static void main(String[] args) {
		ReverseLevelOrderTraversal b1=new ReverseLevelOrderTraversal();
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.reverseOrderTraversal(b1.root);
	}

}
