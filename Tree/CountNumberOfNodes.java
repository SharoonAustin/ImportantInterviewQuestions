package Tree;

public class CountNumberOfNodes {
	BinaryTreeNode root;
	static int k=0;
	public int numberOfNode(BinaryTreeNode root){
		if(root==null)
			return 1;
		int x=numberOfNode(root.left);
		int y=numberOfNode(root.right);
		
		return x+y;
	}
	
	public void median(BinaryTreeNode root,int median){
		if(root==null)
			return ;
		median(root.left,median);
		k++;
		if(median==k)
			System.out.println(root.key);
		
		median(root.right,median);
		
	}
	
	public static void main(String[] args) {
		CountNumberOfNodes b1=new CountNumberOfNodes();
		b1.root=new BinaryTreeNode(6);
		b1.root.left=new BinaryTreeNode(3);
		b1.root.right=new BinaryTreeNode(8);
		b1.root.left.left=new BinaryTreeNode(1);
		b1.root.left.right=new BinaryTreeNode(4);
		b1.root.right.left=new BinaryTreeNode(7);
		
		//b1.root.right.right=new BinaryTreeNode(4);
		
		int getMedian=(b1.numberOfNode(b1.root))-1;
		
		getMedian=getMedian%2==0?(((getMedian/2) + ((getMedian+1)/2))/2):(getMedian+1)/2;
		
		b1.median(b1.root, getMedian);
	}

}
