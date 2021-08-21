package Tree;

public class BstHasDeadEnd {
	BinaryTreeNode root;
	
	public boolean isBSTDead(BinaryTreeNode root){
		if(root==null)
			return false;
		return isBSTDeadUtil(root,1,Integer.MAX_VALUE);
	}
	
	public boolean isBSTDeadUtil(BinaryTreeNode root,int min,int max){
		if(root==null)
			return false;
		if(min==max)
			return true;
	
		return isBSTDeadUtil(root.left,min,root.key-1) || isBSTDeadUtil(root.right,root.key+1,max);
	}
	
	public static void main(String[] args) {
		BstHasDeadEnd b1=new BstHasDeadEnd();
		b1.root=new BinaryTreeNode(8);
		b1.root.left=new BinaryTreeNode(5);
		b1.root.right=new BinaryTreeNode(9);
		b1.root.left.left=new BinaryTreeNode(2);
		b1.root.left.right=new BinaryTreeNode(7);
		b1.root.left.left.left=new BinaryTreeNode(1515);
		System.out.println(b1.isBSTDead(b1.root));
		
		/* 8
          /   \ 
        5      9
      /  \     
     2    7 
    /
   1 */   

	}

}
