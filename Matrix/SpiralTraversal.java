package Matrix;

public class SpiralTraversal {
	
	public static void spiralTraversalOfAMatrix(int graph[][]){
		int top=0,down=graph.length-1,left=0,right=graph[0].length-1,direction=0;
		
		while(top<=down && left<=right){
		
		if(direction==0){
			for(int i=left;i<=right;i++)
				System.out.print(graph[top][i]+" ");
			top+=1;
		}
		
		else if(direction==1){
			for(int i=top; i<=down; i++)
				System.out.print(graph[i][right]+" ");
			right-=1;
		}
		
		
		else if(direction==2){
			for(int i=right; i>=left; i--)
				System.out.print(graph[down][i]+" ");
			down-=1;

		}
		
		else{
			for(int i=down; i>=top; i--)
				System.out.print(graph[i][left]+" ");
			left+=1;
		}
		direction=(direction+1)%4;
		}
	}
	
	public static void main(String[] args) {
		int graph[][]=new int[][]{
				 {1, 2, 3, 4},
			     {5, 6, 7, 8},
			     {9, 10, 11, 12}
		};
		spiralTraversalOfAMatrix(graph);

	}
}
