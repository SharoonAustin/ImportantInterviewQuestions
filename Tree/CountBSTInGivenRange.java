package Tree;

public class CountBSTInGivenRange {
	BinaryTreeNode root;
	static int count=0;
	public static int getCountOfNode(BinaryTreeNode root,int l, int h){
		
		if(root==null)
			return 0;
		getCountOfNode(root.left,l,h);
		if(root.key>=l && root.key<=h)
			count++;
		getCountOfNode(root.right,l,h);
		
		return count;
	}
	
	public static void main(String[] args) {
		CountBSTInGivenRange b1=new CountBSTInGivenRange();
		b1.root=new BinaryTreeNode(10);
		b1.root.left=new BinaryTreeNode(5);
		b1.root.right=new BinaryTreeNode(50);
		b1.root.left.left=new BinaryTreeNode(1);
		b1.root.right.left=new BinaryTreeNode(40);
		b1.root.right.right=new BinaryTreeNode(100);
		int l=5;
		int h=45;
		System.out.println(getCountOfNode(b1.root,l,h));


	}

}
