package Graphs;

public class WordSearch {

	public boolean exist(char word[][], String myWord){
		int m=0;
		for(int i=0;i<word.length;i++){
			for(int j=0;j<word[0].length;j++){
				if(word[i][j]==myWord.charAt(m) && dfs(word, i, j, 0, myWord))
					return true;
			}
		}
		return false;
	}
	
	public boolean dfs(char word[][], int i, int j, int count, String str){
		if(word.length==count)
			return true;
		
		if(i<0 || j<0 || i>=word.length || j>=word[0].length || word[i][j]!=str.charAt(count))
			return false;
		
		char temp=word[i][j];
		word[i][j]='*';
		boolean found=dfs(word, i,j+1,count+1,str)||
					  dfs(word, i+1,j,count+1,str)||	
					  dfs(word, i,j-1,count+1,str)||
					  dfs(word, i-1,j,count+1,str);
		
		word[i][j]=temp;
		return found;
	}
	
	public static void main(String[] args) {
		char word[][]=new char[][]{
				{'A','N','S','Q'},
				{'S','O','L','R'},
				{'K','T','O','G'}
		};
		
		String myWord[]={"SOLO","NOT","GATE","SOSO"};
		
		WordSearch w1=new WordSearch();
		for(int i=0;i<myWord.length;i++){
		System.out.println(w1.exist(word, myWord[i]));
		}
		
	}

}
