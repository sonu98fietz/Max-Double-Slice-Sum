import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//class Solution{
//	 public int solution(int[] A) {
//	        int len = A.length;
//	        int siz= (len)*(len-1)*(len-2);
//	        ArrayList<Integer> list =new ArrayList<Integer>();
//	        for(int i=0;i<len;i++){
//	            list.add(i);
//	        }
//	        ArrayList<String> listmain =new ArrayList<String>();
//	        int n=0;
//	        while(n<siz){
//	            Collections.shuffle(list);
//	            String num = "";
//	            for(int j=0;j<3;j++) {
//	            	num=num+list.get(j);
//	            }
//	            
//	            if(!listmain.contains(num)) {
//	            	listmain.add(num);
//	            }
//	            n++;
//	        }
//	        ArrayList<Integer> maxfind =new ArrayList<Integer>();
//	        int[] arr = new int[3];
//	        for(String h:listmain) {
//	        	int N = Integer.parseInt(h);
//	        	int b=0;
//	        	while(b<=2) {
//	        		int a=N%10;
//	        		arr[b]=a;
//	        		N=N/10;
//	        		b++;
//	        	}
//	        	int X,Y,Z;
//	        	X=arr[0];
//	        	Y=arr[1];
//	        	Z=arr[2];
////	        	System.out.println(X);System.out.println(Y);System.out.println(Z);
////	        	System.out.println("-----------------------------");
//	        	int sum=0;
//	        	if(X<Y) {
//	        		if(Y<Z) {
//	        				for(int k=X+1;k<=Y-1;k++) {
//	    	        			sum=sum+A[k];
////	    	        			System.out.println("---------here--------------------");
//	    	        		}
//	    	        		for(int t=Y+1;t<=Z-1;t++) {
//	    	        			sum=sum+A[t];	
//	    	        		}
//	        		}
//	        		
//	        	}
//	        	
//	        	maxfind.add(sum);
//	        }
//	        int maxvalue = Collections.max(maxfind);
//	        return maxvalue;
//	    }
//}




 class Solution {
	  public int solution(int[] A) {
	    int[] slice1LocalMax = new int[A.length];
	    int[] slice2LocalMax = new int[A.length];
	    System.out.println("Array to find max double slice sum  : ");
	    System.out.println(Arrays.toString(A));
	    System.out.println("-------------------------------" );
	   
	    //start from i=1 because slice can't start at index 0
	    for(int i = 1; i < A.length-1; i++) {
	    	slice1LocalMax[i] = Math.max(slice1LocalMax[i-1] + A[i], 0);}
	    System.out.println(Arrays.toString(slice1LocalMax));
	    System.out.println("-------------------------------" );
	    	   //start from i=A.length-2 because slice can't end at index A.length-1 
	    for(int i = A.length-2; i > 0; i--){
	        slice2LocalMax[i] = Math.max(slice2LocalMax[i+1]+A[i], 0);
	    } System.out.println(Arrays.toString(slice2LocalMax));
	    System.out.println("-------------------------------" );
	    int maxDoubleSliceSum = 0;
	   
	    //compute sums of all slices to find absolute max
	    for(int i = 1; i < A.length-1; i++) {
	    	 System.out.println(slice1LocalMax[i-1] + slice2LocalMax[i+1]);
	      maxDoubleSliceSum = Math.max(maxDoubleSliceSum, slice1LocalMax[i-1] + slice2LocalMax[i+1]);
	    }
	   
	    return maxDoubleSliceSum;
	  }
	}
	
public class doubleSlice {

	public static void main(String[] args) {
		Solution ans = new Solution();
		int result= ans.solution(new int [] {3,2,6,-1,4,5,-1,2});
		System.out.println("-------------------------------" );
		System.out.println("Answer :  "+result);
	}

}
