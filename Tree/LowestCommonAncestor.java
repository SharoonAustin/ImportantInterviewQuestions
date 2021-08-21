package Tree;

public class LowestCommonAncestor {
	static BinaryTreeNode root;
	public static BinaryTreeNode lca(BinaryTreeNode root,int n1,int n2){
		if(root==null)
			return null;
		
		if(root.key==n1 || root.key==n2)
	        return root;
	   
		BinaryTreeNode l=lca(root.left,n1,n2);
		BinaryTreeNode r=lca(root.right,n1,n2);
	    
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
		LowestCommonAncestor b1=new LowestCommonAncestor();
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

	
		System.out.println(lca(b1.root,96,97).key);
	}

}
