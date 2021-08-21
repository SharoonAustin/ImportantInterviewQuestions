package Tree;
import java.util.*;
public class InorderSuccessorOfAllNodes {
	BinaryTreeNode root;
	static Queue<Integer> queue=new LinkedList<Integer>();

	public void storeInOrder(BinaryTreeNode root){
		queue.clear();
		storeInInOrderUtil(root);
		printTheSuccessor(queue);
	}
	
	public void storeInInOrderUtil(BinaryTreeNode root){
		if(root==null)
			return ;
		storeInInOrderUtil(root.left);
		queue.add(root.key);
		storeInInOrderUtil(root.right);


	}
	
	public void printTheSuccessor(Queue<Integer> queue){
		while(!queue.isEmpty()){
			System.out.print(queue.poll()+"->");
			if(!queue.isEmpty())
				System.out.print(queue.peek()+" ");
		}
		System.out.print(-1);
	}
	
	
	public static void main(String[] args) {
		InorderSuccessorOfAllNodes b1=new InorderSuccessorOfAllNodes();
		b1.root=new BinaryTreeNode(10);
		b1.root.left=new BinaryTreeNode(8);
		b1.root.right=new BinaryTreeNode(12);
		b1.root.left.left=new BinaryTreeNode(3);
		b1.storeInOrder(b1.root);
	}

}

