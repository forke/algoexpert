# Given an array of +ve integers represeting coin values. return the minimum amount of change that you cannot make.

import java.util.*;

// The trick is, you keep adding the elements into sum.. and if you encounter a value which is bigger than sum+1.. that means you can't make it
// see vid for exmapantion. but it makes sense

class Program {

  public int nonConstructibleChange(int[] coins) {
		Arrays.sort(coins);
		int sum=0; // names sum, but this will also hold the minimum value we can't make (if the input is like that)
		for(int i=0;i<coins.length;i++){
			if(coins[i]>sum+1) return sum+1;
			sum+=coins[i];
		}
		
    return sum+1;
  }
}
