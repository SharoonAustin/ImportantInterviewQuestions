package Arrays;
import java.util.*;
public class MergeArrays {

	public static void union(int a[], int b[]){
		int length=a.length+b.length;
		int c[]=new int[length];
		int i=0;
		for(;i<a.length;i++)
			c[i]=a[i];
		
		i++;
		int temp[]=new int[a.length];
		System.arraycopy(a, 0, temp, 0, temp.length); 
		Arrays.sort(temp);
		
	
	}

	public static void main(String[] args) {
		int a[]={3,5,10,4,6};
		int b[]={12,4,7,2,5};
		int length=a.length+b.length;
		int c[]=new int[length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length){
			if(a[i]<b[j])
				c[k++]=a[i++];
			else if(a[i]==b[j]){
				c[k++]=a[i++];
				c[k++]=b[j++];
			}
			
			else
				c[k++]=b[j++];
		}
		for(;i<a.length;i++)
			c[k++]=a[i];
		
		for(;j<b.length;j++)
			c[k++]=b[j];
		
		System.out.print(Arrays.toString(c)+" ");
		union(a, b);		
	}

}
