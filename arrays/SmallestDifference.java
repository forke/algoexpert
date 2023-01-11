/* Problem:

Given 2 arrays of integers (+ve or -ve) , find a pair of integers which have the smallest absolute difference

Ex: coins=[11,5,10,20,28,3] & [26,134,135,15,17] 

answer is 28(from 1st array), 26(from 2nd array)

**/

import java.util.*;

// The trick is, you keep adding the elements into sum.. and if you encounter a value which is bigger than sum+1.. that means you can't make it
// see vid for exmapantion. but it makes sense

class Program {
  public static int[] smallestDifference(int[] a1, int[] a2) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		int p1=0,p2=0,min=Integer.MAX_VALUE, current=Integer.MAX_VALUE;
		int index1=0,index2=0;
		// trick is to always move the small pointer
    while(p1<a1.length&&p2<a2.length){
			current=Math.abs(a1[p1]-a2[p2]); // this wil work in in all cases
			if(current<min){
				min=current;
				index1=p1;index2=p2;
			}
			
			if(a1[p1]<a2[p2]){
				p1++;
			}else{
				p2++;
			}
			
		}
    return new int[] {a1[index1],a2[index2]};
  }
}
