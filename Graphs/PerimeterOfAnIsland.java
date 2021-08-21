package Graphs;

public class PerimeterOfAnIsland {

	static int count=0;
	 public static int findPerimeter(int[][] mat, int n, int m)
     {
         count=0;
         for(int i=0;i<mat.length;i++){
             for(int j=0;j<mat[0].length;j++){
                 if(mat[i][j]==1){
                  dfs(mat,i,j);               
                 }
             }
         }
         return count;
     }
     
     public static void dfs(int mat[][], int i, int j){
         if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j]==0){
             count++;
             return ;
         }
         if(mat[i][j]==-1) return ;
         
         mat[i][j]=-1;
         
         dfs(mat,i-1,j);
         dfs(mat,i,j+1);
         dfs(mat,i+1,j);
         dfs(mat,i,j-1);
         
     }
	public static void main(String[] args) {
		int mat[][]=new int[][]{
				{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{1, 1, 0, 0}
		};
		System.out.println(new PerimeterOfAnIsland().findPerimeter(mat,0,0));
	}

}
