package Tree;

import java.util.Stack;

public class SpiralTraversal {
	BinaryTreeNode root;
	
	static Stack<BinaryTreeNode> s1=new Stack<BinaryTreeNode>();
    static Stack<BinaryTreeNode> s2=new Stack<BinaryTreeNode>();
    
	public static void spiralTraversal(BinaryTreeNode root){
		s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            while(!s1.isEmpty()){
            BinaryTreeNode temp=s1.pop();
            if(temp!=null){
            System.out.print(temp.key+" ");
            }
            
            if(temp.right!=null)
                s2.push(temp.right);
            
            if(temp.left!=null)
                 s2.push(temp.left);
            }
            
            while(!s2.isEmpty()){
            	BinaryTreeNode temp=s2.pop();
              if(temp!=null){
            	  System.out.print(temp.key+" ");
            }
            
            if(temp.left!=null)
                s1.push(temp.left);
            
            if(temp.right!=null)
                 s1.push(temp.right);
            }
            }
	}
	
	public static void main(String[] args) {
		SpiralTraversal t1=new SpiralTraversal();
		t1.root=new BinaryTreeNode(10);
		t1.root.left=new BinaryTreeNode(20);
		t1.root.right=new BinaryTreeNode(30);
		t1.root.left.left=new BinaryTreeNode(40);
		t1.root.left.right=new BinaryTreeNode(60);
/*		t1.root.right.right=new BinaryTreeNode(4);
		t1.root.right.left=new BinaryTreeNode(5);
*/
		spiralTraversal(t1.root);
	}

}
